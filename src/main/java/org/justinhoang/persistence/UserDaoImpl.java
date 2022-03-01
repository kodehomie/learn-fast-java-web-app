package org.justinhoang.persistence;

import org.justinhoang.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int signUpUser(User user) {

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
    public String signInUser(User user) {

        String sql = "SELECT id FROM user WHERE id=? AND password=?";

        try {

            String id = jdbcTemplate.queryForObject(sql, new Object[]{
                    user.getId(), user.getPassword()}, String.class);

            return id;

        } catch (Exception e) {
            return null;
        }
    }
}
