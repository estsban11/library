package com.prueba.libraryservice.adapter.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookRequest {

    private Long id;
    private String title;
    private Long author_id;
    private Long publisher_id;


}
