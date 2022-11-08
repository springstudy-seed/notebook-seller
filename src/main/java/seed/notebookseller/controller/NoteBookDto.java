package seed.notebookseller.controller;

import lombok.Data;
import seed.notebookseller.domain.Notebook;

@Data
public class NoteBookDto {
    public String cpu;
    public int ram;
    public int harddisk;
    public boolean type;

    public Notebook toEntity() {
        return Notebook.builder()
                .cpu(this.cpu)
                .ram(this.ram)
                .harddisk(this.harddisk)
                .type(this.type)
                .build();
    }
}

