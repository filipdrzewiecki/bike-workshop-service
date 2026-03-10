package com.workshop.controller.shop;

import com.workshop.model.entity.Shop;
import com.workshop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/business/{companyName}/shops")
public class ShopController {

    private final ShopService shopService;

    @GetMapping
    public List<Shop> getAllShops(@PathVariable String companyName) {
        return shopService.getAllShops(companyName);
    }

    @GetMapping("/{shopName}")
    public Shop getShop(@PathVariable String companyName, @PathVariable String shopName) {
        return shopService.getShop(companyName, shopName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shop createShop(@PathVariable String companyName, @RequestBody Shop shop) {
        return shopService.createShop(companyName, shop);
    }

    @PutMapping("/{shopName}")
    public Shop updateShop(@PathVariable String companyName, @PathVariable String shopName, @RequestBody Shop shop) {
        return shopService.updateShop(companyName, shopName, shop);
    }

    @DeleteMapping("/{shopName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShop(@PathVariable String companyName, @PathVariable String shopName) {
        shopService.deleteShop(companyName, shopName);
    }
}