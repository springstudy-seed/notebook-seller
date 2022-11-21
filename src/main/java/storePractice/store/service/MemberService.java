package storePractice.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import storePractice.store.domain.Member;
import storePractice.store.domain.MemberRepository;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member createMember(MemberCreateDto memberCreateDto) {
        return memberRepository.save(memberCreateDto.toEntity());
    }

    public void deleteMember(String name) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 회원이 없습니다."));
        memberRepository.delete(member);
    }
}
