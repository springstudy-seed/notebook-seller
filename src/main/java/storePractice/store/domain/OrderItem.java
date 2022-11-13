package storePractice.store.domain;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Builder
public class OrderItem {

    @Id
    @GeneratedValue
    private int Id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Item item;
}
