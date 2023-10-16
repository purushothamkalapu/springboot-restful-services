package com.purushotham.springbootrestfulservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info = @Info(
                title = "Springboot Rest API Documentation",
                description = "Spring Boot API Documentation",
                version ="1.0.0",
                contact = @Contact(
                        name = "Purushotham",
                        email = "srikalapu86@gmail.com",
                        url = "http://www.sritech.com"),
                license =@License(
                        name = "Apache License, Version 2.0",
                        url = "http://www.apache.org/licenses/"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Springboot User Management",
                url = "http://www.sritech.com/user_management.html"
        )
)
@SpringBootApplication
public class SpringbootRestfulServiceApplication {
   /* @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulServiceApplication.class, args);
    }

}
