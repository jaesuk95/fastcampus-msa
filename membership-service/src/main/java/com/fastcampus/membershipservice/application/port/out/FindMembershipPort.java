package com.fastcampus.membershipservice.application.port.out;

import com.fastcampus.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampus.membershipservice.domain.Membership;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(Membership.MembershipId membershipId);

}
