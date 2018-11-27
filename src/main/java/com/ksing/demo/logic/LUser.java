package com.ksing.demo.logic;

import com.ksing.demo.SpringUtil;
import com.ksing.demo.entity.User;
import com.ksing.demo.entity.User_info;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Calendar;


public class LUser {
    /*登陆*/
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
    /*获取用户信息*/
    public User_info getUserInfo(String code)throws ClassNotFoundException{
        User_info user_info;
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="select * from user_info where code = '"+code+"'";
//        System.out.println(sqltext);
        try {
            user_info=(User_info)jdbcTemplate.queryForObject(sqltext,new BeanPropertyRowMapper(User_info.class));
        }catch (Exception e){
            return null;
        }
        return user_info;
    }
    /*更改昵称*/
    public boolean setName(String code,String name){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set name = '"+name+"' where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    /*更改性别*/
    public boolean setSex(String code,String sex){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set sex = '"+sex+"' where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    /*更改生日*/
    public boolean setBirthday(String code,int birthday){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set birthday = "+birthday+" where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    /*更改居住地址*/
    public boolean setLivingPlace(String code,String living_place){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set living_place = '"+living_place+"' where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    /*更改签名*/
    public boolean setSignature(String code,String signature){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set signature = '"+signature+"' where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    /*更改学校*/
    public boolean setSchool(String code,String school){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set school = '"+school+"' where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    /*更改职业*/
    public boolean setOccupation(String code,String occupation){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set occupation = '"+occupation+"' where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    /*更改家乡*/
    public boolean setHometown(String code,String hometown){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set hometown = '"+hometown+"' where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    /*更改身高*/
    public boolean setHeight(String code,String height){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set height = '"+height+"' where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    /*更改活跃状态*/
    public boolean setIs_show_in1(String code,String is_show_in1){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set is_show_in1 = '"+is_show_in1+"' where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    /*更改附近的人*/
    public boolean setIs_show_in2(String code,String is_show_in2){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sqltext="update user_info set is_show_in2 = '"+is_show_in2+"' where code = '"+code+"'";
//        System.out.println(sqltext);
        int i=jdbcTemplate.update(sqltext);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
}
