package seed.notebookseller.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notebook {
    @Id
    public Long id;
    public String cpu;
    public int ram;
    public int harddisk;
    public NoteBookType noteBookType;

    public Notebook(String cpu, int ram, int harddisk, NoteBookType noteBookType) {
        this.cpu = cpu;
        this.ram = ram;
        this.harddisk = harddisk;
        this.noteBookType = noteBookType;
    }
}