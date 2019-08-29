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

import com.example.demo.domain.ShopV2;
import com.example.demo.service.CategoryV1Service;
import com.example.demo.service.PriceRangeV1Service;
import com.example.demo.service.ShopV2Service;

@Controller
@RequestMapping("/v2/shops")
public class ShopV2Controller {
    @Autowired
    private ShopV2Service shopService;
    @Autowired
    private CategoryV1Service categoryV1Service;
    @Autowired
    private PriceRangeV1Service priceRangeV1Service;

    @GetMapping
    public String index(Model model) {
        List<ShopV2> shops = shopService.findAll();
        model.addAttribute("shops", shops);
        return "v2/shops/index";
    }

    @GetMapping("/new")
    public String newShop(Model model) {
        ShopV2 shop = new ShopV2();

        model.addAttribute("shopV2", shop);
        model.addAttribute("categories", categoryV1Service.findAll());
        model.addAttribute("priceRange", priceRangeV1Service.findAll());

        return "v2/shops/new";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        ShopV2 shop = shopService.findOne(id);
        model.addAttribute("shopV2", shop);
        model.addAttribute("categories", categoryV1Service.findAll());
        model.addAttribute("priceRange", priceRangeV1Service.findAll());

        return "v2/shops/edit";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        ShopV2 shop = shopService.findOne(id);
        model.addAttribute("shop", shop);
        return "v2/shops/show";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute ShopV2 shop, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("shopV2", shop);
            model.addAttribute("categories", categoryV1Service.findAll());
            model.addAttribute("priceRange", priceRangeV1Service.findAll());

            return "v2/shops/new";
        }
        shopService.save(shop);
        return "redirect:/v2/shops";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute ShopV2 shop, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("shopV2", shop);
            model.addAttribute("categories", categoryV1Service.findAll());
            model.addAttribute("priceRange", priceRangeV1Service.findAll());

            return "v2/shops/edit";
        }
        
        shop.setId(id);
        shopService.save(shop);
        return "redirect:/v2/shops";
    }

    @DeleteMapping("/{id}")
    public String destroy(@PathVariable Long id) {
        shopService.delete(id);
        return "redirect:/v2/shops";
    }
}