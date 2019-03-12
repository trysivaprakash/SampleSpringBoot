package com.myorg.perfmotor.gatling

object PerfMotorEnvHolder {

//  val perfMotorExecVars = new PerfMotorExecVars

  var baseUrl = ""
  var maxRespTime = 0
  var scenarioName = ""
  var requestName = ""
  
  var token = ""
  var loopCount = 20;
  var rampUp = 100;

//  val baseUrl = scala.util.Properties.envOrElse("baseURL", "")

  /*val baseURL = scala.util.Properties.envOrElse("baseURL", "")
  val maxResponseTime = scala.util.Properties.envOrElse("maxResponseTime", "240000") // in milliseconds*/
}
