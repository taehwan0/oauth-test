package org.study.oauth.member.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.study.oauth.member.domain.Member;
import org.study.oauth.member.domain.SocialType;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findBySocialTypeAndSocialId(SocialType socialType, Long SocialId);
}
