package seed.notebookseller.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository  extends JpaRepository<Notebook, Long> {
}
