package codegym.baitap.service;

import codegym.baitap.entity.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();
    Product findById(Long id);
}
