package ua.service.impl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.domain.Shop;
import ua.domain.TypeOfShop;
import ua.exceptions.DataNotFoundException;
import ua.repository.ProductRepository;
import ua.repository.ShopRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

@Test
public class ShopServiceImplTest {
    @InjectMocks
    private ShopServiceImpl shopService;
    @Mock
    private ShopRepository shopRepository;
    @Mock
    private ProductRepository productRepository;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void beforeMethod() {
        reset(shopRepository);
        reset(productRepository);
    }

    @Test
    public void existedShop_getShop_success() {
        Long id = 22L;
        Shop shop = new Shop(id, "Rost", "+380575275846",
                TypeOfShop.GROCERY, 8, false);
        when(shopRepository.getOne(id)).thenReturn(shop);

        Shop actualShop = shopService.getEntry(id);
        verify(shopRepository).getOne(id);
        assertEquals(actualShop.getName(), "Rost");
        assertEquals(actualShop.getPhoneNumber(), "+380575275846");
        assertEquals(actualShop.getType(), shop.getType());
    }

    @Test
    public void validShop_addShop_success() {
        Shop shop = new Shop("Rost", "+380575275846", TypeOfShop.GROCERY,
                8, false);
        Shop returnShop = new Shop(22L, "Rost", "+380575275846", TypeOfShop.GROCERY,
                8, false);
        when(shopRepository.insert(shop)).thenReturn(returnShop);

        Shop actualShop = shopService.addEntry(shop);

        assertNotNull(actualShop.getId());
    }

    @Test(expectedExceptions = {DataNotFoundException.class})
    public void notExistedShop_getShop_throwException() {
        Long id = 2L;
        when(shopRepository.getOne(id)).thenReturn(null);

        shopService.getEntry(id);
    }

    @Test
    public void validShop_deleteShop_success() {
        Long id = 2L;
        doNothing().when(shopRepository).delete(id);
        doNothing().when(productRepository).deleteAllByParentID(id);
        when(shopRepository.getOne(id)).thenReturn(new Shop());

        shopService.delete(id);

        verify(shopRepository).delete(2L);
        verify(productRepository).deleteAllByParentID(id);
        verify(shopRepository).getOne(id);
    }

    @Test(expectedExceptions = {DataNotFoundException.class})
    public void notExistedShop_deleteShop_throwException() {
        Long id = 22L;
        when(shopRepository.getOne(id)).thenReturn(null);

        shopService.delete(id);
    }

    @Test
    public void validShop_updateShop_success() {
        Long id = 22L;
        Shop shop = new Shop("Rost", "+380575275846", TypeOfShop.GROCERY,
                8, false);
        Shop returnShop = new Shop(id, "Rost", "+380575275846", TypeOfShop.GROCERY,
                8, false);
        when(shopRepository.update(id, shop)).thenReturn(returnShop);

        Shop actualShop = shopService.update(id, shop);

        assertNotNull(actualShop.getId());
    }

    @Test
    public void existedShop_getAll_success() {
        Long id1 = 1L;
        Long id2 = 2L;
        List<Shop> shops = new ArrayList<>();
        Shop shop1 = new Shop(id1, "Rost", "+380575275846", TypeOfShop.GROCERY,
                8, false);
        Shop shop2 = new Shop(id2, "Class", "+380575275321", TypeOfShop.GROCERY,
                12, true);
        shops.add(shop1);
        shops.add(shop2);

        when(shopRepository.findAll()).thenReturn(shops);

        List<Shop> actualList = shopService.getAll();
        verify(shopRepository).findAll();
        assertEquals(actualList.get(0), shop1);
        assertEquals(actualList.get(1), shop2);
    }
}
