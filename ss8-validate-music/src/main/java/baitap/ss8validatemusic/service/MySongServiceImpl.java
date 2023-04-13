package baitap.ss8validatemusic.service;

import baitap.ss8validatemusic.entity.MySong;
import baitap.ss8validatemusic.repository.MySongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySongServiceImpl implements MySongService {
    @Autowired
    private MySongRepository repository;

    @Override
    public List<MySong> findAll() {
        return repository.findAll();
    }

    @Override
    public MySong findByNo(String songNo) {
        return repository.findByNo(songNo);
    }

    @Override
    public void create(MySong mySong) {
        repository.create(mySong);
    }

    @Override
    public void update(MySong mySong) {
        repository.update(mySong);
    }

    @Override
    public void delete(MySong mySong) {
        repository.delete(mySong);
    }
}
