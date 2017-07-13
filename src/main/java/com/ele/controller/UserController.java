package com.ele.controller;

import com.ele.dto.UserLogin;
import com.ele.dto.UserRegister;
import com.ele.pojo.Like;
import com.ele.pojo.Shop;
import com.ele.pojo.User;
import com.ele.pojo.UserAddress;
import com.ele.service.UserService;
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
     * 返回要修改的地址信息，并跳转至修改地址界面
     * @param addressId
     * @param req
     * @return
     */
    @RequestMapping(value = "/profile/address/update/{addressId:\\d+}",method = RequestMethod.GET)
    public String updateUserAddress(@PathVariable Integer addressId,HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        boolean isContain = false;
        List<UserAddress> addressList = user.getAddressList();
        for(UserAddress address: addressList) {
            if(address.getId() == addressId) {
                isContain = true;
            }
        }
        //跳转至updateAddress界面(未实现)
        if(isContain) {
            return "server/user/updateAddress";
        } else {
            return "redirect:/profile/address";
        }
    }

    /**
     * 更新用户的地址
     * @param userAddress
     * @param req
     * @return
     */
    @RequestMapping(value = "/profile/address/update/{addressId:\\d+}",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String getUserUpdateAddress(@RequestBody UserAddress userAddress,HttpServletRequest req) {
        userService.updateUserAddress(userAddress);
        return "success";
    }



    /**
     * 用户注册
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public UserRegister registerUser(@RequestBody User user) {
        UserRegister userRegister = new UserRegister();
        if(userService.registUser(user)) {
            userRegister.setMsgUsername("用户名合法");
            userRegister.setMsgPassword("成功");
            userRegister.setMsg("注册成功");
            return userRegister;
        } else {
            userRegister.setMsgUsername("用户名不合法");
            userRegister.setMsgPassword("不成功");
            userRegister.setMsg("注册失败");
            return userRegister;
        }
    }

    /**
     * 用户登陆
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String loginUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
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

            HttpSession session = request.getSession();
            session.setAttribute("user",user);

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
     * 删除用户的地址
     * @param userAddress
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/profile/address/delete/{addressId:\\d+}",method =RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String delectUserAddress(@RequestBody UserAddress userAddress,HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        Integer id = user.getId();
        if (id != userAddress.getUserId()) {
            return "error";
        } else {
            userService.delectUserAddress(userAddress);
            return "success";
        }
    }
    /**
     * 增加用户的地址
     * @param userAddress
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "//profile/address/add:\\d+}",method =RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String addUserAddress(@RequestBody UserAddress userAddress){
        userService.addUserAddress(userAddress);
        return "success";
    }

}
