package com.myorg.perfmotor.gatling

import scala.util.Random
import io.gatling.core.Predef.Simulation
import io.gatling.core.Predef.configuration
import io.gatling.http.Predef.http
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PerfMotorSimulation() extends Simulation {
  val httpConf = http(configuration).baseURL(PerfMotorEnvHolder.baseUrl).disableWarmUp
  val maxRespTime = PerfMotorEnvHolder.maxRespTime
  
  val header = Map(
  "Authorization" -> PerfMotorEnvHolder.token
  )
  
  val bulkCsvRequestData = csv("/UserData.csv").circular;
  
  val temp = PerfMotorEnvHolder.loopCount*PerfMotorEnvHolder.rampUp
  
  val feeder = Iterator.continually(Map("emailllllll" -> (Random.alphanumeric.take(temp).mkString + "@foo.com")))


  val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
  	.doIf(null !=bulkCsvRequestData && ("GET".equals(PerfMotorEnvHolder.httpMethod))) {
  	 feed(bulkCsvRequestData)  	
  	   	.repeat(PerfMotorEnvHolder.loopCount, "n") {
      exec(
	      http(PerfMotorEnvHolder.requestName)
	      .httpRequest("GET", PerfMotorEnvHolder.baseUrl)
	      .headers(header)
	      //.body(postJson)
	      .check(status.is(200))
	      //.check(responseTimeInMillis lessThan maxRespTime))
	      //.check(bodyString.saveAs("response")))
      //.exec{
      	//session => 
      		//println(session("response").as[String])
      		//session
      //}	
   )}
  	}
  .doIf(null !=bulkCsvRequestData && ("POST".equals(PerfMotorEnvHolder.httpMethod))){
  	 feed(bulkCsvRequestData)  	
  	   	.repeat(PerfMotorEnvHolder.loopCount, "n") {
      exec(
	      http(PerfMotorEnvHolder.requestName)
	      .httpRequest("GET", PerfMotorEnvHolder.baseUrl)
	      .headers(header)
	      .body(RawFileBody("/postBody.json"))
	      .check(status.is(200))
   )}}
    .doIf("GET".equals(PerfMotorEnvHolder.httpMethod)){
  	 feed(feeder)  	
  	   	.repeat(PerfMotorEnvHolder.loopCount, "n") {
      exec(
	      http(PerfMotorEnvHolder.requestName)
	      .httpRequest("GET", PerfMotorEnvHolder.baseUrl)
	      .headers(header)
	      .check(status.is(200))
   )}}
  .doIf("POST".equals(PerfMotorEnvHolder.httpMethod)){
  	 feed(feeder)  	
  	   	.repeat(PerfMotorEnvHolder.loopCount, "n") {
      exec(
	      http(PerfMotorEnvHolder.requestName)
	      .httpRequest("GET", PerfMotorEnvHolder.baseUrl)
	      .headers(header)
	      .body(RawFileBody("/postBody.json"))
	      .check(status.is(200))
   )}}


  val perfMotorSimulation = perfMotorScenario.inject(atOnceUsers(PerfMotorEnvHolder.rampUp))

  setUp(perfMotorSimulation).protocols(httpConf)
  .assertions(
  	//forAll.reponseTime.max.lt(1000)
  )
}
