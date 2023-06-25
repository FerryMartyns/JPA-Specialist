package br.com.rickferry.model;

import java.math.BigDecimal;

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
public class OrderedItem {
    
    @Id
    private Integer id;
    
    private Integer orderId;
    private Integer productId;
    private BigDecimal productPrice;
    private Integer amount;
}
