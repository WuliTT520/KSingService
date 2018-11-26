package com.ksing.demo.controller;

import com.ksing.demo.entity.User;
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
}
