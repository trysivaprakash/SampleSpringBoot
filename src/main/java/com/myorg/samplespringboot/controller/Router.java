package com.myorg.samplespringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sample")
@Api(value = "SampleApplication", description = "To demo",
    position = 1)
public class Router {

  @RequestMapping(method = RequestMethod.GET, path = "/message")
  @ApiOperation(value = "To get a welcome message",
      notes = "To return the message", response = String.class, httpMethod = "GET")
  @ApiResponses(value = {
      @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
      @ApiResponse(code = 500, message = "Internal server error")
  })
  public String message() {
    return "Welcome to Sample Spring Boot Application!";
  }
}
