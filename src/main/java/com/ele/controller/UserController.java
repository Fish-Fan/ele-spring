package com.ele.controller;

import com.ele.dto.UserLogin;
import com.ele.dto.UserRegister;
import com.ele.pojo.Like;
import com.ele.pojo.Shop;
import com.ele.pojo.User;
import com.ele.pojo.UserAddress;
import com.ele.service.UserService;
import com.ele.util.EleUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 返回用户地址
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/profile/address",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getUserAddress(HttpServletRequest req) {
        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
        User user = userService.findById(1);

        List<UserAddress> addressList = userService.getUserAddress(user);
        Gson gson = new Gson();
        return gson.toJson(addressList);
    }


    /**
     * 更新用户的地址
     * @param userAddress
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/profile/address/update",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String getUserUpdateAddress(@RequestBody UserAddress userAddress,HttpServletRequest req) {
        System.out.println(userAddress);
        userService.updateUserAddress(userAddress);
        return "success";
    }


    /**
     * 删除用户的地址
     * @param userAddress
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/profile/address/delete/{addressId:\\d+}",method =RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String delectUserAddress(@RequestBody UserAddress userAddress,HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
//        User user = (User) httpSession.getAttribute("user");
        User user = userService.findById(1);
        boolean result = EleUtil.checkUserHasAddress(user,userAddress.getId(),userService);
        if(result) {
            userService.delectUserAddress(userAddress);
            return "success";
        } else {
            return "error";
        }

    }

    /**
     * 增加用户的地址
     * @param userAddress
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/profile/address/add",method =RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String addUserAddress(@RequestBody UserAddress userAddress){
        if("".equals(userAddress.getUserAddress())) {
            return "error";
        }
        Integer id = userService.addUserAddress(userAddress);
        userAddress.setId(id);

        Gson gson = new Gson();
        return gson.toJson(userAddress);
    }



    /**
     * 用户注册
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String registerUser(@RequestBody User user) {
        UserRegister userRegister = new UserRegister();
        if(userService.registUser(user)) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 用户登录
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String loginUser(HttpServletRequest request){
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setEmail(username);
        user.setPassword(password);
        UserLogin userLogin = new UserLogin();
        User user1 = userService.loginUser(user);
        if (user1 != null) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user1);
            userLogin.setMsgUsername("用户名正确");
            userLogin.setMsgPassword("密码正确");
            userLogin.setMsg("登陆成功");
            userLogin.setStatus(1);

        }else {
            userLogin.setMsgUsername("用户名错误");
            userLogin.setMsgPassword("密码错误");
            userLogin.setMsg("登陆失败");
            userLogin.setStatus(0);

        }

        Gson gson = new Gson();
        return gson.toJson(userLogin);

    }



    /**
     * 用户注销
     * @param req
     * @return
     */
    @RequestMapping(value = "/invalidate",method = RequestMethod.GET)
    public String InvalidateUser(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return "server/user/index";
    }

    /**
     * 收藏商家
     * @param request
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/like",method =RequestMethod.GET,produces ="application/json;charset=utf-8" )
    public String collect( HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");

        List<Like> shopList = userService.getCollectShopByUserId(user.getId());
        Gson gson = new Gson();
        return  gson.toJson(shopList);

    }

    /**
     * 更新用户头像
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changeavatar",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String changeUserAvatar(HttpServletRequest req) {
        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
        User user = userService.findById(1);
        String avatar = req.getParameter("avatar");
        System.out.println("avatar->" + avatar);
        user.setAvatar(avatar);
        userService.updateAvatar(user);
        return "success";
    }

    /**
     * 用户名更新
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changeusername",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String updateUserName(@RequestBody User user,HttpServletRequest request){
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        System.out.println("username->" + user.getUsername());

        user.setId(sessionUser.getId());

        userService.updateUserName(user);
        return "success";
    }



}
