package ua.service.impl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.domain.Product;
import ua.exceptions.DataNotFoundException;
import ua.repository.ProductRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

@Test
public class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void beforeMethod() {
        reset(productRepository);
    }

    @Test
    public void existedProduct_getAll_success() {
        Long id1 = 1L;
        Long id2 = 2L;
        List<Product> products = new ArrayList<>();
        Product product1 = new Product(id1, "Sugar", 22.40,
                "Prod inc.", Date.valueOf("2019-10-12"));
        Product product2 = new Product(id2, "Milk", 12.50,
                "Milk Prod", Date.valueOf("2019-10-23"));
        products.add(product1);
        products.add(product2);

        when(productRepository.findAll()).thenReturn(products);

        List<Product> actualList = productService.getAll();
        verify(productRepository).findAll();
        assertEquals(actualList.get(0), product1);
        assertEquals(actualList.get(1), product2);
    }

    @Test
    public void existedProduct_getProduct_success() {
        Long id = 22L;
        Product product = new Product(id, "Sugar", 22.40,
                "Prod inc.", Date.valueOf("2019-10-12"));
        when(productRepository.getOne(id)).thenReturn(product);

        Product actualProduct = productService.getEntry(id);
        verify(productRepository).getOne(id);
        assertEquals(actualProduct.getName(), product.getName());
        assertEquals(actualProduct.getCost(), product.getCost());
        assertEquals(actualProduct.getManufacturer(), product.getManufacturer());
        assertEquals(actualProduct.getDateOfManufacture(), product.getDateOfManufacture());
    }

    @Test
    public void validProduct_addProduct_success() {
        Long id = 22L;
        Product product = new Product("Sugar", 22.40,
                "Prod inc.", Date.valueOf("2019-10-12"));
        Product returnProduct = new Product(id, "Sugar", 22.40,
                "Prod inc.", Date.valueOf("2019-10-12"));
        when(productRepository.insert(id, product)).thenReturn(returnProduct);

        Product actualProduct = productService.addEntry(id, product);

        assertNotNull(actualProduct.getId());
    }

    @Test(expectedExceptions = {DataNotFoundException.class})
    public void notExistedProduct_getProduct_throwException() {
        Long id = 2L;
        when(productRepository.getOne(id)).thenReturn(null);

        productService.getEntry(id);
    }

    @Test
    public void validProduct_deleteProduct_success() {
        Long id = 2L;
        doNothing().when(productRepository).delete(id);
        when(productRepository.getOne(id)).thenReturn(new Product());

        productService.delete(id);

        verify(productRepository).delete(2L);
        verify(productRepository).getOne(id);
    }

    @Test(expectedExceptions = {DataNotFoundException.class})
    public void notExistedProduct_deleteProduct_throwException() {
        Long id = 22L;
        when(productRepository.getOne(id)).thenReturn(null);
        productService.delete(id);
    }

    @Test
    public void validProduct_updateProduct_success() {
        Long id = 22L;
        Product product = new Product("Sugar", 22.40,
                "Prod inc.", Date.valueOf("2019-10-12"));
        Product returnProduct = new Product(id, "Sugar", 22.40,
                "Prod inc.", Date.valueOf("2019-10-12"));
        when(productRepository.update(id, product)).thenReturn(returnProduct);

        Product actualProduct = productService.update(id, product);

        assertNotNull(actualProduct.getId());
    }
}
