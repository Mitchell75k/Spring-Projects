package com.mitchell.esparza.tablemaster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitchell.esparza.tablemaster.models.User;
import com.mitchell.esparza.tablemaster.models.UserTable;
import com.mitchell.esparza.tablemaster.repositories.TableRepository;

@Service
public class TableService {
    @Autowired
    private TableRepository tRepo;
    
    public List<UserTable> getAllTables(){
        return this.tRepo.findAll();
    }
    
    public UserTable getOneTable(Long id) {
        return this.tRepo.findById(id).orElse(null);
    }
    
    public UserTable createTable(UserTable newTable) { 
        return this.tRepo.save(newTable);
    }
    
    public UserTable updateTable(UserTable updatedTable) {
        return this.tRepo.save(updatedTable);
    }
    
    public void deleteTable(Long id) {
        this.tRepo.deleteById(id);
    }

    public List<UserTable> getAllTablesByUser(User user) {
        return this.tRepo.findAllByUser(user); //returns all tables that belong to the logged in user
    }
}

