package storePractice.store.domain;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Builder
public class StoreItem {

    @Id
    @GeneratedValue
    private int Id;

    @OneToMany(mappedBy = "Item")
    private Item item;

    @OneToMany(mappedBy = "Store")
    private Store store;
}
