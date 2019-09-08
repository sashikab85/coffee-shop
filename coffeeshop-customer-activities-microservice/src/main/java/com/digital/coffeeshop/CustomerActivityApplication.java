package com.digital.coffeeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableSwagger2
public class CustomerActivityApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CustomerActivityApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.digital.coffeeshop.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        //TODO: replace deprecated method
        return new ApiInfo(
                "Coffee Shop API Services",
                "Coffee Shop APIs ",
                "V1.0",
                "Terms of service",
                "sashikab85@gmail.com",
                "101digital",
                "http://www.101digital.com");
    }

}