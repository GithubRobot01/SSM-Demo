package cn.itcast.controller;


import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.RoleService;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/all")
    public ModelAndView findAllUser(){
        ModelAndView modelAndView=new ModelAndView();
        List<User> userList=userService.findAllUser();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView findAllRole(){
        ModelAndView modelAndView=new ModelAndView();
        List<Role> roleList = roleService.findAllRole();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String addUser(User user,String[] roleIds){
        userService.addUser(user,roleIds);
        return "redirect:/user/all";
    }

    @RequestMapping("/del/{uid}")
    public String delUser(@PathVariable("uid") int id){
        userService.delUser(id);
        return "redirect:/user/all";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user=userService.login(username,password);
        System.out.println(user);
        if (user!=null){
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
