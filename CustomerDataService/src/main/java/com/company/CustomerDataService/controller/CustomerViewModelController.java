package com.company.CustomerDataService.controller;

import com.company.CustomerDataService.service.ServiceLayer;
import com.company.CustomerDataService.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerViewModelController {

    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping("/customer")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerViewModel> getAllCustomers() {

        return serviceLayer.findAllCustomers();
    }

    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerViewModel getCustomerById(@PathVariable int id) {

        return serviceLayer.findCustomer(id);
    }

    @GetMapping("/customer/level/{level}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerViewModel> getCustomerByLevel(@PathVariable String level) {

        return serviceLayer.findCustomerByLevel(level);
    }

    @GetMapping("/customer/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List <CustomerViewModel> getCustomerByState(@PathVariable String state) {

        return serviceLayer.findByCustomerState(state);
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerViewModel createCustomer(@RequestBody CustomerViewModel input) {
        return serviceLayer.saveCustomer(input);
    }

    @PutMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable int id, @RequestBody CustomerViewModel input) {
        if (id != input.getId()) {
            throw new DataIntegrityViolationException("You don't have matching ids");
        }
        serviceLayer.updateCustomer(input);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        serviceLayer.removeCustomer(id);
    }

}
