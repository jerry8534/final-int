package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/login/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/login");
        return mv;
    }

    @RequestMapping("/login/signUp")
    public ModelAndView signUp() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/signUp");
        return mv;
    }

}
