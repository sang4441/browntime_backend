package com.springapp.mvc.DAO;

import com.springapp.mvc.model.BrownMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by kimsanghwan on 7/21/2014.
 */
public class MenuDAO {

    @Autowired
    DataSource dataSource;


    public List<BrownMenu> getMenusBySellerId(int sellerId) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT  menus.id, menus.name, menus.price, menus.category_id AS category, menus.description, menus.image_URL FROM menus\n" +
                "INNER JOIN categories AS cat ON menus.category_id = cat.id\n" +
                "INNER JOIN sellers AS sl ON sl.id = cat.seller_id\n" +
                "WHERE sl.id = ?";
        List<BrownMenu> orders  = jdbcTemplate.query(
                sql, new Object[] {sellerId}, new BeanPropertyRowMapper(BrownMenu.class));
        return orders;
    }
}

