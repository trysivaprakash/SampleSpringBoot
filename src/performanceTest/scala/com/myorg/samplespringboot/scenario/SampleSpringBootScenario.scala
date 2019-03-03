package com.myorg.samplespringboot.scenario

import com.myorg.samplespringboot.util.Environment
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object SampleSpringBootScenario {

  val sampleScenario = scenario("Service returning 200")
    .exec(http("Get project name").get("/sample/message")
    .check(status is 200)
    .check(responseTimeInMillis lessThan Integer.parseInt(Environment.maxResponseTime)));
}
