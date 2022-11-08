package seed.notebookseller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seed.notebookseller.domain.Notebook;
import seed.notebookseller.domain.NotebookRepository;
import seed.notebookseller.domain.Store;
import seed.notebookseller.domain.StoreRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.beans.Transient;

@Component
@RequiredArgsConstructor
public class PostInsert {
    private final NotebookRepository notebookRepository;
    private final StoreRepository storeRepository;

    @Transactional
    @PostConstruct
    public void preInsert(){
        Notebook zen_book = new Notebook("intel i5-11", 8, 1024, true);
        Notebook apple_book = new Notebook("m1", 16, 512, false);
        Notebook zen_book_pro = new Notebook("intel i7-10", 8, 512, true);

        notebookRepository.save(zen_book);
        notebookRepository.save(apple_book);
        notebookRepository.save(zen_book_pro);

        Store 서현이의_젠북 = new Store("남원시 이백면 문화길 52", "서현이의 젠북 판매소");
        Store 다애의_맥북 = new Store("남원시 이백면 문화길 51", "다애의 맥북 판매소");
        Store 다애의_젠북프로 = new Store("남원시 이백면 문화길 50", "다애의 젠북 판매소2");

        storeRepository.save(서현이의_젠북);
        storeRepository.save(다애의_맥북);
        storeRepository.save(다애의_젠북프로);

    }

}
