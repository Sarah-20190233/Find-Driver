package com.example.demo.Services;

import com.example.demo.Reposatory.Driver_reposatory;
import com.example.demo.Domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DriverServices {
    @Autowired
    private Driver_reposatory driver_reposatory;

    public List<Driver> ListAll()
    {
        return  driver_reposatory.findAll();
    }
    public  void save(Driver driver)
    {
        driver_reposatory.save(driver);
    }
    public Driver getByName(String name) {
        return driver_reposatory.getByName(name);
    }
    public  void deleteName(String name)
    {
        driver_reposatory.delete(name);
    }

    public List<Driver> ListAll()
    {
        return  driver_reposatory.findAll();
    }

    public Driver getByPassword(String password) {
        return driver_reposatory.getByName(password);
    }
    public  void deletePassword(String password)
    {
        driver_reposatory.delete(password);
    }

}