package com.example.demo.Services;

import com.example.demo.Reposatory.Customer_reposatory;
import com.example.demo.Domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServices {
    @Autowired
    private Customer_reposatory customer_reposatory;

    public List<Customer> ListAll()
    {
        return  customer_reposatory.findAll();
    }
    public  void save(Customer customer)
    {
        customer_reposatory.save(customer);
    }
    public Customer getByName(String name) {
        return customer_reposatory.getByName(name);
    }
    public  void deleteName(String name)
    {
        customer_reposatory.delete(name);
    }

    public List<Customer> ListAll()
    {
        return  customer_reposatory.findAll();
    }

    public Customer getByPassword(String password) {
        return customer_reposatory.getByName(password);
    }
    public  void deletePassword(String password)
    {
        customer_reposatory.delete(password);
    }

}
