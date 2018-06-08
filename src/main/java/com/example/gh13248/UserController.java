package com.example.gh13248;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/person")
    public Mono<User> getPerson(@RequestBody User user){
        return Mono.just(User.builder().name("haha").age(12).id("123123").build());
    }
}
