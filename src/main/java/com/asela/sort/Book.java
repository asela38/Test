package com.asela.sort;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private String name;
    private String author;
    private Integer year;
    private String publisher;
    
}
