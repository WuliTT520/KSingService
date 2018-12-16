package com.ksing.demo.logic;

import com.ksing.demo.SpringUtil;
import com.ksing.demo.entity.Song;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LSong {
    public List<Song> getListOfSong(){
        List<Song> songs=new ArrayList<Song>();
        JdbcTemplate jdbcTemplate= (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sql="SELECT song_code,code,song_name,singer,song_picture\n" +
                "FROM song";
        try {
            List<Map<String,Object>>list=jdbcTemplate.queryForList(sql);
            for(Map<String, Object> map : list){
                Song song=new Song();
                song.setSong_code(map.get("song_code").toString());
                song.setCode(map.get("code").toString());
                song.setSong_name(map.get("song_name").toString());
                song.setSinger(map.get("singer").toString());
                song.setSong_picture(map.get("song_picture").toString());
                songs.add(song);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return songs;
    }
}
