package storePractice.store.domain;

import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
public class Order {

    @Id
    @GeneratedValue
    private int Id;

    @OneToMany
    private List<OrderItem> orderItems;
}
