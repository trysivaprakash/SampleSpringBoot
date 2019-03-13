package com.myorg.samplespringboot.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ford")
@Api(value = "Sample FORD Application", description = "To demo",
        position = 1)
public class Router {

    @RequestMapping(method = RequestMethod.GET, path = "/cars")
    @ApiOperation(value = "Just a GET",
            notes = "To return the message", response = String.class, httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String justAGet() {
        System.out.println("Mustang, Fusion, GT ... etc");
        return "Mustang, Fusion, GT ... etc";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/cars/colors")
    @ApiOperation(value = "GET with Query Params",
            notes = "To return the message", response = String.class, httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String getWithQuery(@ApiParam("Name of the color name") @RequestParam("colorName") String colorName) {
        System.out.println("Mustang, F150 cars are available in color - " + colorName);
        return "Mustang, F150 cars are available in color - " + colorName;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/cars/colors/{carName}")
    @ApiOperation(value = "GET with PATH Params",
            notes = "To return the message", response = String.class, httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String getWithPath(@ApiParam("Name of the car") @PathVariable("carName") String carName) {
        System.out.println("Yellow, Black and White colors are available for - " + carName);
        return "Yellow, Black and White colors are available for - " + carName;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/cars/colors/{carName}/{modelYear}")
    @ApiOperation(value = "GET with Query and PATH Params",
            notes = "To return the message", response = String.class, httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String getWithQueryAndPath(@ApiParam("Name of the car") @PathVariable("carName") String carName,
                                      @ApiParam("Model year of the car") @PathVariable("modelYear") int modelYear,
                                      @ApiParam("Name of the color") @RequestParam("colorName") String colorName) {
        System.out.println(carName + " - car of model year - " + modelYear + " is available in color - " + colorName);
        return carName + " - car of model year - " + modelYear + " is available in color - " + colorName;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/cars/{carName}/price")
    @ApiOperation(value = "GET with Header, Query and PATH Params",
            notes = "To return the message", response = String.class, httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String getWithHeaderQueryAndPath(@ApiParam("Auth token") @RequestHeader("token") String token,
                                            @ApiParam("Name of the car") @PathVariable("carName") String carName) {
        System.out.println("Given token - " + token + " is not authorized. Can not show the price of the " + carName);
        return "Given token - " + token + " is not authorized. Can not show the price of the " + carName;
    }
}
