package com.arrowsModule.productservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDetail {
    private String productId;
    private String category;

    private String group;
    private String comments;
}
