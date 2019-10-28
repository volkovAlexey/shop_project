package ua.repository.mappers;

import org.springframework.jdbc.core.RowMapper;
import ua.domain.Shop;
import ua.domain.TypeOfShop;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopRowMapper implements RowMapper<Shop> {

    @Override
    public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
        Shop shop = new Shop();
        shop.setId(rs.getLong("id"));
        shop.setName(rs.getString("name"));
        shop.setPhoneNumber(rs.getString("phone_number"));
        shop.setType(convertToEnum(rs.getString("type")));
        shop.setNumberOfCashDesk(rs.getInt("number_of_cash_desk"));
        shop.setDeliverable(rs.getBoolean("deliverable"));
        return shop;
    }

    private TypeOfShop convertToEnum(String s) {
        return TypeOfShop.valueOf(s.toUpperCase());
    }
}
