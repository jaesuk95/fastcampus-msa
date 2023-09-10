package com.fastcampus.membershipservice.adapter.out.persistence;

import com.fastcampus.membershipservice.application.port.out.FindMembershipPort;
import com.fastcampus.membershipservice.application.port.out.RegisterMembershipPort;
import com.fastcampus.membershipservice.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {

        MembershipJpaEntity jpaEntity = membershipRepository.save(
                new MembershipJpaEntity(
                        membershipName.getMembershipName(),
                        membershipAddress.getMembershipAddress(),
                        membershipEmail.getMembershipEmail(),
                        membershipIsValid.isMembershipIsValid(),
                        membershipIsCorp.isMembershipIsCorp()
                )
        );

        // entity -> Membership

        return jpaEntity;
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.findById(Long.valueOf(membershipId.getMembershipId())).orElseThrow();
    }
}
