package org.study.oauth.member.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.study.oauth.auth.application.authclient.SocialInfo;
import org.study.oauth.member.domain.Member;
import org.study.oauth.member.domain.SocialType;
import org.study.oauth.member.repository.MemberRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Optional<Member> getMember(SocialType socialType, Long socialId) {
        return memberRepository.findBySocialTypeAndSocialId(socialType, socialId);
    }

    public Member createMember(SocialInfo socialInfo) {
        Member member = Member.of(socialInfo);
        return memberRepository.save(member);
    }
}
