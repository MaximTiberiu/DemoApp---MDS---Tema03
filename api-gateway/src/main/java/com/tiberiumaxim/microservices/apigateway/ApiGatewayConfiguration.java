package com.tiberiumaxim.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder) {

        return routeLocatorBuilder.routes()
                .route(predicateSpec -> predicateSpec.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(predicateSpec -> predicateSpec.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(predicateSpec -> predicateSpec.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .build();
    }
}
