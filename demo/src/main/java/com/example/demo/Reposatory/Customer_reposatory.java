package com.example.demo.Reposatory;

import com.example.demo.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface Customer_reposatory extends JpaRepository<Customer,String> {
    Customer getByName(String userName);
    Customer getByID (String id);
}
