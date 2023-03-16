package baitap.service;

import baitap.entity.MySong;

import java.util.List;

public interface MySongService {
    List<MySong> findAll();

    MySong findByNo(String songNo);

    void create(MySong mySong);

    void update(MySong mySong);

    void delete(MySong mySong);
}
