package com.teletrac.navman.teletrac.navman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApi {

	@Bean

	public OpenAPI customOpenAPI() {
//http://localhost:8085/swagger-ui/index.html
		return new OpenAPI().info(new Info()

				.title("Teletrac_Navman API")
				.version("0.0.1-SNAPSHOT")
				.description("Teletrac_Navman")
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}

}
