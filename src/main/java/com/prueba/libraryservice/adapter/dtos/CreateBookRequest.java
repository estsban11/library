package com.prueba.libraryservice.adapter.dtos;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateBookRequest {

    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "image is mandatory")
    private String image;
    @NotBlank(message = "Id Author is mandatory")
    private Long author_id;
    @NotBlank(message = "Id Publisher is mandatory")
    private Long publisher_id;

}
