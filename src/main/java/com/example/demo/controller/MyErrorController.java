package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String error404(Model model) {
        model.addAttribute("errmessage", "pageNotFound");
        return "404error";
    }
    
    @Override
    public String getErrorPath() {
        return "";
    }

}