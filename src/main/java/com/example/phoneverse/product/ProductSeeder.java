package com.example.phoneverse.product;

import com.example.phoneverse.product.Product;
import com.example.phoneverse.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired ProductRepository productRepository;
    @Autowired ProductService productService;

    @Override
    public void run(String... args) throws Exception {
//        String SKU;
//        Product product1 = new Product();
//        SKU = randomStringGenerator();
//        product1.setSku(SKU);
//        product1.setItemName("Huawei P30");
//        product1.setStorage("128 GB");
//        product1.setHarga(7690000);
//        product1.setBuyDate(LocalDate.now());
//        product1.setStatus("Ready");
//        productRepository.save(product1);
//
//        Product product2 = new Product();
//        SKU = randomStringGenerator();
//        product2.setSku(SKU);
//        product2.setItemName("Iphone XR");
//        product2.setStorage("128 GB");
//        product2.setHarga(5990000);
//        product2.setBuyDate(LocalDate.now());
//        product2.setStatus("Ready");
//        productRepository.save(product2);
//
//        Product product3 = new Product();
//        SKU = randomStringGenerator();
//        product3.setSku(SKU);
//        product3.setItemName("Redmi 11");
//        product3.setStorage("128 GB");
//        product3.setHarga(3450000);
//        product3.setBuyDate(LocalDate.now());
//        product3.setStatus("Ready");
//        productRepository.save(product3);
//
//        Product product4 = new Product();
//        SKU = randomStringGenerator();
//        product4.setSku(SKU);
//        product4.setItemName("Iphone XR");
//        product4.setStorage("256 GB");
//        product4.setHarga(6990000);
//        product4.setBuyDate(LocalDate.now());
//        product4.setStatus("Sold");
//        productRepository.save(product4);
//
//        Product product5 = new Product();
//        SKU = randomStringGenerator();
//        product5.setSku(SKU);
//        product5.setItemName("Iphone XR");
//        product5.setStorage("256 GB");
//        product5.setHarga(6990000);
//        product5.setBuyDate(LocalDate.now());
//        product5.setStatus("Sold");
//        productRepository.save(product5);
    }

//    public String randomStringGenerator(){
//        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
//        int n = 16;
//        StringBuilder sb;
//        while (true){
//            sb = new StringBuilder(n);
//            for (int i = 0; i < n; i++){
//                int index = (int)(alphanumeric.length() * Math.random());
//                sb.append(alphanumeric.charAt(index));
//            }
//            boolean unique = checkUnique(sb.toString());
//            if(unique) {
//                break;
//            }
//        }
//        return sb.toString();
//    }
//
//    public boolean checkUnique(String sku){
//        boolean unique = productService.checkUnique(sku);
//        return unique;
//    }

}

