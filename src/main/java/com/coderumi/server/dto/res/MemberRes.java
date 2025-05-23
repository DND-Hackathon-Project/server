package com.coderumi.server.dto.res;

import com.coderumi.server.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberRes {
    private String nickname;

    public static MemberRes from(Member member) {
        MemberRes memberRes = new MemberRes();
        memberRes.nickname = member.getNickname();
        return memberRes;
    }
}
