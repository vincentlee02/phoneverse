package com.example.phoneverse.product;

import com.example.phoneverse.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product insertProduct(Product product){
        String SKU = randomStringGenerator();
        product.setSku(SKU);
        product.setBuyDate(LocalDate.now());
        product.setStatus("On Check");
        product.setStorage(product.getStorage() + " GB");
        productRepository.save(product);
        return product;
    }

    public void updateStatus(String sku, String status){
        Product updateProduct = productRepository.findById(sku)
                .orElseThrow(()->new ProductNotFoundException("Product Not Found with SKU: " + sku));
        if((!status.equals("On Check")&&!status.equals("Ready"))||status.equals("Sold")){
            throw(new ProductNotFoundException("Only 'On Check' and 'Ready' input allowed!"));
        }
        updateProduct.setStatus(status);
        productRepository.save(updateProduct);
    }

    public long checkProduct(String itemName, String storage, Integer quantity){
        long productCount = productRepository.getProductCount(itemName, storage);
        if(productCount >= quantity){
            return quantity;
        }else {
            return 0;
        }
    }

    public void updateProduct(String itemName, String storage, Integer quantity){
        List<Product> productsList = productRepository.getSearchedProducts(itemName, storage);
        int count = 0;
        for (Product product:productsList) {
            product.setStatus("Sold");
            product.setSellDate(LocalDate.now());
            productRepository.save(product);
            count++;
            if(count >= quantity)break;
        }
    }

    public boolean checkUnique(String sku){
        Optional<Product> productFound= productRepository.findById(sku);
        if(productFound.isPresent()){
            return false;
        }else {
            return true;
        }
    }

    public String randomStringGenerator(){
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        int n = 16;
        StringBuilder sb;
        while (true){
            sb = new StringBuilder(n);
            for (int i = 0; i < n; i++){
                int index = (int)(alphanumeric.length() * Math.random());
                sb.append(alphanumeric.charAt(index));
            }
            boolean unique = checkUnique(sb.toString());
            if(unique) {
                break;
            }
        }
        return sb.toString();
    }

    public Product get(String sku){
        Optional<Product> findProduct = productRepository.findById(sku);
        return findProduct.get();
    }

    public void deleteProduct(String sku){
        Optional<Product> product = productRepository.findById(sku);
        Product productFound = new Product();
        if(product.isPresent()){
            productFound = product.get();
            productRepository.delete(productFound);
        }
    }
}
