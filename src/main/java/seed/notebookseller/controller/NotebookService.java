package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seed.notebookseller.domain.Notebook;
import seed.notebookseller.domain.NotebookRepository;

@Service
@RequiredArgsConstructor
public class NotebookService {
    private final NotebookRepository notebookRepository;

    public Notebook createNotebook(NoteBookDto noteBookDto) {
        return  notebookRepository.save(noteBookDto.toEntity(noteBookDto));
    }
}
