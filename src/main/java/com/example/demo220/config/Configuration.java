package com.example.demo220.config;

import com.example.demo220.domain.User;
import com.example.demo220.service.UserService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class Configuration {


    @Bean
    public RouterFunction<ServerResponse> router(UserService userService) {
        return route(
                GET("/users"), request -> ServerResponse
                        .ok()
                        .body(userService.getUsers(request.queryParams()), User.class));
    }


    @Bean
    public Firestore firestore() throws IOException {
        return FirestoreOptions.getDefaultInstance().newBuilder()
//                .setProjectId("project-yakivchyk-14228")
                .setCredentials(GoogleCredentials.fromStream(
                        new FileInputStream(
                                new File("src/main/resources/project-yakivchyk-14228-5719abd18e0e.json"))))
                .build()
                .getService();
    }
}
