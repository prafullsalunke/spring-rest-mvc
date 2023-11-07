package prafull.springboot.spring6restmvc.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import prafull.springboot.spring6restmvc.model.Beer;
import prafull.springboot.spring6restmvc.model.Customer;
import prafull.springboot.spring6restmvc.services.CustomerService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers(){
        return customerService.listCustomers();
    }

    @RequestMapping(value ="{customerId}", method = RequestMethod.GET)
    public Customer getBeerByI(@PathVariable("customerId") UUID beerId){
        log.debug("Get Customer by Id - in controller");
        return customerService.getById(beerId);
    }
}
