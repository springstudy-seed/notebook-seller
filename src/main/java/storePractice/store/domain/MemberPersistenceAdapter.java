package storePractice.store.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberPersistenceAdapter implements MemberInPort, MemberOutPort{
    private final MemberRepository memberRepository;

    @Override
    public Member findByName(String name) {
        return memberRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당하는 주문 없음"));
    }

    @Override
    public void delete(Member member) {
        memberRepository.delete(member);
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }
}
