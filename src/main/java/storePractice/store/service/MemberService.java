package storePractice.store.service;

import storePractice.store.domain.Member;

public interface MemberService {
    public Member createMember(MemberCreateDto memberCreateDto);
    public void deleteMember (String name);

    }
