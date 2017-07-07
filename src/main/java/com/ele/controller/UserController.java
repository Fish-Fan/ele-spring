package com.ele.controller;

import com.ele.pojo.User;
import com.ele.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String userMsg(@PathVariable Integer id) {
        User user = userService.findById(id);
        Gson gson = new Gson();
        return gson.toJson(user);
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String registerUser(User user) {
        if(userService.registUser(user)) {
            return "success";
        } else {
            return "error";
        }
    }

}
