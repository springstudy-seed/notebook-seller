package seed.notebookseller.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Host{
    @Id
    @GeneratedValue
    public Long id;

    public String name;

    @OneToOne
    public Store store;
}