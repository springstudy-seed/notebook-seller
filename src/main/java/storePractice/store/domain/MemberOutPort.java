package storePractice.store.domain;

public interface MemberOutPort {
    public void delete(Member member);
    public Member save(Member member);
}
