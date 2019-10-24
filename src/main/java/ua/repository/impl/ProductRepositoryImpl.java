package ua.repository.impl;

import ua.domain.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.domain.Shop;
import ua.repository.base.AbstractRepository;
import ua.repository.ProductRepository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class ProductRepositoryImpl extends AbstractRepository implements ProductRepository {

    private static final BeanPropertyRowMapper<Product> ROW_MAPPER =
            new BeanPropertyRowMapper<>(Product.class);

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM products", ROW_MAPPER);
    }

    @Override
    public Product getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public Product insert(Long parentID, Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO cats(name, cost, manufacturer, date_of_manufacture, shop_id)" +
                            " VALUES (?, ?, ?, ?, ?)", new String[]{"id"});
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getCost());
            ps.setString(3, product.getManufacturer());
            ps.setDate(4, product.getDateOfManufacture());
            ps.setLong(5, parentID);
            return ps;
        }, keyHolder);
        long productId = keyHolder.getKey().longValue();
        return getOne(productId);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE * FROM products WHERE id = ?", id);
    }

    @Override
    public Product update(Long id, Product product) {
        jdbcTemplate.update("UPDATE products SET name = ?, cost = ?, manufacturer = ?," +
                        " date_of_manufacture = ? WHERE id = ?", product.getName(), product.getCost(), product.getManufacturer(),
                product.getDateOfManufacture(), id);
        return getOne(id);
    }

    @Override
    public void deleteAllByParentID(Long parentID) {
        jdbcTemplate.update("DELETE * FROM products WHERE shops_id = ?", parentID);
    }
}
