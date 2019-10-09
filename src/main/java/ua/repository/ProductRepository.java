package ua.repository;

import ua.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product getOne(Long id);

    Product insert(Product product);

    void delete(Long id);

    Product update(Long id, Product product);
}
