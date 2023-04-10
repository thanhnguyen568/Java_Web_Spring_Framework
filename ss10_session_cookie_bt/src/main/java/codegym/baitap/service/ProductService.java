package codegym.baitap.service;

import codegym.baitap.entity.Product;

public interface ProductService {
    Iterable<Product> findAll();
    Product findById(Long id);
}
