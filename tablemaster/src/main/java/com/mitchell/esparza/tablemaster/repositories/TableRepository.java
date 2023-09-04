package com.mitchell.esparza.tablemaster.repositories;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitchell.esparza.tablemaster.models.User;
import com.mitchell.esparza.tablemaster.models.UserTable;

@Repository
public interface TableRepository extends CrudRepository<UserTable, Long> {
        
        List<UserTable> findAll();

        List<UserTable> findAllByUser(User user);
        
}