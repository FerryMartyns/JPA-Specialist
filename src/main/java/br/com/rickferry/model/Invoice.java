package br.com.rickferry.model;

import java.util.Date;

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
public class Invoice {
    
    @Id
    private Integer id;
    
    private Integer orderId;
    private String xml;
    private Date emissionDate;
}
