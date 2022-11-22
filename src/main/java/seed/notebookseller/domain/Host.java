package seed.notebookseller.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Host {
    @Id
    public Long id;

    @OneToOne(mappedBy = "id")
    public Store store;

    public String name;

    public boolean type;
}