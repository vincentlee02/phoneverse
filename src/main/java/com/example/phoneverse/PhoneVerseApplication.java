package com.example.phoneverse;

import com.example.phoneverse.product.Product;
import com.example.phoneverse.product.ProductRepository;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class PhoneVerseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneVerseApplication.class, args);
    }
}
