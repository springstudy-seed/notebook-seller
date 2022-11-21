package storePractice.store.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Builder
@Getter
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;
    private int cpuCapacity;
    private int hardDisk;

    @ManyToOne
    private StoreItem storeItem;
}
