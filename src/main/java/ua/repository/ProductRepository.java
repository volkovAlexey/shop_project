package ua.repository;

import ua.domain.Product;
import ua.repository.base.BasicRepository;
import ua.repository.base.ChildRepository;

import java.util.List;

public interface ProductRepository extends BasicRepository<Long, Product>, ChildRepository<Long, Product> {
    Product insert(Long id, Product product);

    void deleteAllByParentID(Long id);
}
