package br.com.rickferry.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ordered_item")
public class OrderedItem {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     *
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    /**
     *
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     *
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     *
     */
    private Integer amount;
}
