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
        String sql="SELECT song_code,code,song_name,singer,song_picture,song_path\n" +
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
                song.setSong_path(map.get("song_path").toString());
                songs.add(song);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return songs;
    }

    public int addSong(String code,String song_name,String singer,String song_picture,String song_path){
        int n=0;
        JdbcTemplate jdbcTemplate= (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sql="insert into song(song_code,songsheet_code,code,song_name,singer,song_picture,song_path) \n" +
                "values ('10003','10001','"+code+"','"+song_name+"','"+singer+"','"+song_picture+"','"+song_path+"')";
        try {
            n=jdbcTemplate.update(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  n;
    }

    public Song findSong(String song_code){
        Song song=null;
        JdbcTemplate jdbcTemplate= (JdbcTemplate) SpringUtil.applicationContext.getBean("jdbcTemplate");
        String sql="SELECT\n" +
                "song.song_picture,\n" +
                "song.song_name\n" +
                "FROM\n" +
                "song\n" +
                "where song.song_code='"+song_code+"'";
        try {
            List<Map<String,Object>>list=jdbcTemplate.queryForList(sql);
//            System.out.println(list.get(0).get("song_picture").toString());
            String song_picture=list.get(0).get("song_picture").toString();
            song=new Song();
            song.setSong_picture(song_picture);
            String song_name=list.get(0).get("song_name").toString();
            song.setSong_name(song_name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return song;
    }
}
