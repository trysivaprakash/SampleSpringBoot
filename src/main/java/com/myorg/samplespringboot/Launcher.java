package com.myorg.samplespringboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("com.myorg")
@EnableSwagger2
public class Launcher {
	
	private static ConfigurableApplicationContext context;

  public static void main(String[] args) {
	  context = SpringApplication.run(Launcher.class, args);
  }
  
  public static void restart() {
      ApplicationArguments args = context.getBean(ApplicationArguments.class);

      Thread thread = new Thread(() -> {
          context.close();
          context = SpringApplication.run(Launcher.class, args.getSourceArgs());
      });

      thread.setDaemon(false);
      thread.start();
  }
}
