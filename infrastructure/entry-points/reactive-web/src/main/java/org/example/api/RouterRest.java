package org.example.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/api/allpets"), handler::listenGETFindAllPetUseCase)
                .andRoute(POST("/api/createpet"), handler::listenPOSTCreatePetUseCase)
                .andRoute(DELETE("/api/deletepet/{id}"), handler::listenDELETEDeletePetUseCase)
                .and(route(GET("/api/findbyid/{id}"), handler::listenGETFindByIdPetUseCase));

    }
}
