package br.com.rickferry.model;

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
public class Stock {
    
    @Id
    private Integer id;
    
    private Integer productId;
    private Integer amount;
}
