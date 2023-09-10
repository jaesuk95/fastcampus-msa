package com.fastcampus.membershipservice.application.service;

import com.fastcampus.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampus.membershipservice.adapter.out.persistence.MembershipMapper;
import com.fastcampus.membershipservice.application.port.in.RegisterMembershipCommand;
import com.fastcampus.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.fastcampus.membershipservice.application.port.out.RegisterMembershipPort;
import com.fastcampus.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        // command -> DB

        // business logic -> DB

        // DB is external system

        // to access database you either have to make way to port, adapter (Hexa. architecture rule)


        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        return membershipMapper.mapToDomainEntity(jpaEntity);

    }


}
