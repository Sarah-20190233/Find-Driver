package com.example.demo.Controller;
import com.example.demo.Domain.Customer;
import com.example.demo.Domain.DataBase;
import com.example.demo.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class Customer_controller {

    DataBase dataBase;

    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/Customer")
    List<Customer> list()
    {
        return  customerServices.ListAll();
    }

    @GetMapping("/Customer/{userName}")
    public ResponseEntity<Customer> get(@PathVariable String userName) {
        try {
            Customer customer = customerServices.getByName(userName);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Customer/getPassword/{password}")
    public ResponseEntity<Customer> getByEmail(@PathVariable String password) {
        try {
            Customer customer = customerServices.getByPassword(password);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Customer")
    public void add(@RequestBody Customer customer) {
        customerServices.save(customer);
    }

    @DeleteMapping("/Customer/{password}")
    public void deleteName(@PathVariable String name) {
        customerServices.deletePassword(name);
    }

    @DeleteMapping("/Customer/{password}")
    public void deletePassword(@PathVariable String password) {
        customerServices.deletePassword(password);
    }

    @PutMapping("/Customer/updateAll/{password}")
    public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable String password) {
        try {
            customer.setPassword(password);
            customerServices.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/updateName/{password}/{name}")
    public ResponseEntity<?> updateUsername( @PathVariable String password,@ PathVariable String name)
    {
        try {
            Customer customer= customerServices.getByPassword(password);
            customer.setUserName(name);
            customerServices.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/updatePassword/{password}")
    public ResponseEntity<?> updateEmail( @PathVariable String password,@ PathVariable String name)
    {
        try {
            Customer customer= customerServices.getByPassword(password);
            customer.setPassword(password);
            customerServices.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void add_customer(Customer customer)
    {
        dataBase.list_customers.add(customer);
    }


    public boolean search(String userName, String password)
    {
        boolean flag = false;
        for (Customer c : dataBase.list_customers)
        {
            if (c.getUserName().equals(userName) && c.getPassword().equals(password))
                flag = true;
        }
        if (flag)
        {
            return true;
        }
        else
        {
            System.out.println("you aren't registered to the system");
            return false;
        }
    }

}
