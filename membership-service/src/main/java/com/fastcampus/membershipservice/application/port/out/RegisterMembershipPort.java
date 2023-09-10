package com.fastcampus.membershipservice.application.port.out;

import com.fastcampus.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampus.membershipservice.domain.Membership;

public interface RegisterMembershipPort {
    MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp
    );
}
