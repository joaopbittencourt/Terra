package com.house58.terra.servicePackage.controller;

import com.house58.terra.servicePackage.entity.ServicePackage;
import com.house58.terra.servicePackage.service.ServicePackageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-package")
public class ServicePackageController {
    private final ServicePackageService servicePackageService;

    public ServicePackageController(ServicePackageService servicePackageService) {
        this.servicePackageService = servicePackageService;
    }

    @PostMapping("save-service-package")
    private ServicePackage save(@RequestBody ServicePackage servicePackage){
        return this.servicePackageService.Register(servicePackage);
    }

    @GetMapping()
    private List<ServicePackage> findAll(){
        return this.servicePackageService.findAll();
    }

}
