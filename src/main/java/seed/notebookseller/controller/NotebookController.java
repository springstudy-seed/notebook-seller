package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.web.bind.annotation.*;
import seed.notebookseller.domain.Notebook;

@RequiredArgsConstructor
@RestController
public class NotebookController {
    private final NotebookService notebookService;
    @PostMapping("/api/insert/")
    public Notebook insert(@RequestBody NoteBookDto noteBookDto){
        return notebookService.createNotebook(noteBookDto);
    }
}
