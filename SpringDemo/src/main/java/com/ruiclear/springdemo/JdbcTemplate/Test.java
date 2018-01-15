package com.ruiclear.springdemo.JdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by RuiClear on 2017/12/20.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        ApplicationContext  context = new ClassPathXmlApplicationContext("ApplicationContext-JdbcTemplate.xml");
        DataSource dataSource =(DataSource)context.getBean("dataSource");
        System.out.println(dataSource);
        JdbcTemplate jdbcTemplate =(JdbcTemplate)context.getBean("jdbcTemplate");
        String sql = "select * from user where id=?";
       RowMapper<User> rowMapper  = new BeanPropertyRowMapper<User>(User.class);
      User user= jdbcTemplate.queryForObject(sql,rowMapper,1);
        System.out.println(user);
    }
}
