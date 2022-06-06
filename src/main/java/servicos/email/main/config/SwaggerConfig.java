package servicos.email.main.config;

import java.util.ArrayList;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.servicos.email.main"))
		.paths(regex("/api.*"))
		.build()
		.apiInfo(metaInfo());
		
	}
	
	 private ApiInfo metaInfo() {

	        ApiInfo apiInfo = new ApiInfo(
	                "MICRO SERVIÇO E-MAIL",
	                "ENVIO DE EMAILS.",
	                "1.0",
	                "Terms of Service",
	                new Contact("Brian", "https://github.com/brianlucas1",
	                        "brianlucas94@hotmail.com"),
	                "Apache License Version 2.0",
	                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
	        );

	        return apiInfo;
	    }

}