package seed.notebookseller.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seed.notebookseller.domain.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
}
