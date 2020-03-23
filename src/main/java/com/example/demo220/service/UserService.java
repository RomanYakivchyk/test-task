package com.example.demo220.service;

import com.example.demo220.domain.User;
import com.example.demo220.repository.FirestoreUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final FirestoreUserRepository userRepository;

    public UserService(FirestoreUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<List<User>> getUsers(MultiValueMap<String, String> queryParameters) {

        Map<String, String> queryParams = queryParameters.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get(0)));

        return userRepository.findUsers(queryParams).map(qs -> qs.toObjects(User.class));
    }

}
