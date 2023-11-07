package prafull.springboot.spring6restmvc.services;

import prafull.springboot.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> listCustomers();

    Customer getById(UUID id);
}