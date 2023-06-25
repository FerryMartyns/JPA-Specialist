package br.com.rickferry.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.rickferry.model.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketPayment {
    
    @Id
    private Integer id;
    
    private Integer orderId;
    private PaymentStatus paymentStatus;
    private Integer barcode;
}
