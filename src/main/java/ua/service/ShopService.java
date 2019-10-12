package ua.service;

import ua.domain.Shop;

import java.util.List;

public interface ShopService extends FilterShopService {
    List<Shop> getAll();

    Shop getEntry(Long id);

    void delete(Long id);

    Shop addEntry(Shop shop);

    Shop update(Long id, Shop shop);
}
