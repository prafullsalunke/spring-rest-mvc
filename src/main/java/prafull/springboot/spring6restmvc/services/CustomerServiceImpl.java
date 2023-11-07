package prafull.springboot.spring6restmvc.services;

import org.springframework.stereotype.Service;
import prafull.springboot.spring6restmvc.model.Customer;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl(){
        this.customerMap = new HashMap<>();
        Customer cust1 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Philip")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer cust2 = Customer.builder()
                .id(UUID.randomUUID())
                .version(2)
                .customerName("Norman")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer cust3 = Customer.builder()
                .id(UUID.randomUUID())
                .version(3)
                .customerName("Prafull")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        customerMap.put(cust1.getId(), cust1);
        customerMap.put(cust2.getId(), cust2);
        customerMap.put(cust3.getId(), cust3);
    }

    @Override
    public List<Customer> listCustomers(){
        return new ArrayList<>(customerMap.values());
    }
    @Override
    public Customer getById(UUID id) {
        return customerMap.get(id);
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .version(customer.getVersion())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        customerMap.put(savedCustomer.getId(),savedCustomer);
        return savedCustomer;
    }

    @Override
    public void updateCustomerById(UUID customerId, Customer customer) {
        Customer existing = customerMap.get(customerId);
        existing.setCustomerName(customer.getCustomerName());
        existing.setVersion(customer.getVersion());
        existing.setLastModifiedDate(LocalDateTime.now());
        customerMap.put(existing.getId(), existing);
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customerMap.remove(customerId);
    }
}
