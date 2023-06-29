package br.com.rickferry.basicmapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Order;
import br.com.rickferry.model.OrderAddress;
import br.com.rickferry.model.enums.OrderStatus;

public class EmbeddedObject extends EntityManagerTest {

    @Test
    public void embeddedObjectTest() {
        OrderAddress orderAdress = OrderAddress.builder().city("SP").complement("House").neighborhood("Itaquera")
                .number("999").publicPlace("Street").state("SP").zipCode("00000-000").build();

        Order order = Order.builder().orderDate(LocalDateTime.now()).status(OrderStatus.WAITING)
                .total(new BigDecimal(1000)).orderAddress(orderAdress).build();

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Order verify = entityManager.find(Order.class, order.getId());
        Assert.assertNotNull(verify.getOrderAddress());
    }
}
