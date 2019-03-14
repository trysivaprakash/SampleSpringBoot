//package com.myorg.samplespringboot.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//@EnableWebMvc
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//
//	// Static Resource Config
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//		// Css resource.
//		registry.addResourceHandler("/style/**") //
//				.addResourceLocations("/views/**").setCachePeriod(31556926);
//
//	}
//
//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
//
//}
