package com.myorg.perfmotor.gatling

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
  var postJson = RawFileBody("/postBody.json")
  println(">>>>>>>>>>>>>>>>>: "+bulkCsvRequestData)
  //val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
  if(null != bulkCsvRequestData) {
  
  }
  
  //base url should be in this format
  val baseUrl = "http://localhost:8080/sample/message/${USER_ID}"

  val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
  	.doIf(null !=bulkCsvRequestData) {
  	 feed(bulkCsvRequestData)  	 
  	}
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

  val perfMotorSimulation = perfMotorScenario.inject(atOnceUsers(PerfMotorEnvHolder.rampUp))

  setUp(perfMotorSimulation).protocols(httpConf)
  //.assertions(
  	//forAll.reponseTime.max.lt(1000)
  //)
}
