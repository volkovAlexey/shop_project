package controller;

import domain.Shop;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ShopService;

import java.util.List;

@RestController
@RequestMapping(value = "/shops", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<Shop> getShops() {
        return shopService.getAll();
    }
}
