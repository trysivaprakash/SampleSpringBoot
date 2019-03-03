package com.myorg.samplespringboot.simulation

import com.myorg.samplespringboot.scenario.SampleSpringBootScenario
import com.myorg.samplespringboot.util.Environment
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PerformanceSimulation extends Simulation{
  val httpConf = http.baseURL(Environment.baseURL).acceptHeader("application/json")

  val sampleSimulation =
    SampleSpringBootScenario.sampleScenario.inject(atOnceUsers(100))

  setUp(sampleSimulation).protocols(httpConf);
}
