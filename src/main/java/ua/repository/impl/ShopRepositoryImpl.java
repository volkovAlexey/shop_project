package ua.repository.impl;

import ua.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.repository.ShopRepository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class ShopRepositoryImpl implements ShopRepository {

    private static final BeanPropertyRowMapper<Shop> ROW_MAPPER =
            new BeanPropertyRowMapper<>(Shop.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShopRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Shop> findAll() {
        return jdbcTemplate.query("SELECT * FROM shops", ROW_MAPPER);
    }

    @Override
    public Shop getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM shops WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public Shop insert(Shop shop) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO shops (name, phone_number, type, number_of_cash_desk, deliverable)" +
                            " VALUES (?, ?, ?, ?, ?)", new String[]{"id"});
            ps.setString(1, shop.getName());
            ps.setString(2, shop.getPhoneNumber());
            ps.setObject(3, shop.getType());
            ps.setInt(4, shop.getNumberOfCashDesk());
            ps.setBoolean(5, shop.getDeliverable());
            return ps;
        }, keyHolder);
        long shopId = keyHolder.getKey().longValue();
        return getOne(shopId);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE * FROM shops WHERE id = ?", id);
    }

    @Override
    public Shop update(Long id, Shop shop) {
        jdbcTemplate.update("UPDATE shops SET name = ?, phone_number = ?, type = ?, number_of_cash_desk = ?" +
                        "deliverable = ? WHERE id = ?", shop.getName(), shop.getPhoneNumber(), shop.getType(),
                shop.getNumberOfCashDesk(), shop.getDeliverable(), id);
        return getOne(id);
    }
}
