package com.example.mini_P.Dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class AddNotesDto {

    private String notes;
    private String description;
}
