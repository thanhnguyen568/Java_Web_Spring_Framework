package erpmini.be.service;

import erpmini.be.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CardService {
    Page<Card> findAll(Pageable pageable);

    Page<Card> findWithHQL(Pageable pageable);

    Card findByNo(Long cardNo);

    void save(Card card);

    void update(Long cardNo);
}
