package com.test.meetgamer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.regex("/api.*"))                         
          .build();                                           
    }

	private ApiInfo getInfo() {
		return new ApiInfoBuilder().title("MeetGamer")
				.description("MeetGamer is an application to meet your fellow games based on your interest. Tired of playing your co-op games alone? Use MeetGamer to matchmake yourself with people who play the same game as you.")
				.build();
	}
	
}
