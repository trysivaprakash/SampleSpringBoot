package com.myorg.samplespringboot.util

object Environment {
  val baseURL = scala.util.Properties.envOrElse("baseURL", "http://localhost:8082")
  val maxResponseTime = scala.util.Properties.envOrElse("maxResponseTime", "500") // in milliseconds
}
