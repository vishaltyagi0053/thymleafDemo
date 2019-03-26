package com.th.bootcamp.controller;

import com.th.bootcamp.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
public class DemoController {

    List<User> users = new ArrayList<>();

    public List<User> getUsers(){
        return users;
    }

    private List<String> getDepartments(){
        return Arrays.asList("JVM","MEAN");
    }

    @RequestMapping(value = "show",method = RequestMethod.GET)
    public ModelAndView showPage(){
        ModelAndView view = new ModelAndView("show");
        view.addObject("name","Gagan");
        return view;
    }

    @GetMapping(value = "sayHello")
    public ModelAndView sayHello() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("list",list);
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @GetMapping(value = "showCreate")
    public ModelAndView show(String error){
        ModelAndView view = new ModelAndView("create");
        view.addObject("user",new User());
        view.addObject("error",error);
        view.addObject("departments",getDepartments());
        return view;
    }

    @PostMapping("create")
    public ModelAndView create(@ModelAttribute @Valid User user, BindingResult result){
        if(Objects.isNull(user.getName()) || user.getName() == ""){
            //result.getAllErrors().forEach(System.out::println);
            return show("Name is required.");
        }
        System.out.println("user "+user.getName());
        users.add(user);
        /*ModelAndView view = new ModelAndView("hello");
        view.addObject("list",Arrays.asList(1,2,3));
        view.addObject("user",user);*/
        return list();
    }

    @GetMapping("list")
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("listUser");
        view.addObject("users",getUsers());
        return view;
    }
}
