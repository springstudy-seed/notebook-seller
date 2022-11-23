package seed.notebookseller.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Store {
    @Id
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