package com.company.CustomerDataService.service;

import com.company.CustomerDataService.repository.CustomerRepo;
import com.company.CustomerDataService.model.Customer;
import com.company.CustomerDataService.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ServiceLayer {

    private CustomerRepo customerRepo;


    @Autowired
    public ServiceLayer(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
//
    }

    @Transactional
    public CustomerViewModel saveCustomer(CustomerViewModel viewModel) {

        // Persist Customer
        Customer c = new Customer();
        c.setFirstName(viewModel.getFirstName());
        c.setLastName(viewModel.getLastName());
        c.setStreet(viewModel.getStreet());
        c.setCity(viewModel.getCity());
        c.setState(viewModel.getState());
        c.setZip(viewModel.getZip());
        c.setLevel(viewModel.getLevel());

        c = customerRepo.save(c);

        viewModel.setId(c.getId());

        return viewModel;
    }

    private CustomerViewModel buildCustomerViewModel(Customer customer) {

        // Assemble the CustomerViewModel
        CustomerViewModel cvm = new CustomerViewModel();
        cvm.setId(customer.getId());
        cvm.setFirstName(customer.getFirstName());
        cvm.setLastName(customer.getLastName());
        cvm.setStreet(customer.getStreet());
        cvm.setCity(customer.getCity());
        cvm.setState(customer.getState());
        cvm.setZip(customer.getZip());
        cvm.setLevel(customer.getLevel());

        // Return the CustomerViewModel
        return cvm;
    }

    public List<CustomerViewModel> findAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();
        List<CustomerViewModel> cvmList = new ArrayList<>();

        for (Customer Customer : customerList) {
            CustomerViewModel cvm = buildCustomerViewModel(Customer);
            cvmList.add(cvm);
        }
        return cvmList;
    }


    public CustomerViewModel findCustomer(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        return customer.isPresent() ? buildCustomerViewModel(customer.get()) : null;
    }

    public List<CustomerViewModel> findCustomerByLevel(String level) {
       List<Customer> customer = customerRepo.findByLevel(level);
       List<CustomerViewModel> custLevelList = customer.stream()
               .map(l -> buildCustomerViewModel(l))
               .collect(Collectors.toList());
               return custLevelList;
    }

    public List<CustomerViewModel> findByCustomerState(String state) {
        List<Customer> customer = customerRepo.findByState(state);
        List<CustomerViewModel> custStateList = customer.stream()
                .map(s -> buildCustomerViewModel(s))
                .collect(Collectors.toList());
                return custStateList;
    }



    @Transactional
    public void updateCustomer(CustomerViewModel viewModel) {

        // Update the Customer information
        Customer customer = new Customer();
        customer.setId(viewModel.getId());
        customer.setFirstName(viewModel.getFirstName());
        customer.setLastName(viewModel.getLastName());
        customer.setStreet(viewModel.getStreet());
        customer.setCity(viewModel.getCity());
        customer.setState(viewModel.getState());
        customer.setZip(viewModel.getZip());
        customer.setLevel(viewModel.getLevel());

        customerRepo.save(customer);

    }

    @Transactional
    public void removeCustomer(int id) {
        // Remove Customer
        customerRepo.deleteById(id);

    }


}


//    private CustomerViewModel buildCustomerViewModel(Customer customer) {
//
//        // Get the associated artist
//        Optional<Customer> customer = customerRepo.findById(customer.getId());
//
//        // Assemble the AlbumViewModel
//        CustomerViewModel cvm = new CustomerViewModel();
//        cvm.setId(customer.getId());
//        cvm.setFirstName(customer.getFirstName());
//        cvm.setLastName(customer.getLastName());
//        cvm.setStreet(customer.getStreet());
//        cvm.setCity(customer.getCity());
//        cvm.setState(customer.getState());
//        cvm.setZip(customer.getZip());
//        cvm.setLevel(customer.getLevel());
//        return cvm;
//    }