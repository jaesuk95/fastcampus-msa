package com.fastcampus.membershipservice.application.service;

import com.fastcampus.membershipservice.adapter.in.web.FindMembershipRequest;
import com.fastcampus.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampus.membershipservice.adapter.out.persistence.MembershipMapper;
import com.fastcampus.membershipservice.application.port.in.FindMembershipUseCase;
import com.fastcampus.membershipservice.application.port.out.FindMembershipPort;
import com.fastcampus.membershipservice.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipRequest command) {
        MembershipJpaEntity membershipEntity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));

        return membershipMapper.mapToDomainEntity(membershipEntity);
    }
}
