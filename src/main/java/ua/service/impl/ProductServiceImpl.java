package ua.service.impl;

import ua.domain.Product;
import org.springframework.stereotype.Service;
import ua.repository.ProductRepository;
import ua.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getEntry(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Product addEntry(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public Product update(Long id, Product product) {
        return productRepository.update(id, product);
    }
}