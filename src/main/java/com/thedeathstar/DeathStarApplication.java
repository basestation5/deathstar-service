package com.thedeathstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by eg5267 on 6/19/17.
 */

@SpringBootApplication
@EnableSwagger2
public class DeathStarApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeathStarApplication.class, args);
    }

    @Bean
    public Docket eventsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thedeathstar.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}

