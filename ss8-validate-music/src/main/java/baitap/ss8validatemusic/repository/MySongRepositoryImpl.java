package baitap.ss8validatemusic.repository;

import baitap.ss8validatemusic.entity.MySong;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MySongRepositoryImpl implements MySongRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MySong> findAll() {
        return entityManager.createQuery("select s from MySong s").getResultList();
    }

    @Override
    public MySong findByNo(String songNo) {
        return entityManager.find(MySong.class, songNo);
    }

    @Override
    public void create(MySong mySong) {
        entityManager.persist(mySong);
    }

    @Override
    public void update(MySong mySong) {
        entityManager.merge(mySong);
    }

    @Override
    public void delete(MySong mySong) {
        entityManager.remove(entityManager.merge(mySong));
    }
}
