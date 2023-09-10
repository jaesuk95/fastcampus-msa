package com.fastcampus.membershipservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    @Getter private final String membershipId;
    @Getter private final String name;
    @Getter private final String email;
    @Getter private final String address;
    @Getter private final boolean isValid;
    @Getter private final boolean isCorp;

    // member 정의
    // getter, setter, @Data 이런 어노테이션을 사용할 수 있지만,
    // 다만, clean architecture 으로 개선한다면
    // @AllArgsConstructor(access = AccessLevel.PRIVATE)
    // membership 안에서만 건드릴 수 있다
    // membership 은 오염되면 안되는 클래스, 고객 정보. 핵심 도메인 안전하게 관리하는 시스템

    public static Membership generateMember(
            MembershipId membershipId,
            MembershipName membershipName,
            MembershipEmail membershipEmail,
            MembershipAddress membershipAddress,
            MembershipIsValid isValid,
            MembershipIsCorp isCorp) {
        return new Membership(
                membershipId.membershipId,
                membershipName.membershipName,
                membershipEmail.membershipEmail,
                membershipAddress.MembershipAddress,
                isValid.membershipIsValid,
                isCorp.membershipIsCorp);
    }

    @Value
    public static class MembershipId {
        public MembershipId(String value) {
            this.membershipId = value;
        }
        String membershipId;
    }

    @Value
    public static class MembershipName {
        public MembershipName(String value) {
            this.membershipName = value;
        }
        String membershipName;
    }

    @Value
    public static class MembershipEmail {
        public MembershipEmail(String value) {
            this.membershipEmail = value;
        }
        String membershipEmail;
    }
    @Value
    public static class MembershipAddress {
        public MembershipAddress(String value) {
            this.MembershipAddress = value;
        }
        String MembershipAddress;
    }
    @Value
    public static class MembershipIsValid {
        public MembershipIsValid(boolean value) {
            this.membershipIsValid = value;
        }
        boolean membershipIsValid;
    }
    @Value
    public static class MembershipIsCorp {
        public MembershipIsCorp(boolean value) {
            this.membershipIsCorp = value;
        }
        boolean membershipIsCorp;
    }


}
