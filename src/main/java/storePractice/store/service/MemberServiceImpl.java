package storePractice.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import storePractice.store.domain.Member;
import storePractice.store.domain.MemberInPort;
import storePractice.store.domain.MemberOutPort;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberInPort memberInPort;
    private final MemberOutPort memberOutPort;
    public Member createMember(MemberCreateDto memberCreateDto) {
        return memberOutPort.save(memberCreateDto.toEntity());
    }

    public void deleteMember(String name) {
        Member member = memberInPort.findByName(name);
        memberOutPort.delete(member);
    }
}
