package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Shop;
import com.example.demo.service.ShopService;

@Controller
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping
    public String index(Model model) {
        List<Shop> shops = shopService.findAll();
        model.addAttribute("shops", shops);
        return "shops/index";
    }

    @GetMapping("new")
    public String newShop(Model model) {
        Shop shop = new Shop();
        model.addAttribute("shop", shop);
        return "shops/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Shop shop = shopService.findOne(id);
        model.addAttribute("shop", shop);
        return "shops/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Shop shop = shopService.findOne(id);
        model.addAttribute("shop", shop);
        return "shops/show";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Shop shop, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "shops/new";
        shopService.save(shop);
        return "redirect:/shops";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Shop shop, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "shops/edit";
        
        shop.setId(id);
        shopService.save(shop);
        return "redirect:/shops";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        shopService.delete(id);
        return "redirect:/shops";
    }
}