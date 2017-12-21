package com.ruiclear.springdemo.JdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by RuiClear on 2017/12/20.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        ApplicationContext  context = new ClassPathXmlApplicationContext("ApplicationContext-JdbcTemplate.xml");
        DataSource dataSource =(DataSource)context.getBean("dataSource");
        System.out.println(dataSource);
        //JdbcTemplate jdbcTemplate =(JdbcTemplate)context.getBean("jdbcTemplate");
        String sql = "select * from t_bigtype where id=?";
//        RowMapper<Tbigtype> rowMapper  = new BeanPropertyRowMapper<Tbigtype>(Tbigtype.class);
//        Tbigtype tbigtype= jdbcTemplate.queryForObject(sql,rowMapper,1);
        Connection connection =dataSource.getConnection();
        System.out.println(connection);
        PreparedStatement ps= connection.prepareStatement(sql);
        ps.setInt(1,1);
        ResultSet rs = ps.executeQuery();
        System.out.println(rs);
       //System.out.println(tbigtype);
    }
}
