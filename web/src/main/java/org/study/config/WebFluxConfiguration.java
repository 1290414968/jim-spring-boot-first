package org.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.study.domain.User;
import org.study.repository.UserRepository;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 *  Web Flux 参数
 **/
@Configuration
public class WebFluxConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> routerFunctionAllUsers(UserRepository userRepository){
        Collection<User> users = userRepository.findAll();
        Flux<User> userFlux = Flux.fromIterable(users);
//        Mono<Collection<User>> mono = Mono.just(users);
        return RouterFunctions.route(RequestPredicates.path("/all-users"),
                request -> ServerResponse.ok().body(userFlux,User.class));
    }

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> routerFunctionUsers(UserRepository userRepository){
        Collection<User> users = userRepository.findAll();
        Flux<User> userFlux = Flux.fromIterable(users);
        return RouterFunctions.route(RequestPredicates.path("/users"),
                request -> ServerResponse.ok().body(userFlux,User.class));
    }

}
