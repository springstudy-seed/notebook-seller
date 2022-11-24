package seed.notebookseller.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue
    private Long id;
    private String location;
    private String name;

    @OneToMany(mappedBy = "store",fetch= FetchType.EAGER)
    private List<Deposit> depositList;

    public Store(String location, String name) {
        this.location = location;
        this.name = name;
    }
}