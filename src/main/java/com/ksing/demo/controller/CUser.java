package com.ksing.demo.controller;

import com.ksing.demo.entity.User;
import com.ksing.demo.entity.User_info;
import com.ksing.demo.logic.LUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        }
        return user;
    }
    /*获取用户信息*/
    @RequestMapping(value = "/getuserinfo",method = RequestMethod.POST)
    public User_info getUserInfo(HttpServletRequest request, HttpServletResponse response){
        String code=request.getParameter("code");
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
    /*更改姓名*/
    @RequestMapping(value = "/setname",method = RequestMethod.POST)
    public void setName(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
    @RequestMapping(value = "/setsex",method = RequestMethod.POST)
    public void setSex(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
    @RequestMapping(value = "/setbirthday",method = RequestMethod.POST)
    public void setBirthday(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
    @RequestMapping(value = "/setliving_place",method = RequestMethod.POST)
    public void setLiving_place(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
    @RequestMapping(value = "/setsignature",method = RequestMethod.POST)
    public void setSignature(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
    @RequestMapping(value = "/setschool",method = RequestMethod.POST)
    public void setSchool(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
    @RequestMapping(value = "/setoccupation",method = RequestMethod.POST)
    public void setOccupation(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
    @RequestMapping(value = "/sethometown",method = RequestMethod.POST)
    public void setHometown(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
    @RequestMapping(value = "/setheight",method = RequestMethod.POST)
    public void setHeight(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
    @RequestMapping(value = "/setis_show_in1",method = RequestMethod.POST)
    public void setIs_show_in1(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
    @RequestMapping(value = "/setis_show_in2",method = RequestMethod.POST)
    public void setIs_show_in2(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
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
}
