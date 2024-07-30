package com.prueba.libraryservice.adapter.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class CreateAuthorRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Lastname is mandatory")
    private String lastname;
}
