package ua.repository;

import ua.domain.LongID;
import ua.domain.Shop;
import ua.repository.base.BasicRepository;
import ua.repository.base.ParentRepository;

public interface ShopRepository extends BasicRepository<Long, Shop>, ParentRepository<Shop> {
}
