package com.myorg.samplespringboot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.samplespringboot.domain.SimpleMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
    //POST STARTS FROM HERE
    @RequestMapping(method = RequestMethod.POST, path = "/cars")
    @ApiOperation(value = "This is POST",
        notes = "To return the message", response = String.class, httpMethod = "POST")
    @ApiResponses(value = {
        @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public String postThis(
        @ApiParam("body")  @RequestBody SimpleMessage cars
    ) {
        System.out.println("Add your cars like Mustang, Fusion, GT ... etc "+ cars.getContent()) ;
        return "The below cars you have added\n"+cars.getContent();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/cars/colors")
    @ApiOperation(value = "POST with BODY",
        notes = "To return the message", response = String.class, httpMethod = "POST")
    @ApiResponses(value = {
        @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public String posttWithQuery(@ApiParam("Body") @RequestBody String body) {
        System.out.println("Mustang, F150 cars are available in color - " + body);
        return "WOW we added below colors to Mustang\n" + body;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/cars/{carName}/price")
    @ApiOperation(value = "POST with Header,body  and PATH Params",
        notes = "To return the message", response = String.class, httpMethod = "POST",consumes =MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiResponses(value = {
        @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public String postWithBodyAndPath(@ApiParam("Auth token") @RequestHeader("token") String token,
        @ApiParam("body")  @RequestBody String body,
        @ApiParam("Name of the car") @PathVariable("carName") String carName) {
        System.out.println("Given token - " + token + " is not authorized. Can not show the price of the " + carName);

        return "Given token - " + token + " is not authorized. Can not show the price of the " + carName+"request body is:"+body;


    }

    @RequestMapping(method = RequestMethod.POST, path = "/cars/{carName}" , headers="Content-Type=multipart/form-data")
    @ApiOperation(value = "POST with Header,body  and PATH Params",
        notes = "To return the message", response = String.class, httpMethod = "POST")
    @ApiResponses(value = {
        @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public String postWithBodyAndFormData(@ApiParam("Auth token") @RequestHeader("token") String token,
        @RequestParam("model") String model,
        @ApiParam("Name of the car") @PathVariable("carName") String carName) {
        System.out.println("Given token - " + token + " is not authorized. Can not show the price of the " + carName+"Model is:"+model);



        return "Given token - " + token + " is not authorized. Can not show the price of the " + carName+"request body is:";


    }

    //PUT STARTS FROM HERE

    @PutMapping("/cars")
    @ApiOperation(value = "This is UPDATE",
        notes = "To return the message", response = String.class, httpMethod = "PUT")
    @ApiResponses(value = {
        @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public String putThis(@ApiParam("Auth token") @RequestHeader("token") String token,
    		@ApiParam("body")  @RequestBody SimpleMessage cars
    ) {
        System.out.println("Add your cars like Mustang, Fusion, GT ... etc " + cars.getContent());
        return "The below cars you have Updated with new features\n"+cars.getContent();
    }

    @PutMapping("/cars/colors")
    @ApiOperation(value = "UPDATE with Body ",
        notes = "To return the message", response = String.class, httpMethod = "PUT")
    @ApiResponses(value = {
        @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public String putWithQuery(@ApiParam("Body") @RequestBody String body) {
        System.out.println("Mustang, F150 cars are available in color - " + body);
        return "WOW now we have updated Mustang with latest colors\n" + body;
    }

    @PutMapping("/cars/{carName}/price")
    @ApiOperation(value = "UPDATE with Header,body  and PATH Params",
        notes = "To return the message", response = String.class, httpMethod = "PUT",consumes =MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiResponses(value = {
        @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public String putWithBodyAndPath(@ApiParam("Auth token") @RequestHeader("token") String token,
        @ApiParam("body")  @RequestBody String body,
        @ApiParam("Name of the car") @PathVariable("carName") String carName) {
        System.out.println("Given token - " + token + " is not authorized. Can not show the price of the " + carName);

        return "Given token - " + token + " is not authorized. The Prices are updated.Below are the new prices " + carName+"Price is:"+body;


    }

//DELETE STARTS FROM HERE

    @DeleteMapping("/cars/{carName}")
    @ApiOperation(value = "This is DELETE",
        notes = "To return the message", response = String.class, httpMethod = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public String deleteThis(@ApiParam("Auth token") @RequestHeader("token") String token,
        @ApiParam("Name of the car") @PathVariable("carName") String carName
    ) {
        System.out.println("Add your cars like Mustang, Fusion, GT ... etc");
        return "The below cars we are no more manufacturing\n"+carName;
    }

    @DeleteMapping("/cars/colors/{colorName}")
    @ApiOperation(value = "Delete with PATH Param",
        notes = "To return the message", response = String.class, httpMethod = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public String DeleteWithQuery(@ApiParam("Color of the car") @PathVariable("colorName") String colorName) {
        System.out.println("Mustang, F150 cars are available in color - " + colorName);
        return "Customers are not interesting no more with the below Mustand Color" + colorName+"So we are no more manufactring this.";
    }


    @DeleteMapping("/cars/colors/{carName}/{modelYear}")
    @ApiOperation(value = "Delete with multy PATH Params",
        notes = "To return the message", response = String.class, httpMethod = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public String DeleteWithQueryAndPath(@ApiParam("Name of the car") @PathVariable("carName") String carName,
        @ApiParam("Model year of the car") @PathVariable("modelYear") int modelYear
    ) {
        //System.out.println(carName + " - car of model year - " + modelYear + " is available in color - " + colorName);
        return carName + " - car of model year - " + modelYear + " is no more manufacturing - " ;
    }
    /*@DeleteMapping("/cars/{carName}/price")
    @ApiOperation(value = "POST with Header,body  and PATH Params",
            notes = "To return the message", response = String.class, httpMethod = "DELETE",consumes =MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 422, message = "Unprocessable Entity (Invalid request content)."),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String putWithBodyAndPath(@ApiParam("Auth token") @RequestHeader("token") String token,
    		@ApiParam("body")  @RequestBody String body,
                                            @ApiParam("Name of the car") @PathVariable("carName") String carName) {
        System.out.println("Given token - " + token + " is not authorized. Can not show the price of the " + carName);

        return "Given token - " + token + " is not authorized. The Prices are updated.Below are the new prices " + carName+"Price is:"+body;


    }*/



}