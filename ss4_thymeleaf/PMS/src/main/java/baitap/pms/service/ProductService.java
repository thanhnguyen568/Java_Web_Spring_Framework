package baitap.pms.service;

import baitap.pms.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findByNo(int productNo);

    void create(Product product);

    void update(Product product);

    void delete(Product product);
}

