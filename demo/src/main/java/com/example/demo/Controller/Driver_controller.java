package com.example.demo.Controller;
import com.example.demo.Domain.Driver;
import com.example.demo.Domain.DataBase;
import com.example.demo.Services.DriverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class Driver_controller {

    DataBase dataBase;

    @Autowired
    private DriverServices driverServices;

    @GetMapping("/Customer")
    List<Driver> list()
    {
        return  driverServices.ListAll();
    }

    @GetMapping("/Customer/{userName}")
    public ResponseEntity<Driver> get(@PathVariable String userName) {
        try {
            Driver driver = driverServices.getByName(userName);
            return new ResponseEntity<Driver>(driver, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<Driver>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Customer/getPassword/{password}")
    public ResponseEntity<Driver> getByEmail(@PathVariable String password) {
        try {
            Driver driver = driverServices.getByPassword(password);
            return new ResponseEntity<Driver>(driver, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<Driver>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Customer")
    public void add(@RequestBody Driver driver) {
        driverServices.save(driver);
    }

    @DeleteMapping("/Customer/{password}")
    public void deleteName(@PathVariable String name) {
        driverServices.deleteName(name);
    }

    @DeleteMapping("/Customer/{password}")
    public void deletePassword(@PathVariable String password) {
        driverServices.deletePassword(password);
    }

    @PutMapping("/Customer/updateAll/{password}")
    public ResponseEntity<?> update(@RequestBody Driver driver, @PathVariable String password) {
        try {
            driver.set_password(password);
            driverServices.save(driver);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/updateName/{password}/{name}")
    public ResponseEntity<?> updateUsername( @PathVariable String password,@ PathVariable String name)
    {
        try {
            Driver driver= driverServices.getByPassword(password);
            driver.set_name(name);
            driverServices.save(driver);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/updatePassword/{password}")
    public ResponseEntity<?> updateEmail( @PathVariable String password,@ PathVariable String name)
    {
        try {
            Driver driver= driverServices.getByPassword(password);
            driver.set_password(password);
            driverServices.save(driver);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void add_driver(Driver driver)
    {
        dataBase.list_drivers.add(driver);
    }

    public boolean search(String userName, String password)
    {
        boolean flag = false;
        for (Driver d : dataBase.list_drivers)
        {
            if (d.get_name().equals(userName) && d.get_password().equals(password))
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

    public void add_favourite_area(String fav)
    {
        dataBase.favouriteArea.add(fav);
    }

    public ArrayList<String> get_favourite_area()
    {
        return dataBase.favouriteArea;
    }

}
