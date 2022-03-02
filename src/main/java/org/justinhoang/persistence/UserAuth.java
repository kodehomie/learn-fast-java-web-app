package org.justinhoang.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserAuth implements GenAuthDao {

    private JdbcTemplate jdbcTemplate;


    public UserAuth(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int signUp(User user) {
        String sql = "INSERT INTO 'user' VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            int counter = jdbcTemplate.update(sql, new Object[]{user.getId(), user.getPassword()});
            return counter;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String signIn(User user) {
        String sql = "SELECT username FROM user WHERE username=? AND password=?";
        try {
            String id = jdbcTemplate.queryForObject(sql, new Object[]{
                    user.getUsername(), user.getPassword()}, String.class);
            return id;
        } catch (Exception e) {
            return null;
        }
    }
}
