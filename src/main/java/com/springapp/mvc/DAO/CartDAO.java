package com.springapp.mvc.DAO;

import com.springapp.mvc.model.BrownCart;
import com.springapp.mvc.model.BrownMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by kimsanghwan on 7/24/2014.
 */
public class CartDAO {

    @Autowired
    DataSource dataSource;


    public List<BrownCart> getCartsByOrderId(int orderId) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT mn.id, mn. name, mn.price, mn.category_id AS category, mn.description, mo.quantity, mo.instruction \n" +
                "FROM menuOrder AS mo \n" +
                "INNER JOIN menus AS mn ON mo.menu_id = mn.id\n" +
                "WHERE mo.order_id = ?";
        List<BrownCart> carts  = jdbcTemplate.query(
                sql, new Object[] {orderId}, new BeanPropertyRowMapper(BrownCart.class));
        return carts;
    }

}
