package com.eagle.mailer.config.swagger;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "com.eagle.mailer";
	private static final String PARAMETER_TYPE_HEADER = "header";
	private static final String MODEL_REF_STRING = "string";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo()).globalOperationParameters(parameters());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Mailer Service").description("Mailer Service REST API").version("1.0.0")
				.build();
	}
	
	private List<Parameter> parameters() {
		Parameter clientId = parameter("Client-ID", PARAMETER_TYPE_HEADER, MODEL_REF_STRING, "Please paas your client id here.", true);
		return List.of(clientId);
	}

	private Parameter parameter(String name, String type, String modelRef,String description,  boolean required) {
		ParameterBuilder parameters = new ParameterBuilder();
		parameters.name(name) // name of header
				.modelRef(new ModelRef(modelRef)).parameterType(type) // type - header
				.description(description)
				.required(required) // for compulsory
				.build();
		return parameters.build();
	}

}
