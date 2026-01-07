package com.example.mini_P.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseNotesDto {
    private Long id;
    private String notes;
    private String description;
}
