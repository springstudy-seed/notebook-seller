package seed.notebookseller.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seed.notebookseller.domain.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
}