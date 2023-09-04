package com.mitchell.esparza.relationships.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mitchell.esparza.relationships.models.License;
import com.mitchell.esparza.relationships.repositories.LicenseRepository;


@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;
    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }
    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }
    public License createLicense(License license) {
        return licenseRepository.save(license);
    }
    public License findLicense(Long id) {
        return licenseRepository.findById(id).orElse(null);
    }
    public void deleteLicense(Long id) {
        licenseRepository.deleteById(id);
    }
    public License updateLicense(License license) {
        return licenseRepository.save(license);
    }


}
