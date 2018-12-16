package com.ksing.demo.controller;

import com.ksing.demo.entity.*;
import com.ksing.demo.file.FileCopy;
import com.ksing.demo.logic.LDynamicState;
import com.ksing.demo.logic.LSong;
import com.ksing.demo.logic.LUser;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.util.List;

@RestController
public class CUser {
    /*登录*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(HttpServletRequest request, HttpServletResponse response){
        String code=request.getParameter("code");
        String password=request.getParameter("password");
        User user=null;
        LUser lUser=new LUser();
        try{
            user=lUser.login(code,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (user==null){
            try {
                PrintWriter out = response.getWriter();
                out.write("null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            HttpSession session;
            session=request.getSession();
            session.setAttribute("code",code);
            response.addHeader("cookie",session.getId());
        }

        return user;
    }
    /*获取用户信息*/
    @RequestMapping(value = "/getuserinfo",method = RequestMethod.POST)
    public User_info getUserInfo(HttpServletRequest request, HttpServletResponse response){
//        String code=request.getParameter("code");
        String code=request.getSession().getAttribute("code").toString();
        System.out.println(code);
        User_info user_info=null;
        LUser lUser=new LUser();
        try {
            user_info=lUser.getUserInfo(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (user_info==null){
            try {
                PrintWriter out = response.getWriter();
                out.write("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return user_info;
    }
    /*获取我的信息主界面*/
    @RequestMapping("/getUserInfo")
    public UserInfo getinfo(HttpServletRequest request, HttpServletResponse response){
        String code=request.getSession().getAttribute("code").toString();
        LUser lUser=new LUser();
        UserInfo userInfo=null;
        userInfo=lUser.getinfo(code);
        return userInfo;
    }
    /*获取我的动态*/
    @RequestMapping("/getMyDynamic")
    public List<DynamicState> getMyDynamic(HttpServletRequest request){
        String code=request.getSession().getAttribute("code").toString();
        List<DynamicState> dynamicStates=null;
        LDynamicState lDynamicState=new LDynamicState();
        try {
            dynamicStates=lDynamicState.getMyFD(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dynamicStates;

    }
    /*更改姓名*/
    @RequestMapping(value = "/setname",method = RequestMethod.POST)
    public void setName(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        String name=request.getParameter("name");
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setName(code,name);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*更改性别*/
    @RequestMapping(value = "/setsex",method = RequestMethod.POST)
    public void setSex(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        String sex=request.getParameter("sex");
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setSex(code,sex);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*更改生日*/
    @RequestMapping(value = "/setbirthday",method = RequestMethod.POST)
    public void setBirthday(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        int birthday =Integer.parseInt(request.getParameter("birthday"));
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setBirthday(code,birthday);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*更改地址*/
    @RequestMapping(value = "/setliving_place",method = RequestMethod.POST)
    public void setLiving_place(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        String living_place=request.getParameter("living_place");
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setLivingPlace(code,living_place);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*更改签名*/
    @RequestMapping(value = "/setsignature",method = RequestMethod.POST)
    public void setSignature(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        String signature=request.getParameter("signature");
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setSignature(code,signature);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*更改学校*/
    @RequestMapping(value = "/setschool",method = RequestMethod.POST)
    public void setSchool(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        String school=request.getParameter("school");
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setSchool(code,school);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*更改职业*/
    @RequestMapping(value = "/setoccupation",method = RequestMethod.POST)
    public void setOccupation(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        String occupation=request.getParameter("occupation");
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setOccupation(code,occupation);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*更改家乡*/
    @RequestMapping(value = "/sethometown",method = RequestMethod.POST)
    public void setHometown(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        String hometown=request.getParameter("hometown");
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setHometown(code,hometown);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*更改身高*/
    @RequestMapping(value = "/setheight",method = RequestMethod.POST)
    public void setHeight(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        String height=request.getParameter("height");
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setHeight(code,height);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*更改活跃状态*/
    @RequestMapping(value = "/setis_show_in1",method = RequestMethod.POST)
    public void setIs_show_in1(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        String is_show_in1=request.getParameter("is_show_in1");
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setIs_show_in1(code,is_show_in1);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*更改显示自己*/
    @RequestMapping(value = "/setis_show_in2",method = RequestMethod.POST)
    public void setIs_show_in2(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getSession().getAttribute("code").toString();
        String is_show_in2=request.getParameter("is_show_in2");
        PrintWriter out = response.getWriter();
        LUser lUser=new LUser();
        boolean flag=lUser.setIs_show_in2(code,is_show_in2);
        if (flag){
            out.write("success");
        }else {
            out.write("fail");
        }
    }
    /*获取好友动态*/
    @RequestMapping("/getDynamicState")
    public List<DynamicState> getDynamicState(HttpServletRequest request){
        String code=request.getSession().getAttribute("code").toString();
        List<DynamicState> dynamicStates=null;
        LDynamicState lDynamicState=new LDynamicState();
        try {
            dynamicStates=lDynamicState.getFD(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dynamicStates;
    }
    /*获取评论消息*/
    @RequestMapping("/getMsg")
    public String getMsg(HttpServletRequest request){
        String code=request.getSession().getAttribute("code").toString();
        LUser lUser=new LUser();
        String name=lUser.getPLinfo(code);
        System.out.println("获取数据");
        lUser.isRead(code);
        System.out.println("消息已读");
        return name;
    }
    /*退出登陆*/
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request){
        request.getSession().invalidate();
    }

    @RequestMapping("/getDynamicStateInfo")
    public DynamicStateInfo getDynamicStateInfo(HttpServletRequest request){
        DynamicStateInfo dynamicStateInfo=new DynamicStateInfo();
        String state_code=request.getParameter("state_code").toString();
        LDynamicState lDynamicState=new LDynamicState();
        try {
            dynamicStateInfo=lDynamicState.getDSI(state_code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dynamicStateInfo;
    }
    /*添加评论*/
    @RequestMapping("addComment")
    public void addComment(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String code=request.getSession().getAttribute("code").toString();
        String text=request.getParameter("text").toString();
        String state_code=request.getParameter("state_code").toString();
        PrintWriter out=response.getWriter();
        LDynamicState lDynamicState=new LDynamicState();
        int flag=lDynamicState.addComment(state_code,code,text);
        if (flag==0){
            /*失败*/
            out.write("0");
        }else{
            /*成功*/
            out.write("1");
        }
    }
    @RequestMapping("/getListOfAllSong")
    public List<Song> getListOfAllSong(){
        List<Song> songs=null;
        LSong lSong=new LSong();
        songs=lSong.getListOfSong();
        return songs;
    }
    /*上传歌曲(后面还要数据库添加数据)*/
    @RequestMapping("/uploadMySong")
    public void uploadMySong(HttpServletRequest request,@RequestParam("upload") MultipartFile file) throws IOException, ServletException {
        /*项目地址*/
        String rootPath="F:/GitHub/KSingService/src/main/resources/static/song";
        /*原始文件名称*/
        String originalFilename=file.getOriginalFilename();
//        MultipartFile fileB=file;
        /*tomcat地址*/
        String path=request.getServletContext().getRealPath("/song/");
        File pathFile=new File(path);
        if (!pathFile.exists()){
            pathFile.mkdir();
        }
        System.out.println(path);
        try {
//            file.transferTo(new File(rootPath+File.separator+originalFilename));
            File file1=new File(path+File.separator+originalFilename);
            File file2=new File(rootPath+File.separator+originalFilename);
            file.transferTo(file1);
            FileCopy copy=new FileCopy();
            /*复制文件*/
            copy.fileCopyWithFileChannel(file1,file2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
