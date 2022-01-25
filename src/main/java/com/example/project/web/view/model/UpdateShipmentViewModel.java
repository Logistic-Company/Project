package com.example.project.web.view.model;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.Clients;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateShipmentViewModel {
    @NotBlank(message = "Sender name cannot be blank!")
    @Size(min = 2, max = 20, message="Min length: 2, max length: 20")
    @Pattern(regexp = "^([A-Z]).*", message = "Sender has to start with capital letter!")
    private Clients sender;

    @NotBlank(message = "Receiver name cannot be blank!")
    @Size(min = 2, max = 20, message="Min length: 2, max length: 20")
    @Pattern(regexp = "^([A-Z]).*", message = "Receiver has to start with capital letter!")
    private Clients receiver;

    @NotBlank(message = "Address name cannot be blank!")
    @Size(min = 2, max = 20, message="Min length: 2, max length: 20")
    @Pattern(regexp = "^([A-Z]).*", message = "Address has to start with capital letter!")
    private Address address;

    @Positive
    @NotNull
    @Min(value = 0L, message = "The value must be positive")
    private double weight;
}
