package ua.service.impl;

import ua.domain.Shop;
import org.springframework.stereotype.Service;
import ua.repository.ShopRepository;
import ua.service.ShopService;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getEntry(Long id) {
        return shopRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        shopRepository.delete(id);
    }

    @Override
    public Shop addEntry(Shop shop) {
        return shopRepository.insert(shop);
    }

    @Override
    public Shop update(Long id, Shop shop) {
        return shopRepository.update(id, shop);
    }

    @Override
    public List<String> searchByFilter() {
        List<Shop> shops = getAll();
//        return shops.stream().filter(Shop shop -> shop.)
        return null;
    }
}
