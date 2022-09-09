package com.example.phoneverse.product;

import com.example.phoneverse.customer.Customer;
import com.example.phoneverse.customer.CustomerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String getAllProducts(Model model){
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("listProducts", listProducts);
        return "products";
    }

    @GetMapping("/new")
    public String showAddForm(Model model){
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping("/save")
    public String insertProduct(Product product, RedirectAttributes ra){
        productService.insertProduct(product);
        ra.addFlashAttribute("message", "Product has been added successfully!");
        return "redirect:/products";
    }

    @GetMapping("/edit/{sku}")
    public String showEditForm(@PathVariable("sku") String sku, Model model){
        Product product = productService.get(sku);
        model.addAttribute("product", product);
        return "edit_form";
    }

    @PostMapping("/save-status")
    public String saveStatus(Product product, RedirectAttributes ra){
        try{
            productService.updateStatus(product.getSku(), product.getStatus());
        }catch(Exception e){
            ra.addFlashAttribute("message", "Invalid Status!");
            return "redirect:/products";
        }
        ra.addFlashAttribute("message", "Status has been updated successfully!");
        return "redirect:/products";
    }

//    @PutMapping(value = "{id}")
//    public ResponseEntity<Product> updateStatus(@PathVariable String id, @RequestBody RequestBodyStatus status){
//        Product updateProduct = productService.updateStatus(id, status.getStatus());
//        return ResponseEntity.ok(updateProduct);
//    }

    @GetMapping("/buy")
    public String showBuyForm(Model model){
        model.addAttribute("purchaseProduct", new PurchaseProduct());
        return "buy_product";
    }

    @PostMapping("/buy-product")
    public String purchaseProduct(PurchaseProduct purchaseProduct, RedirectAttributes ra){
        System.out.println("test");
        long productCount = productService.checkProduct(purchaseProduct.getItemName(), purchaseProduct.getStorage(), purchaseProduct.getQuantity());
        if(productCount == 0){
            ra.addFlashAttribute("message", "No Stock Available");
            return "redirect:/products";
        }
        Customer customer = new Customer();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = purchaseProduct.getTanggalLahir();
        LocalDate localDate = LocalDate.parse(date, formatter);
        customerService.addCustomer(purchaseProduct.getCustomerName(), purchaseProduct.getOutlet(), purchaseProduct.getPaymentMethod(), localDate);
        productService.updateProduct(purchaseProduct.getItemName(), purchaseProduct.getStorage(), purchaseProduct.getQuantity());
        ra.addFlashAttribute("message", "Purchase Successful!");
        return "redirect:/products";
    }

    @GetMapping("/delete/{sku}")
    public String deleteProduct(@PathVariable("sku") String sku, RedirectAttributes ra){
        productService.deleteProduct(sku);
        ra.addFlashAttribute("message", "Product Deleted Successfully!");
        return "redirect:/products";
    }

//    @GetMapping("/buy")
//    public ResponseEntity<String> purchaseProduct(@Valid @RequestBody PurchaseProduct purchase){
//        long productCount = productService.checkProduct(purchase.getItemName(), purchase.getStorage(), purchase.getQuantity());
//        if(productCount == 0){
//            throw(new ProductNotFoundException("Product Not Found!"));
//        }
//        Customer customer = new Customer();
//        if(productCount > 0){
//            customerService.addCustomer(purchase.getCustomerName(), purchase.getOutlet(), purchase.getPaymentMethod(), purchase.getTanggalLahir());
//            productService.updateProduct(purchase.getItemName(), purchase.getStorage(), purchase.getQuantity());
//        }
//        return ResponseEntity.ok("Purchase Successful");
//    }

}
