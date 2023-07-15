package br.com.rickferry.basicmapping;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Client;
import br.com.rickferry.model.Order;
import br.com.rickferry.model.OrderAddress;
import br.com.rickferry.model.enums.OrderStatus;

public class EmbeddedObject extends EntityManagerTest {

    /**
     *
     */
    private static final Integer VALUE = 1000;

    /**
     *
     */
    @Test
    public void embeddedObjectTest() {
        Client client = getEntityManager().find(Client.class, 1);
        var orderAdress = OrderAddress.builder()
                .city("SP")
                .complement("House")
                .neighborhood("Itaquera")
                .number("999")
                .publicPlace("Street")
                .state("SP")
                .zipCode("00000-000")
                .build();

        var order = Order.builder()
                .orderDate(LocalDateTime.now())
                .status(OrderStatus.WAITING)
                .total(new BigDecimal(VALUE))
                .client(client)
                .orderAddress(orderAdress)
                .build();

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(order);
        getEntityManager().getTransaction().commit();
        getEntityManager().clear();

        Order verify = getEntityManager().find(Order.class, order.getId());
        assertNotNull(verify.getOrderAddress());
    }
}
