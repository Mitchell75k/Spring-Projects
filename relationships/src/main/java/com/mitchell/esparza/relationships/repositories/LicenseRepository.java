package com.mitchell.esparza.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mitchell.esparza.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findAll(); // this method retrieves all the licenses from the database
}
