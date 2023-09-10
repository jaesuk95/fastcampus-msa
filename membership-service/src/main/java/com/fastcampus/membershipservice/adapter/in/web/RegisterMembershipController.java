package com.fastcampus.membershipservice.adapter.in.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterMembershipController {

    @GetMapping("/test")
    public String test() {
        System.out.println("hello world");
        return "hello world";
    }

}

// adapter 는 외부와 직접적인 상호 작용한다
// in : inbound
// web
// inbound 으로 들어오는 웹 형식으로 들어오는 adapter 를 controller 라고 할 수 있다