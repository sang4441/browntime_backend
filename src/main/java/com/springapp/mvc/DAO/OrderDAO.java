package com.springapp.mvc.DAO;

import com.springapp.mvc.model.BrownCart;
import com.springapp.mvc.model.BrownMenu;
import com.springapp.mvc.model.BrownOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by kimsanghwan on 7/18/2014.
 */
public class OrderDAO {
    @Autowired
    CartDAO cartDAO;
    @Autowired
    DataSource dataSource;


    public List<BrownOrder> getOrdersBySellerId(int sellerId) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM orders WHERE seller_id = ?";
        List<BrownOrder> orders  = jdbcTemplate.query(
                sql, new Object[] {sellerId}, new BeanPropertyRowMapper(BrownOrder.class));

        for (BrownOrder order : orders) {
            order.setCarts(cartDAO.getCartsByOrderId(order.getId()));
        }

        return orders;
    }

    public BrownOrder getOrdersByOrderId(int orderId) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM orders WHERE id = ?";
        BrownOrder order  = jdbcTemplate.queryForObject(
                sql, new Object[]{orderId}, BrownOrder.class);

        return order;
    }

    public void addOrder(BrownOrder order) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO orders VALUES(null, ?, ?, ?, ?, ?, ?);";

        jdbcTemplate.update(sql, new Object[] {order.getSellerId(), order.getTypeId(), order.getBuyerId(), order.getTimeRequested(),
                order.getStatusId(), order.getPrice()});

        int orderId = jdbcTemplate.queryForObject( "SELECT max(id) FROM orders", Integer.class);
        sql = "INSERT INTO menuOrder VALUES(null, ?, ?, ?, ?)";

        List<BrownCart> carts = order.getCarts();
        for (BrownCart cart : carts) {
            jdbcTemplate.update(sql, new Object[] {cart.getId(), orderId, cart.getQuantity(), cart.getInstruction()});
        }
    }

    public void updateOrder() {

    }

    public void orderStatusChange(int orderId, int orderStatusId) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE orders SET status_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, new Object[] {orderStatusId, orderId});
    }

}
