package com.workshop.service;

import com.workshop.model.entity.Business;
import com.workshop.model.entity.Shop;
import com.workshop.model.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final BusinessService businessService;

    public List<Shop> getAllShops(String companyName) {
        Business business = businessService.getBusinessByCompanyName(companyName);
        return shopRepository.findAllByBusiness(business);
    }

    public Shop getShop(String companyName, String shopName) {
        Business business = businessService.getBusinessByCompanyName(companyName);
        return shopRepository.findByNameAndBusiness(shopName, business)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Shop '%s' not found in business '%s'", shopName, companyName)));
    }

    public Shop createShop(String companyName, Shop shop) {
        Business business = businessService.getBusinessByCompanyName(companyName);
        if (shopRepository.existsByNameAndBusiness(shop.getName(), business)) {
            throw new IllegalArgumentException(
                    String.format("Shop '%s' already exists in business '%s'", shop.getName(), companyName));
        }
        shop.setBusiness(business);
        return shopRepository.save(shop);
    }

    public Shop updateShop(String companyName, String shopName, Shop updated) {
        Shop existing = getShop(companyName, shopName);
        existing.setAddress(updated.getAddress());
        existing.setPhone(updated.getPhone());
        if (!shopName.equals(updated.getName())) {
            Business business = existing.getBusiness();
            if (shopRepository.existsByNameAndBusiness(updated.getName(), business)) {
                throw new IllegalArgumentException(
                        String.format("Shop '%s' already exists in business '%s'", updated.getName(), companyName));
            }
            existing.setName(updated.getName());
        }
        return shopRepository.save(existing);
    }

    public void deleteShop(String companyName, String shopName) {
        Shop shop = getShop(companyName, shopName);
        shopRepository.delete(shop);
    }
}