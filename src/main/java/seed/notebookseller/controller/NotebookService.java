package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seed.notebookseller.domain.NotebookRepository;

@Service
@RequiredArgsConstructor
public class NotebookService {
    private final NotebookRepository notebookRepository;

    public void createNotebook(NoteBookDto noteBookDto) {
        notebookRepository.save(noteBookDto.toEntity(noteBookDto));
    }
}
