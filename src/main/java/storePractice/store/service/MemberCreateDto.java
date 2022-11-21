package storePractice.store.service;

import lombok.Getter;
import storePractice.store.domain.Grade;
import storePractice.store.domain.Member;


@Getter
public class MemberCreateDto {

    private String name;
    private Grade grade;

    public Member toEntity(){
        return Member.builder()
                .name(this.getName())
                .grade(this.getGrade())
                .build();
    }
}
