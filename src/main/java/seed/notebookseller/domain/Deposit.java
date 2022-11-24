package seed.notebookseller.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Deposit {
    @Id
    @GeneratedValue
    public Long id;

    public Long deposit;

    @ManyToOne
    @JoinColumn(name = "NOTE_BOOK_ID")
    public Notebook notebook;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    public Store store;

    @Builder
    public Deposit(Long deposit, Notebook notebook, Store store) {
        this.deposit = deposit;
        this.notebook = notebook;
        this.store = store;
    }

    public Long minusDeposit(Long depositCount){
        deposit-=depositCount;
        return deposit;
    }

    public Long plusDeposit(Long depositCount){
        deposit+=depositCount;
        return deposit;
    }
}