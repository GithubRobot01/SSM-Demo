package cn.itcast.controller;


import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/all")
    public ModelAndView findAllRole(){
        ModelAndView modelAndView=new ModelAndView();
        List<Role> roleList=roleService.findAllRole();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String addRole(Role role){
        roleService.addRole(role);
        return "redirect:/role/all";
    }
}
