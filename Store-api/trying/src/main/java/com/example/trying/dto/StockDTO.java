package com.example.trying.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class StockDTO {
    private Long id;
    private int quantity;
    private Long productCode;
    private Long storeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}