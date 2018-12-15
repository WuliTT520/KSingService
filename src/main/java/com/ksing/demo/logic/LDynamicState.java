package com.ksing.demo.logic;

import com.ksing.demo.SpringUtil;
import com.ksing.demo.entity.Comment;
import com.ksing.demo.entity.DynamicState;
import com.ksing.demo.entity.DynamicStateInfo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LDynamicState {
    /*获取好友动态*/
    public List<DynamicState> getFD(String code){
        List<DynamicState> dynamicStates=new ArrayList<DynamicState>();
        JdbcTemplate jdbcTemplate= (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sql="select name,user_dp,state_code,user_text,song_picture,song_name,like_num,share_num,evaluate_num,gift_num\n" +
                "from user_info a,song b,dynamic_state c\n" +
                "where c.`code`in(\n" +
                "\tSELECT friend_code\n" +
                "\tfrom user_friend\n" +
                "\twhere code='"+code+"'\n" +
                ")and a.`code`=c.`code`";
        List<Map<String,Object>>list=jdbcTemplate.queryForList(sql);
        for(Map<String, Object> map : list){
            DynamicState dynamicState=new DynamicState();
            dynamicState.setName(map.get("name").toString());
            dynamicState.setUser_dp(map.get("user_dp").toString());
            dynamicState.setState_code(map.get("state_code").toString());
            dynamicState.setUser_text(map.get("user_text").toString());
            dynamicState.setSong_picture(map.get("song_picture").toString());
            dynamicState.setSong_name(map.get("song_name").toString());
            dynamicState.setLike_num(map.get("like_num").toString());
            dynamicState.setShare_num(map.get("share_num").toString());
            dynamicState.setEvaluate_num(map.get("evaluate_num").toString());
            dynamicState.setGift_num(map.get("gift_num").toString());
            dynamicStates.add(dynamicState);
        }
        return dynamicStates;
    }
    public List<DynamicState> getMyFD(String code){
        List<DynamicState> dynamicStates=new ArrayList<DynamicState>();
        JdbcTemplate jdbcTemplate= (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sql="select name,user_dp,state_code,user_text,song_picture,song_name,like_num,share_num,evaluate_num,gift_num\n" +
                "from user_info a,song b,dynamic_state c\n" +
                "where c.code='"+code+"' and a.`code`=c.`code`";
        List<Map<String,Object>>list=jdbcTemplate.queryForList(sql);
        for(Map<String, Object> map : list){
            DynamicState dynamicState=new DynamicState();
            dynamicState.setName(map.get("name").toString());
            dynamicState.setUser_dp(map.get("user_dp").toString());
            dynamicState.setState_code(map.get("state_code").toString());
            dynamicState.setUser_text(map.get("user_text").toString());
            dynamicState.setSong_picture(map.get("song_picture").toString());
            dynamicState.setSong_name(map.get("song_name").toString());
            dynamicState.setLike_num(map.get("like_num").toString());
            dynamicState.setShare_num(map.get("share_num").toString());
            dynamicState.setEvaluate_num(map.get("evaluate_num").toString());
            dynamicState.setGift_num(map.get("gift_num").toString());
            dynamicStates.add(dynamicState);
        }
        return dynamicStates;
    }

    public DynamicStateInfo getDSI(String state_code){
        JdbcTemplate jdbcTemplate=(JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        DynamicStateInfo dynamicStateInfo=new DynamicStateInfo();
        String sql="select *\n" +
                "from dynamic_state\n" +
                "where state_code='"+state_code+"'";
        List<Map<String,Object>>list=jdbcTemplate.queryForList(sql);
        /*动态基本信息*/
        dynamicStateInfo.setCode(list.get(0).get("code").toString());
        dynamicStateInfo.setState_code(list.get(0).get("state_code").toString());
        dynamicStateInfo.setSong_code(list.get(0).get("song_code").toString());
        dynamicStateInfo.setUser_text(list.get(0).get("user_text").toString());
        dynamicStateInfo.setShare_num(list.get(0).get("share_num").toString());
        dynamicStateInfo.setLike_num(list.get(0).get("like_num").toString());
        dynamicStateInfo.setEvaluate_num(list.get(0).get("evaluate_num").toString());
        dynamicStateInfo.setGift_num(list.get(0).get("gift_num").toString());
        /*动态用户信息*/
        sql="select user_dp,name\n" +
                "from user_info\n" +
                "where code='"+dynamicStateInfo.getCode()+"'";
        list=jdbcTemplate.queryForList(sql);
        dynamicStateInfo.setUser_dp(list.get(0).get("user_dp").toString());
        dynamicStateInfo.setName(list.get(0).get("name").toString());
        /*评论详细内容*/
        List<Comment> comments=new ArrayList<Comment>();
        sql="select friend_code,text,user_dp as friend_dp,name as friend_name\n" +
                "from dynamic_state_evaluate a,user_info b\n" +
                "where b.code in(\n" +
                "\tselect friend_code\n" +
                "\tfrom dynamic_state\n" +
                "\twhere state_code='"+state_code+"'\n" +
                ")";
        list=jdbcTemplate.queryForList(sql);
        for(Map<String, Object> map : list){
            Comment comment=new Comment();
            comment.setFriend_code(map.get("friend_code").toString());
            comment.setFriend_dp(map.get("friend_dp").toString());
            comment.setFriend_name(map.get("friend_name").toString());
            comment.setText(map.get("text").toString());
            comments.add(comment);
        }
        dynamicStateInfo.setComments(comments);
        return dynamicStateInfo;
    }

    public int addComment(String state_code,String friend_code ,String text){
        int n=0;
        JdbcTemplate jdbcTemplate=(JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sql="INSERT INTO dynamic_state_evaluate\n" +
                "(state_code,friend_code,text,isread)\n" +
                "VALUES ('"+state_code+"','"+friend_code+"','"+text+"',0)";
        try {
            n=jdbcTemplate.update(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return n;
    }
}
