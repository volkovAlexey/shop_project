package ua.service;

import ua.domain.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getAll();

    Shop getEntry(Long id);

    void delete(Long id);

    Shop addEntry(Shop shop);

    Shop update(Long id, Shop shop);

    List<String> searchByFilter();
}
