package com.myorg.perfmotor.controller;

import com.myorg.perfmotor.beans.PerfMotorExecVars;
import com.myorg.perfmotor.beans.ServiceDetails;
import com.myorg.perfmotor.gatling.PerfMotorEnvHolder;
import com.myorg.perfmotor.util.Assister;
import com.myorg.perfmotor.util.PerfMotorException;
import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class PerfMotorRouter {

    private final String reportPath = System.getProperty("user.dir") + "/src/main/gatling/reports";
    private final String simulationClass = "com.myorg.perfmotor.gatling.PerfMotorSimulation";
    private final String dataDirectory = System.getProperty("user.dir") + "/src/main/gatling/data";

    @RequestMapping(method = RequestMethod.GET, value = "/perfMotor.html")
    public String loadServiceDetails(HttpServletRequest request) {
        StringBuilder url = getUrl(request);
        try {
            ClassPathScanningCandidateComponentProvider scanner =
                    new ClassPathScanningCandidateComponentProvider(true);
            scanner.addIncludeFilter(new AnnotationTypeFilter(org.springframework.stereotype.Controller.class));

            Class<?> clazz = null;
            ServiceDetails serviceDetails;
            for (BeanDefinition bd : scanner.findCandidateComponents("com.myorg.samplespringboot")) {
                serviceDetails = new ServiceDetails();
                try {
                    clazz = Class.forName(bd.getBeanClassName());
                    String basePath = Assister.getBasePath(clazz);
                    if (null != basePath) {
                        serviceDetails.setBasePath(basePath);
                        Assister.getEndPointDetails(clazz);
                    }
                } catch (ClassNotFoundException e) {
                    throw new PerfMotorException("Exception in finding base path", e);
                }
            }
        } catch (PerfMotorException e) {
            //TODO implement
        }
        return url.toString();
    }

    private StringBuilder getUrl(HttpServletRequest request) {
        StringBuilder url = new StringBuilder()
                .append(request.getScheme())
                .append("://")
                .append(request.getServerName());
        if (-1 != request.getServerPort()) {
            url.append(":").append(request.getServerPort());
        }
        return url;
    }

    @RequestMapping(value = "/runPerformanceTest", method = RequestMethod.GET)
    @ResponseBody
    public String runPerformanceTest(HttpServletRequest httpServletRequest) throws PerfMotorException {
        //String baseUrl = "http://localhost:8080/students/${USER_ID}";
        String baseUrl = "http://localhost:8082/ford/cars";
        String httpMethod = "GET";
        String contentType = "application/json";

        GatlingPropertiesBuilder props = new GatlingPropertiesBuilder();
        props.simulationClass(simulationClass);
        props.resultsDirectory(reportPath);
        props.dataDirectory(dataDirectory);
        

        PerfMotorExecVars perfMotorExecVars = new PerfMotorExecVars();
        perfMotorExecVars.setBaseUrl(baseUrl);
        perfMotorExecVars.setMaxRespTime(50);
        perfMotorExecVars.setRequestName("Sample Request Name");
        perfMotorExecVars.setScenarioName("Sample Scenario Name");

        PerfMotorEnvHolder.baseUrl_$eq(baseUrl);
        PerfMotorEnvHolder.maxRespTime_$eq(500);
        PerfMotorEnvHolder.requestName_$eq("Sample_req");
        PerfMotorEnvHolder.scenarioName_$eq("sample scen");
        PerfMotorEnvHolder.loopCount_$eq(2);
        PerfMotorEnvHolder.rampUp_$eq(10);
        PerfMotorEnvHolder.token_$eq("beare "+httpServletRequest.getHeader("Authorization"));
        //PerfMotorEnvHolder.dataDirectory_$eq(dataDirectory);
        //PerfMotorEnvHolder.httpMethod_$eq(httpMethod);

        executeRun(props);
        return "All complete";
    }

    private void executeRun(GatlingPropertiesBuilder props) throws PerfMotorException {

        try {
            FileUtils.deleteDirectory(new File(reportPath));
            Gatling.fromMap(props.build());
        } catch (IOException e) {
            throw new PerfMotorException("Exception while deleting existing report file", e);
        }
    }

}
