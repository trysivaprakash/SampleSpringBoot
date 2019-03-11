package com.myorg.perfmotor.gatling

object PerfMotorEnvHolder {

//  val perfMotorExecVars = new PerfMotorExecVars

  var baseUrl = ""
  var maxRespTime = 0
  var scenarioName = ""
  var requestName = ""

//  val baseUrl = scala.util.Properties.envOrElse("baseURL", "")

  /*val baseURL = scala.util.Properties.envOrElse("baseURL", "")
  val maxResponseTime = scala.util.Properties.envOrElse("maxResponseTime", "240000") // in milliseconds*/
}
