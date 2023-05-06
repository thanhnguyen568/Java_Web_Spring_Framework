package erpmini.be.service.impl;

import erpmini.be.entity.Card;
import erpmini.be.repository.CardRepository;
import erpmini.be.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository repository;

    @Override
    public Page<Card> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Card> findWithHQL(Pageable pageable) {
        return repository.findByHQL(pageable);
    }

    @Override
    public Card findByNo(Long cardNo) {
        return repository.findById(cardNo).orElse(null);
    }

    @Override
    public void save(Card card) {
        repository.save(card);
    }

    @Override
    public void update(Long cardNo) {
        repository.updateByHQL(cardNo);
    }
}
