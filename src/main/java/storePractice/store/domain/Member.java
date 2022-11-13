package storePractice.store.domain;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class Member {

    @Id
    @GeneratedValue
    private int Id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @ManyToOne
    private Member member;
}
