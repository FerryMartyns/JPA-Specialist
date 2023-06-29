package br.com.rickferry.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "`ORDER`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`ORDER_DATE`")
    private LocalDateTime orderDate;

    @Column(name = "`CONCLUSION_DATE`")
    private LocalDateTime conclusionDate;

    @Column(name = "`INVOICE_ID`")
    private Integer invoiceId;

    @Column(name = "`STATUS`")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "`TOTAL`")
    private BigDecimal total;

    @Embedded
    private OrderAddress orderAddress;
}
