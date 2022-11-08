package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
public class NotebookController {
    private final NotebookService notebookService;
    @PostMapping("/api/insert/")
    public void insert(NoteBookDto noteBookDto){
        notebookService.createNotebook(noteBookDto);
    }
}
