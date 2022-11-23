package seed.notebookseller.controller;

import lombok.Data;
import seed.notebookseller.domain.NoteBookType;
import seed.notebookseller.domain.Notebook;

@Data
public class NoteBookDto {
    public String cpu;
    public int ram;
    public int harddisk;
    public NoteBookType type;

    public Notebook toEntity(NoteBookDto noteBookDto){
        return Notebook.builder()
                .cpu(noteBookDto.getCpu())
                .ram(noteBookDto.getRam())
                .harddisk(noteBookDto.getHarddisk())
                .noteBookType(noteBookDto.getType())
                .build();
    }
}

