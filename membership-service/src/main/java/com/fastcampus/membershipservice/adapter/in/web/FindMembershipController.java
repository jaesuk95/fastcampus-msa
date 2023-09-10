package com.fastcampus.membershipservice.adapter.in.web;


import com.fastcampus.membershipservice.application.port.in.FindMembershipUseCase;
import com.fastcampus.membershipservice.domain.Membership;
import common.WebAdapter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@AllArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/membership/{membershipId}")
    ResponseEntity<Membership> getMember(@PathVariable String membershipId) {
        FindMembershipRequest command = FindMembershipRequest.builder()
                .membershipId(membershipId)
                .build();

        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
    }

}
