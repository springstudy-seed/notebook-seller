package seed.notebookseller.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Store {
    @Id
    @GeneratedValue
    private Long id;
    private String location;
    private String name;

    @OneToMany(mappedBy = "store",fetch= FetchType.EAGER)
    private List<Deposit> depositList;
}