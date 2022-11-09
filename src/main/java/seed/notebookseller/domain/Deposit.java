package seed.notebookseller.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Deposit {
    @Id
    public Long id;

    public Long deposit;

    @ManyToOne
    @JoinColumn(name = "NOTE_BOOK_ID")
    public Notebook notebook;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    public Store store;


    public Deposit(Long deposit, Notebook notebook, Store store) {
        this.deposit = deposit;
        this.notebook = notebook;
        this.store = store;
    }
}