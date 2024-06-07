package com.syrine.bookc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.syrine.bookc.models.LoginUser;
import com.syrine.bookc.models.User;
import com.syrine.bookc.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	//Dependencies injection UserService
    @Autowired
    private UserService userService;
    
    
    //! Login registration Get Mapping
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    //! PostMapping Register
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, HttpSession session, Model model){
        // pass the user object to the register method in the service
        userService.register(newUser, result);
        // if there are errors
        if(result.hasErrors()){
            //  pass the newLogin object to the index page for login
            model.addAttribute("newLogin", new LoginUser());
            // return the index page
            return "index.jsp";
        }else{
            // set the user id in session
            session.setAttribute("user_id", newUser.getId());
            // redirect to the cars route
            return "redirect:/books";
        }
    }
    
    
    //PostMapping Login
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, HttpSession session, Model model){
        // pass the newLogin object to the login method in the service
        User user = userService.login(newLogin, result);
        // if there are errors
        if(result.hasErrors()){
            // pass the newUser object to the index page for registration
            model.addAttribute("newUser", new User());
            // return the index page
            return "index.jsp";
        }else{
            // set the user id in session
            session.setAttribute("user_id", user.getId());
            // redirect to the cars route
            return "redirect:/books";
        }
    }
    
    //Logout
    @GetMapping("/logout")
    public String logout(HttpSession session){
        // invalidate session
        session.invalidate();
        // redirect to the index route
        return "redirect:/";
    }


}
