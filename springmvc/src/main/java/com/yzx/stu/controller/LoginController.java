package com.yzx.stu.controller;

import com.yzx.stu.model.AuthenticationRequest;
import com.yzx.stu.model.UserDto;
import com.yzx.stu.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login")
    public String login(AuthenticationRequest authenticationRequest,HttpSession session){
        UserDto userDetails = authenticationService.authentication(authenticationRequest);
        session.setAttribute(UserDto.SESSION_USER_KEY,userDetails);
        return userDetails.getUsername() + " succ";
    }

    @RequestMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    public String r1(AuthenticationRequest authenticationRequest,HttpSession session){
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(userObj != null){
            fullname = ((UserDto)userObj).getFullname();
        }else{
            fullname = "匿名";
        }
        return fullname + " 访问资源1";
    }

    @RequestMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    public String r2(AuthenticationRequest authenticationRequest,HttpSession session){
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(userObj != null){
            fullname = ((UserDto)userObj).getFullname();
        }else{
            fullname = "匿名";
        }
        return fullname + " 访问资源1";
    }

    @GetMapping(value = "/logout",produces = {"text/plain;charset=UTF-8"})
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功";
    }
}
