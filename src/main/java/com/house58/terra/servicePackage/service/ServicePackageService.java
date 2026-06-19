package com.house58.terra.servicePackage.service;

import com.house58.terra.servicePackage.dao.ServicePackageRepository;
import com.house58.terra.servicePackage.entity.ServicePackage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServicePackageService {

    private final ServicePackageRepository servicePackageRepository;

    public ServicePackageService(ServicePackageRepository servicePackageRepository) {
        this.servicePackageRepository = servicePackageRepository;
    }

    public ServicePackage Register(ServicePackage servicePackage){
        return this.servicePackageRepository.saveAndFlush(servicePackage);
    }

    public List<ServicePackage> findAll(){
        return this.servicePackageRepository.findAll();
    }
}
