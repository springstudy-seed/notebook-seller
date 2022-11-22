package seed.notebookseller.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Store {
    @Id
    public Long id;
    public String location;
    public String name;

    public Store(String location, String name) {
        this.location = location;
        this.name = name;
    }
}