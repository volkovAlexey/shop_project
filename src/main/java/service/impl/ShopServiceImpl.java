package service.impl;

import domain.Shop;
import org.springframework.stereotype.Service;
import repository.ShopRepository;
import service.ShopService;

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
}
