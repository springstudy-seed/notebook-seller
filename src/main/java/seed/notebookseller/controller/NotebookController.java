package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import seed.notebookseller.domain.Notebook;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class NotebookController {
    private final NotebookService notebookService;

    @PostMapping("/api/notebooks")
    public ResponseEntity<Notebook> insert(@RequestBody NoteBookDto noteBookDto) {
        Notebook createdNotebook = notebookService.createNotebook(noteBookDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(createdNotebook.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdNotebook);
    }
}
