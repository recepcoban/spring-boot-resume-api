package com.rcoban.resume.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Spring Boot Resume API")
                .version("0.0.1-SNAPSHOT")
                .description("Spring Boot Resume API for creating, modifying resume whatever you need.")
                .license(new License()
                        .name("GNU General Public License v3.0")
                        .url("https://www.gnu.org/licenses/gpl-3.0.html"))
                .contact(new Contact()
                        .name("Recep Çoban")
                        .email("recep-coban@yandex.com")
                        .url("https://www.linkedin.com/in/recepcoban")));
    }

}
