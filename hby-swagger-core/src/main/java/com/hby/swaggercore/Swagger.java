package com.hby.swaggercore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger {

    @Value("${swagger.enable:true}")
    boolean enable;
    @Value("${swagger.title:API查看器}")
    String title;
    @Value("${swagger.description:API服务的说明，请在配置文件中说明服务的作用}")
    String description;
    @Value("${swagger.contact.name:hby}")
    String contactName;
    @Value("${swagger.contact.url:www.hby.com}")
    String contactUrl;
    @Value("${swagger.contact.mail:hby@163.com}")
    String contactMail;
    @Value("${swagger.version:2.0}")
    String version;

    public Swagger() {

    }

    @Bean
    public Docket allApi() {
        if (!this.enable) {
            return (new Docket(DocumentationType.SWAGGER_2)).select().apis(RequestHandlerSelectors.none()).paths(PathSelectors.none()).build();
        } else {
            ApiInfo apiInfo = (new ApiInfoBuilder()).title(this.title)
                    .description(this.description)
                    .contact(new Contact(this.contactName, this.contactUrl, this.contactMail))
                    .version(this.version)
                    .build();
            ApiSelectorBuilder selectorBuilder = (new Docket(DocumentationType.SWAGGER_2)).useDefaultResponseMessages(false).apiInfo(apiInfo).select();
            selectorBuilder.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class));
            return selectorBuilder.build();
        }
    }
    @Bean
    public CorsFilter apiCorsFilter(){
        if (!this.enable){
            return new CorsFilter(new UrlBasedCorsConfigurationSource());
        }else {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowCredentials(true);
            configuration.addAllowedHeader("*");
            configuration.addAllowedMethod("*");
            configuration.addAllowedOrigin("*");
            source.registerCorsConfiguration("/**",configuration);
            return new CorsFilter(source);

        }
    }
}
