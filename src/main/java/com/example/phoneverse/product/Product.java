package com.example.phoneverse.product;

import lombok.*;
import org.hibernate.id.GUIDGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    private String sku;

    @Column(name = "item_name")
    @NotEmpty
    @Size(min = 3, message = "Item Name must be at least 3 characters")
    private String itemName;

    @Column(name = "storage")
    @NotEmpty
    @Pattern(regexp = "[0-9]+[ ][G][B]")
    private String storage;

    @Column(name = "harga")
    @NotNull
    private Integer harga;

    @Column(name = "buy_date")
    private LocalDate buyDate;

    @Column(name = "sell_date")
    private LocalDate sellDate;

    @Column(name = "status")
    private String status;

}
