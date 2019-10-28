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
        shop.setId(rs.getLong(1));
        shop.setName(rs.getString(2));
        shop.setPhoneNumber(rs.getString(3));
        shop.setType(convertToEnum(rs.getString(4)));
        shop.setNumberOfCashDesk(rs.getInt(5));
        shop.setDeliverable(rs.getBoolean(6));
        return shop;
    }

    private TypeOfShop convertToEnum(String s) {
        return TypeOfShop.valueOf(s.toUpperCase());
    }
}
