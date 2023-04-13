package baitap.ss8validatemusic.repository;


import baitap.ss8validatemusic.entity.MySong;

import java.util.List;

public interface MySongRepository {
    List<MySong> findAll();

    MySong findByNo(String songNo);

    void create(MySong mySong);

    void update(MySong mySong);

    void delete(MySong mySong);
}
