package seed.notebookseller.domain;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
@Getter
public class Host{
    @Id
    @GeneratedValue
    public Long id;

    public String name;

    @OneToOne
    public Store store;

    public void validateName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name값 없어요");
        }
    }
}