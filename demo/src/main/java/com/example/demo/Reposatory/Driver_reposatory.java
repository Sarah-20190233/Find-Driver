package com.example.demo.Reposatory;

import com.example.demo.Domain.Customer;
import com.example.demo.Domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface Driver_reposatory extends JpaRepository <Driver,String> {
    Driver getByName(String userName);
    Driver getByID (String id);
}
