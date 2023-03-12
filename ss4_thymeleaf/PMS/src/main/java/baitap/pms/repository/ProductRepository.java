package baitap.pms.repository;

import baitap.pms.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findByNo(int productNo);

    void create(Product product);

    void update(Product product);

    void delete(Product product);
}
