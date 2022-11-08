package seed.notebookseller.domain;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
public class Notebook {
    @Id
    public Long id;
    public String cpu;
    public int ram;
    public int harddisk;
    public boolean type;

    public Notebook(String cpu, int ram, int harddisk, boolean type) {
        this.cpu = cpu;
        this.ram = ram;
        this.harddisk = harddisk;
        this.type = type;
    }

    public Notebook() {

    }
}