//package org.justinhoang.repo;
//
//import org.justinhoang.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//
//import java.beans.BeanProperty;
//
//@Repository
//public class UserJdbcInsert {
//
//    private JdbcTemplate jdbcTemplate;
//    private SimpleJdbcInsert jdbcInsert;
//
//    @Autowired
//    public UserJdbcInsert(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//    }
//
//    public Long userJdbcSave(User user) {
//
//        jdbcInsert.withTableName("User").usingGeneratedKeyColumns("id");
//
//        Number id = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(user));
//
//        return id.longValue();
//    }
//}
