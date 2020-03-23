//package com.example.demo220.repository;
//
//import com.example.demo220.domain.User;
//import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
//import reactor.core.publisher.Flux;
//
//public interface UserRepository extends FirestoreReactiveRepository<User> {
//
//    Flux<User> findAll();
//
//    Flux<User> findByFirstName();
//
//    Flux<User> findByLastName();
//
//    Flux<User> findByEmail();
//}
