package seed.notebookseller.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Notebook {
    @Id
    @GeneratedValue
    public Long id;
    public String cpu;
    public int ram;
    public int harddisk;
    @Enumerated(EnumType.ORDINAL)
    public NoteBookType noteBookType;

    public Notebook(String cpu, int ram, int harddisk, NoteBookType noteBookType) {
        this.cpu = cpu;
        this.ram = ram;
        this.harddisk = harddisk;
        this.noteBookType = noteBookType;
    }
}