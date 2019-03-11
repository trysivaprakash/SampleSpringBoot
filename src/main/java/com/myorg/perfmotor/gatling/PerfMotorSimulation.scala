package com.myorg.perfmotor.gatling

import io.gatling.core.Predef.Simulation
import io.gatling.core.Predef.configuration
import io.gatling.http.Predef.http
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PerfMotorSimulation() extends Simulation {
  val httpConf = http(configuration).baseURL(PerfMotorEnvHolder.baseUrl).disableWarmUp
  val maxRespTime = PerfMotorEnvHolder.maxRespTime

  val perfMotorScenario = scenario(PerfMotorEnvHolder.scenarioName)
    .exec(http(PerfMotorEnvHolder.requestName).get("/sample/message")
      .check(status is 200).check(responseTimeInMillis lessThan maxRespTime));

  val perfMotorSimulation = perfMotorScenario.inject(atOnceUsers(100))

  setUp(perfMotorSimulation).protocols(httpConf)
}
