package seed.notebookseller.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import seed.notebookseller.domain.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}