package com.fastcampus.membershipservice.application.port.in;

import com.fastcampus.membershipservice.domain.Membership;
import common.UseCase;

@UseCase
public interface RegisterMembershipUseCase {
    Membership registerMembership(RegisterMembershipCommand command);
}
