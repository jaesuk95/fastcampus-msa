package com.fastcampus.membershipservice.adapter.in.web;

import com.fastcampus.membershipservice.application.port.in.RegisterMembershipCommand;
import com.fastcampus.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.fastcampus.membershipservice.domain.Membership;
import common.WebAdapter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@AllArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    ResponseEntity<Membership> registerMembership(@RequestBody RegisterMembershipRequest request) {
        // 1. request ~~
        // 2. request -> command
        // 3. Usecase ~~(request x, command o)

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return ResponseEntity.ok(registerMembershipUseCase.registerMembership(command));
    }

}

// adapter 는 외부와 직접적인 상호 작용한다
// in : inbound
// web
// inbound 으로 들어오는 웹 형식으로 들어오는 adapter 를 controller 라고 할 수 있다