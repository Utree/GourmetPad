package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/shops") // ①
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping
    public String index(Model model) { // ②
        List<Shop> shops = shopService.findAll();
        model.addAttribute("shops", shops); // ③
        return "shops/index"; // ④
    }

    @GetMapping("new")
    public String newShop(Model model) {
        return "shops/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤
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
    public String create(@ModelAttribute Shop shop) { // ⑥
        shopService.save(shop);
        return "redirect:/shops"; // ⑦
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Shop shop) {
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