package com.example.phoneverse.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerService {

    @Autowired CustomerRepository customerRepository;
    public void addCustomer(String customerName, String outlet, String paymentMethod, LocalDate tanggalLahir){
        Customer cust = new Customer();
        cust.setCustomerName(customerName);
        cust.setOutlet(outlet);
        cust.setPaymentMethod(paymentMethod);
        cust.setTanggalLahir(tanggalLahir);
        customerRepository.save(cust);
    }
}
