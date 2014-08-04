package com.springapp.mvc.DAO;

import com.springapp.mvc.model.BrownBuyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by kimsanghwan on 8/4/2014.
 */
public class UserDAO {

    @Autowired
    DataSource dataSource;

    public void updateUserSMS(BrownBuyer buyer, int SMSNum) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT count(id) as count FROM buyers WHERE cell_number = ?";
        int buyerCount = jdbcTemplate.queryForInt(sql, new Object[]{buyer.getBuyerCellNumber()});

        if (buyerCount < 1) {
            sql = "INSERT INTO buyers (name, cell_number, is_certified, sms_number) VALUES (?, ?, 0, ?)";
            jdbcTemplate.update(sql, new Object[] {buyer.getBuyerName(), buyer.getBuyerCellNumber(), SMSNum});
        } else {
            sql = "UPDATE buyers SET sms_number = ? WHERE cell_number = ?";
            jdbcTemplate.update(sql, new Object[] {SMSNum, buyer.getBuyerCellNumber()});
        }
    }
}
