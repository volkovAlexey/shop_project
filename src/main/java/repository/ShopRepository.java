package repository;

import domain.Shop;

import java.util.List;

public interface ShopRepository {
    List<Shop> findAll();

    Shop getOne(Long id);

    Shop insert(Shop shop);

    void delete(Long id);

    Shop update(Long id, Shop shop);
}
