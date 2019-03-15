package com.myorg.perfmotor.gatling

import scala.util.Random
import scala.util.parsing.json._
import io.gatling.core.Predef.Simulation
import io.gatling.core.Predef.configuration
import io.gatling.http.Predef.http
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PerfMotorSimulation extends Simulation {
  val httpConf = http(configuration).baseURL(PerfMotorEnvHolder.baseUrl).disableWarmUp
  val maxRespTime = PerfMotorEnvHolder.maxRespTime
  
  val header = Map(
  "Authorization" -> PerfMotorEnvHolder.token
  )
  
  var flag = false;
  var jsonBOdyFlag = true;
  
  try {
    println(">>>>>>>>> checking feeder file on path : "+PerfMotorEnvHolder.dataDirectory)
   val bulkCsvRequestData  = csv(PerfMotorEnvHolder.dataDirectory).circular
  println(">>>>>>>>>>>>> userData in PerfMotor Simulation : "+bulkCsvRequestData)
    flag = true;
  }
  catch {
    case exception : Exception => {
      flag = false;
      println(">>>>>>exception occured while reading csv, probable cuase...no feeder data provided.")
    }
  }
  
  if("".equals(PerfMotorEnvHolder.test)) {
    jsonBOdyFlag = false;
  }
  println(">>>>>>> feederDataFlag : "+flag)
  println(">>>>>>> jsonBodyDataFlag : "+jsonBOdyFlag)
  println(">>>>>>> jsonBodyData : "+PerfMotorEnvHolder.test)
  println("request method : >>>>  " +  PerfMotorEnvHolder.httpMethod )
  println("evaluate : >>>>  " +  (flag && ("GET".equals(PerfMotorEnvHolder.httpMethod) )))
  
  
  val temp = PerfMotorEnvHolder.loopCount*PerfMotorEnvHolder.rampUp
  
  val feeder = Iterator.continually(Map("emailllllll" -> (Random.alphanumeric.take(temp).mkString + "@foo.com"))) 
  


  
  
  if((!flag) && ("GET".equals(PerfMotorEnvHolder.httpMethod))) {

    val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
      .repeat(PerfMotorEnvHolder.loopCount, "n")(
        exec(
          http(PerfMotorEnvHolder.requestName)
            .httpRequest(PerfMotorEnvHolder.httpMethod, PerfMotorEnvHolder.baseUrl)
            .headers(header)
            .check(status.is(200))))
            
    val perfMotorSimulation = perfMotorScenario.inject(atOnceUsers(PerfMotorEnvHolder.rampUp))

    setUp(perfMotorSimulation).protocols(httpConf)
      .assertions(
  	//forAll.reponseTime.max.lt(1000)
  ) 
   
  } else if ((flag) && ("GET".equals(PerfMotorEnvHolder.httpMethod))) {
    println(">>>>>>>> here i am")
    val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
      .feed(csv(PerfMotorEnvHolder.dataDirectory).circular)
      .repeat(PerfMotorEnvHolder.loopCount, "n")(
        exec(
          http(PerfMotorEnvHolder.requestName)
            .httpRequest(PerfMotorEnvHolder.httpMethod, PerfMotorEnvHolder.baseUrl)
            .headers(header)
            .check(status.is(200))))

    val perfMotorSimulation = perfMotorScenario.inject(atOnceUsers(PerfMotorEnvHolder.rampUp))

    setUp(perfMotorSimulation).protocols(httpConf)
      .assertions( //forAll.reponseTime.max.lt(1000)
      )

  } else if (flag && ((("PUT".equals(PerfMotorEnvHolder.httpMethod))) || ("POST".equals(PerfMotorEnvHolder.httpMethod)))) {

    val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
      .feed(csv(PerfMotorEnvHolder.dataDirectory).circular)
      .repeat(PerfMotorEnvHolder.loopCount, "n")(
        exec(
          http(PerfMotorEnvHolder.requestName)
            .httpRequest(PerfMotorEnvHolder.httpMethod, PerfMotorEnvHolder.baseUrl)
            .headers(header)
            .body(StringBody(PerfMotorEnvHolder.test)).asJSON
            .check(status.is(200))))

    val perfMotorSimulation = perfMotorScenario.inject(atOnceUsers(PerfMotorEnvHolder.rampUp))

    setUp(perfMotorSimulation).protocols(httpConf)
      .assertions( //forAll.reponseTime.max.lt(1000)
      )

  } else if ((!flag) && (("PUT".equals(PerfMotorEnvHolder.httpMethod)) || ("POST".equals(PerfMotorEnvHolder.httpMethod)))) {

    val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
      .repeat(PerfMotorEnvHolder.loopCount, "n")(
        exec(
          http(PerfMotorEnvHolder.requestName)
            .httpRequest(PerfMotorEnvHolder.httpMethod, PerfMotorEnvHolder.baseUrl)
            .headers(header)
            .body(StringBody(PerfMotorEnvHolder.test)).asJSON
            .check(status.is(200))))
            

    val perfMotorSimulation = perfMotorScenario.inject(atOnceUsers(PerfMotorEnvHolder.rampUp))

    setUp(perfMotorSimulation).protocols(httpConf)
      .assertions( //forAll.reponseTime.max.lt(1000)
      )

  }else if ((flag) && ("DELETE".equals(PerfMotorEnvHolder.httpMethod))) {

    val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
      .feed(csv(PerfMotorEnvHolder.dataDirectory).circular)
      .repeat(PerfMotorEnvHolder.loopCount, "n")(
        exec(
          http(PerfMotorEnvHolder.requestName)
            .httpRequest(PerfMotorEnvHolder.httpMethod, PerfMotorEnvHolder.baseUrl)
            .headers(header)
            .check(status.is(200))))

    val perfMotorSimulation = perfMotorScenario.inject(atOnceUsers(PerfMotorEnvHolder.rampUp))

    setUp(perfMotorSimulation).protocols(httpConf)
      .assertions( //forAll.reponseTime.max.lt(1000)
      )

  }else if ((!flag) && ("DELETE".equals(PerfMotorEnvHolder.httpMethod))) {

    val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
      .repeat(PerfMotorEnvHolder.loopCount, "n")(
        exec(
          http(PerfMotorEnvHolder.requestName)
            .httpRequest(PerfMotorEnvHolder.httpMethod, PerfMotorEnvHolder.baseUrl)
            .headers(header)
            .check(status.is(200))))

    val perfMotorSimulation = perfMotorScenario.inject(atOnceUsers(PerfMotorEnvHolder.rampUp))

    setUp(perfMotorSimulation).protocols(httpConf)
      .assertions( //forAll.reponseTime.max.lt(1000)
      )

  }
  
}
