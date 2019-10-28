package com.xiaomi.controller;

import com.xiaomi.configuration.web.UserThread;
import com.xiaomi.dao.UserMapper;
import com.xiaomi.pojo.User;
import com.xiaomi.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService = null;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username, String password,String check, HttpSession session){
        User user = null;
        String vrifyCode = (String) session.getAttribute("vrifyCode#"+session.getId());
        if (!check.equalsIgnoreCase(vrifyCode)) return "login";
        if ((user = userService.login(username,password)) != null) {
            session.setAttribute(session.getId(),user.getId());
            session.setAttribute("user#"+user.getId(),user);

            session.setAttribute("userInfo",user);

            return "redirect:/index";
        }
        return "login";
//        String vrifyCode = (String) session.getAttribute("vrifyCode#"+session.getId());
//        if (!check.equalsIgnoreCase(vrifyCode)) {
//            return "login";
//        }
//
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        Subject subject = SecurityUtils.getSubject();
//        try{
//            subject.login(token);
//            return "redirect:/index";
//        }catch (Exception e){
//            e.printStackTrace();
//            return "login";
//        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ModelAndView register(@RequestParam(name = "username",defaultValue = "",required = true)String username,
                                 @RequestParam(name = "password",defaultValue = "",required = true) String password,
                                 @RequestParam(name = "tel",defaultValue = "",required = true) String tel){
        User user = new User(username,password,tel);
        userService.register(user);
        return new ModelAndView("login","username",username);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> update(@RequestParam Map<String,Object> params,HttpSession session){
        Map<String,Object> result = new HashMap<>();

        Integer id = Integer.valueOf((String)params.get("User[id]"));
        String username = (String) params.get("User[username]");
        String password = (String) params.get("User[password]");
        String tel = (String) params.get("User[tel]");
        String signature = (String) params.get("User[signature]");
        String hobby = (String) params.get("User[hobby]");
        String address = (String) params.get("User[address]");
        User user = new User(id,username,password,tel,signature,hobby,address);

        userService.UpdateUser(user);
        result.put("msg","修改成功!");
        session.removeAttribute("user#"+user.getId());
        session.setAttribute("user#"+user.getId(),user);
        return result;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView getInfo(@PathVariable("id")Integer id){
        User user = userService.getUserById(id);
        return new ModelAndView("self_info","User",user);
    }

    @RequestMapping("/loginOut/{id}")
    public String loginOut(@PathVariable("id")Integer id,HttpSession session){
        session.removeAttribute("user#"+id);
        return "redirect:/login";
    }

    @RequestMapping(value = "/check/{username}",method = RequestMethod.GET)
    @ResponseBody
    public String checkUsername(@PathVariable("username")String username){
        Integer count = userService.checkUsername(username);
        if (count != 0)
            return "已存在该用户!请重新输入用户名!";
        return null;
    }

}
