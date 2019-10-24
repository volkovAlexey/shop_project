package ua.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.domain.Shop;
import org.springframework.stereotype.Service;
import ua.domain.TypeOfShop;
import ua.repository.ProductRepository;
import ua.repository.ShopRepository;
import ua.service.ShopService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;

    public ShopServiceImpl(ShopRepository shopRepository, ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
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
        getEntry(id);
        productRepository.deleteAllByParentID(id);
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
    public List<String> getGroceryShopNumbers(int numberOfCashDesk) {
        return getAll().stream().filter(shop -> shop.getDeliverable()
                && shop.getNumberOfCashDesk() == numberOfCashDesk
                && shop.getType().equals(TypeOfShop.GROCERY))
                .map(Shop::getPhoneNumber)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
