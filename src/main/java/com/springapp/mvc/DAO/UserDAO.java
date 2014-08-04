package com.springapp.mvc.DAO;

import com.springapp.mvc.model.BrownBuyer;
import com.springapp.mvc.model.BrownOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimsanghwan on 8/4/2014.
 */
public class UserDAO {

    @Autowired
    DataSource dataSource;

    public void updateUserSMS(BrownBuyer buyer) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT count(id) as count FROM buyers WHERE cell_number = ?";
        int buyerCount = jdbcTemplate.queryForInt(sql, new Object[]{buyer.getBuyerCellNumber()});

        if (buyerCount < 1) {
            sql = "INSERT INTO buyers (name, cell_number, is_certified, sms_number, sms_flag) VALUES (?, ?, 0, ?, 1)";
            jdbcTemplate.update(sql, new Object[]{buyer.getBuyerName(), buyer.getBuyerCellNumber(), buyer.getSmsNumber()});
        } else {
            sql = "UPDATE buyers SET sms_number = ?, sms_flag = 1 WHERE cell_number = ?";
            jdbcTemplate.update(sql, new Object[] {buyer.getSmsNumber(), buyer.getBuyerCellNumber()});
        }
    }

    public List<BrownBuyer> getBuyerToSendSMS() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT count(id) as count FROM buyers WHERE sms_flag = 1";
        int SMSCount = jdbcTemplate.queryForInt(sql);
        if (SMSCount > 0) {
            sql = "SELECT id, name, cell_number, sms_number FROM buyers WHERE sms_flag = 1";
            List<BrownBuyer> buyers = jdbcTemplate.query(sql, new BeanPropertyRowMapper(BrownBuyer.class));
            for (BrownBuyer buyer: buyers) {
                updateBuyerSMSFlag(buyer);
            }
            return buyers;
        } else {
            return new ArrayList<BrownBuyer>();
        }
    }

    public void updateBuyerSMSFlag(BrownBuyer buyer) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE buyers SET sms_flag = 0 WHERE id = ?";
        jdbcTemplate.update(sql, new Object[] {buyer.getBuyerId()});
    }

    public boolean isSMSMatched(int buyerId, int SMSNum) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT sms_number FROM buyers WHERE id = ?";
        int requiredSMSNum = jdbcTemplate.queryForInt(sql, new Object[] {buyerId});

        if (SMSNum == requiredSMSNum) {
            return true;
        } else {
            return false;
        }
    }
}
