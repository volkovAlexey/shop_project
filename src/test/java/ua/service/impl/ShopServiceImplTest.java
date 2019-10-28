package ua.service.impl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.repository.ProductRepository;
import ua.repository.ShopRepository;

import static org.mockito.Mockito.reset;

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
}
