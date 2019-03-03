package com.myorg.samplespringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Api(value = "Swagger", description = "Endpoint for swagger management",
    position = 1, hidden = true)
public class SwaggerRouter {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    @ApiOperation(value = "Swagger Documentation",
        notes = "Redirects default uri to swagger documentation", hidden = true)
    public ModelAndView getApiInfo() {
      return new ModelAndView("redirect:/swagger-ui.html");
    }
}
