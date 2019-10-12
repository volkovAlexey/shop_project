package ua.service;

import ua.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getEntry(Long id);

    void delete(Long id);

    Product addEntry(Product product);

    Product update(Long id, Product product);
}
