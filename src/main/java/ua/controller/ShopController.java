package ua.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.domain.Shop;
import org.springframework.http.MediaType;
import ua.service.ShopService;

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

    @GetMapping(value = "/{id}")
    public Shop getOneShop(@PathVariable Long id) {
        return shopService.getEntry(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Shop createShop(@RequestBody Shop shop) {
        return shopService.addEntry(shop);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShop(@PathVariable Long id) {
        shopService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public Shop updateShop(Long id, Shop shop) {
        return shopService.update(id, shop);
    }
}
