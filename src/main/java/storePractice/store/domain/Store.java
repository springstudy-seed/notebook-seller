package storePractice.store.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Builder
@Getter
public class Store {

    @Id
    @GeneratedValue
    private int Id;

    private String name;

    @Embedded
    private Location location;

    @OneToOne
    private Member member;

    @ManyToOne
    private StoreItem storeItem;
}
