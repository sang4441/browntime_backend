package com.springapp.mvc.DAO;

import com.springapp.mvc.model.BrownCategory;
import com.springapp.mvc.model.BrownMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by kimsanghwan on 7/24/2014.
 */
public class CategoryDAO {

    @Autowired
    DataSource dataSource;

    public List<BrownCategory> getCategoriesBySellerId(int sellerId) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT id, name FROM categories WHERE seller_id = ?";
        List<BrownCategory> categories  = jdbcTemplate.query(
                sql, new Object[] {sellerId}, new BeanPropertyRowMapper(BrownCategory.class));
        return categories;
    }
}
