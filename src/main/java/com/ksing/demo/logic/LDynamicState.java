package com.ksing.demo.logic;

import com.ksing.demo.SpringUtil;
import com.ksing.demo.entity.DynamicState;
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
}
