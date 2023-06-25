package br.com.rickferry.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.rickferry.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
    @Id
    private Integer id;
    
    private LocalDateTime orderDate;
    private LocalDateTime conclusionDate;
    private Integer invoiceId;
    private OrderStatus status;
    private BigDecimal total;
}
