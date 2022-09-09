package com.example.phoneverse.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class PurchaseProduct {
    @NotEmpty
    @Size(min = 3, message = "Item Name must be at least 3 characters")
    private String itemName;

    @NotEmpty
    @Pattern(regexp = "[0-9]+[ ][G][B]")
    private String storage;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotEmpty
    @Size(min = 3, message = "Customer Name must be at least 3 characters")
    private String customerName;

    @NotNull
    @Past
    private String tanggalLahir;

    @NotEmpty
    @Size(min = 3, message = "Outlet must be at least 3 characters")
    private String outlet;

    @NotEmpty
    @Size(min = 1, message = "Payment Method must be at least 1 characters")
    private String paymentMethod;
}
