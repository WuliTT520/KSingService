package com.ksing.demo.logic;

import com.ksing.demo.SpringUtil;
import com.ksing.demo.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class LUser {

    public User login(String code, String password) throws ClassNotFoundException{
        User user;
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltxt="select * from user where code = '"+code+"' and password = '"+password+"'";
//        System.out.println(sqltxt);
        try {
            user = (User) jdbcTemplate.queryForObject(sqltxt,new BeanPropertyRowMapper(User.class));
        }catch (Exception e) {
            return null;
        }
        return user;

    }

}
