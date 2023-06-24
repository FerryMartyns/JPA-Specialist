package br.com.rickferry.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    @Id
    private Integer id;
    
    @Column(name = "`NAME`")
    private String name;

    @Column(name = "`DESCRIPTION`")
    private String description;

    private BigDecimal price;
}
