package seed.notebookseller.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Store {
    @Id
    @GeneratedValue
    private Long id;
    private String location;
    private String name;

    @OneToMany(mappedBy = "store",fetch= FetchType.EAGER)
    private List<Deposit> depositList;
}