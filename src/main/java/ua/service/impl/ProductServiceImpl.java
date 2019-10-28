package ua.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.domain.Product;
import org.springframework.stereotype.Service;
import ua.exceptions.DataNotFoundException;
import ua.repository.ProductRepository;
import ua.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
        return Optional.ofNullable(productRepository.getOne(id))
                .orElseThrow(() -> new DataNotFoundException("Cannot found product by id" + id));
    }

    @Override
    public void delete(Long id) {
        getEntry(id);
        productRepository.delete(id);
    }

    @Override
    public Product addEntry(Long id, Product product) {
        return productRepository.insert(id, product);
    }

    @Override
    public Product update(Long id, Product product) {
        return productRepository.update(id, product);
    }
}