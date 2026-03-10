package com.workshop.controller.shop;

import com.workshop.model.entity.Business;
import com.workshop.service.BusinessService;
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
@RequestMapping("/v1/business")
public class BusinessController {

    private final BusinessService businessService;

    @GetMapping
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    @GetMapping("/{companyName}")
    public Business getBusiness(@PathVariable String companyName) {
        return businessService.getBusinessByCompanyName(companyName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Business createBusiness(@RequestBody Business business) {
        return businessService.createBusiness(business);
    }

    @PutMapping("/{companyName}")
    public Business updateBusiness(@PathVariable String companyName, @RequestBody Business business) {
        return businessService.updateBusiness(companyName, business);
    }

    @DeleteMapping("/{companyName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBusiness(@PathVariable String companyName) {
        businessService.deleteBusiness(companyName);
    }
}