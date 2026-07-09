package com.pravin.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservices REST Api Documentation",
                description =  "Pravin accounts microservices REST api Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Pravin swain",
                        email = "pravinswain232@gmail.com",
                        url = "https://pravin-portfolio-theta.vercel.app"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://pravin-portfolio-theta.vercel.app"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Pravin swain accounts microservices REST api documentation",
                url = "https://pravin-portfolio-theta.vercel.app"
        )

)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
