package com.webapp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    // open index("home") page
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    // open calculator page
    @RequestMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    // open alien page
    @RequestMapping("/alien")
    public String alien() {
        return "alien";
    }

//    using HttpServletRequest
//    @RequestMapping("/add")
//    public String add(HttpServletRequest request, HttpSession session) {
//        int num1 = Integer.parseInt(request.getParameter("num1"));
//        int num2 = Integer.parseInt(request.getParameter("num2"));
//        int result = num1 + num2;
//        session.setAttribute("result", result);
//        return "result.jsp";
//    }

//    using base on url parameter
//    @RequestMapping("/add")
//    public String add(int num1, int num2, HttpSession session) {
//        int result = num1 + num2;
//        session.setAttribute("result", result);
//        return "result.jsp";
//    }

//    using @RequestParam
//    @RequestMapping("/add")
//    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, HttpSession session) {
//        int result = num1 + num2;
//        session.setAttribute("result", result);
//        return "result.jsp";
//    }

    // using @RequestParam & Model
//    @RequestMapping("/add")
//    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
//        int result = num1 + num2;
//        model.addAttribute("result", result);
//        return "result.jsp";
//    }

    // using view resolver
//    @RequestMapping("/add")
//    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
//        int result = num1 + num2;
//        model.addAttribute("result", result);
//        return "result";
//    }


    // using ModelAndView
    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView modelAndView) {
        int result = num1 + num2;
        modelAndView.addObject("result", result);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    // using Model
//    @RequestMapping("/addAlien")
//    public ModelAndView addAlien(@RequestParam("alienId") int alienId, @RequestParam("alienName") String alienName,ModelAndView modelAndView) {
//
//        Alien alien = new Alien();
//        alien.setAlienId(alienId);
//        alien.setAlienName(alienName);
//        modelAndView.addObject(alien);
//        modelAndView.setViewName("alien-result");
//        return modelAndView;
//    }

    // using ModelAttribute
//    @RequestMapping("/addAlien")
//    public String addAlien(@ModelAttribute Alien alien) {
//        return "alien-result";
//    }

    // skip @ModelAttribute if params value same as object properties
    @RequestMapping("/addAlien")
    public String addAlien(Alien alien) {
        return "alien-result";
    }

    // @ModelAttribute at method level
    @ModelAttribute("course")
    public String courseName() {
        return "Java";
    }

}
