package com.workshop.service;

import com.workshop.model.entity.Business;
import com.workshop.model.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;

    public List<Business> getAllBusinesses() {
        return (List<Business>) businessRepository.findAll();
    }

    public Business getBusinessByCompanyName(String companyName) {
        return businessRepository.findByCompanyName(companyName)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Business '%s' not found", companyName)));
    }

    public Business createBusiness(Business business) {
        if (businessRepository.existsByCompanyName(business.getCompanyName())) {
            throw new IllegalArgumentException(String.format("Business '%s' already exists", business.getCompanyName()));
        }
        return businessRepository.save(business);
    }

    public Business updateBusiness(String companyName, Business updated) {
        Business existing = getBusinessByCompanyName(companyName);
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        if (!companyName.equals(updated.getCompanyName())) {
            if (businessRepository.existsByCompanyName(updated.getCompanyName())) {
                throw new IllegalArgumentException(String.format("Business '%s' already exists", updated.getCompanyName()));
            }
            existing.setCompanyName(updated.getCompanyName());
        }
        return businessRepository.save(existing);
    }

    public void deleteBusiness(String companyName) {
        Business business = getBusinessByCompanyName(companyName);
        businessRepository.delete(business);
    }
}