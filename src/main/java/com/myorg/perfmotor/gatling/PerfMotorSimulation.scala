package com.myorg.perfmotor.gatling

import scala.util.Random
import scala.util.parsing.json._
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
  
  var flag = true;
  var jsonBOdyFlag = true;
  
  try {
   val bulkCsvRequestData  = csv("/dcarData.csv").circular
  println(">>>>>>>>>>>>> userData : "+bulkCsvRequestData)
  }
  catch {
    case exception : Exception => {
      flag = false;
    }
  }
  
  if("".equals(PerfMotorEnvHolder.test)) {
    jsonBOdyFlag = false;
  }
  println(">>>>>>> feederDataFlag : "+flag)
  println(">>>>>>> jsonBodyDataFlag : "+jsonBOdyFlag)
   println(">>>>>>> jsonBodyData : "+jsonBOdyFlag)
  
  
  val temp = PerfMotorEnvHolder.loopCount*PerfMotorEnvHolder.rampUp
  
  val feeder = Iterator.continually(Map("emailllllll" -> (Random.alphanumeric.take(temp).mkString + "@foo.com")))


  val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
  	.doIf(flag && ("GET".equals(PerfMotorEnvHolder.httpMethod))) {
  	 feed(csv("/carData.csv").circular)  	
  	   	.repeat(PerfMotorEnvHolder.loopCount, "n") {
      exec(
	      http(PerfMotorEnvHolder.requestName)
	      .httpRequest("GET", PerfMotorEnvHolder.baseUrl)
	      .headers(header)
	      .check(status.is(200))
   )}
  	}
  .doIf(flag && ("POST".equals(PerfMotorEnvHolder.httpMethod))){
  	 feed(csv("/carData.csv").circular)  	
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
  .doIf(("POST".equals(PerfMotorEnvHolder.httpMethod)) && jsonBOdyFlag){
  	 feed(feeder)  	
  	   	.repeat(PerfMotorEnvHolder.loopCount, "n") {
      exec(
	      http(PerfMotorEnvHolder.requestName)
	      .httpRequest("GET", PerfMotorEnvHolder.baseUrl)
	      .headers(header)
	      .body(StringBody("""{ "myContent": "myHardCodedValue" }"""))
	      .check(status.is(200))
   )}}
  .doIf(flag && ("PUT".equals(PerfMotorEnvHolder.httpMethod))){
  	 feed(csv("/carData.csv").circular)  	
  	   	.repeat(PerfMotorEnvHolder.loopCount, "n") {
      exec(
	      http(PerfMotorEnvHolder.requestName)
	      .httpRequest("GET", PerfMotorEnvHolder.baseUrl)
	      .headers(header)
	      .body(RawFileBody("/postBody.json"))
	      .check(status.is(200))
   )}}
  .doIf("PUT".equals(PerfMotorEnvHolder.httpMethod)){
  	 feed(csv("/carData.csv").circular)  	
  	   	.repeat(PerfMotorEnvHolder.loopCount, "n") {
      exec(
	      http(PerfMotorEnvHolder.requestName)
	      .httpRequest("GET", PerfMotorEnvHolder.baseUrl)
	      .headers(header)
	      .body(RawFileBody("/postBody.json"))
	      .check(status.is(200))
   )}}
  .doIf(flag && ("DELETE".equals(PerfMotorEnvHolder.httpMethod))){
  	 feed(csv("/carData.csv").circular)  	
  	   	.repeat(PerfMotorEnvHolder.loopCount, "n") {
      exec(
	      http(PerfMotorEnvHolder.requestName)
	      .httpRequest("GET", PerfMotorEnvHolder.baseUrl)
	      .headers(header)
	      .check(status.is(200))
   )}}
  .doIf("DELETE".equals(PerfMotorEnvHolder.httpMethod)){
  	 feed(csv("/carData.csv").circular)  	
  	   	.repeat(PerfMotorEnvHolder.loopCount, "n") {
      exec(
	      http(PerfMotorEnvHolder.requestName)
	      .httpRequest("GET", PerfMotorEnvHolder.baseUrl)
	      .headers(header)
	      .check(status.is(200))
   )}}


  val perfMotorSimulation = perfMotorScenario.inject(atOnceUsers(PerfMotorEnvHolder.rampUp))

  setUp(perfMotorSimulation).protocols(httpConf)
  .assertions(
  	//forAll.reponseTime.max.lt(1000)
  )
}
