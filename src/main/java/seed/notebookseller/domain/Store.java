package seed.notebookseller.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@NoArgsConstructor
@Getter
public class Store {
    @Id
    private Long id;
    private String location;
    private String name;


    public Store(String location, String name) {
        this.location = location;
        this.name = name;
    }
}