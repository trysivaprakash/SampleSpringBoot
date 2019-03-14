package com.myorg.perfmotor.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ConfigData {
	
	int requestCount;
	
	int loopCount;
	
	String endpointUrl;
	
	String requestMethod;
}
