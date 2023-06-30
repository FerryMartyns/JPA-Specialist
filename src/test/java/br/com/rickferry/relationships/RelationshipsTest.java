package br.com.rickferry.relationships;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Category;
import br.com.rickferry.model.Client;
import br.com.rickferry.model.Order;
import br.com.rickferry.model.OrderedItem;
import br.com.rickferry.model.Product;
import br.com.rickferry.model.enums.OrderStatus;

public class RelationshipsTest extends EntityManagerTest {

        /**
         *
         */
        private static final Integer ID = 4;

        /**
         *
         */
        @Test
        @Ignore
        public void manyToOneTest() {
                Client client = getEntityManager().find(Client.class, ID);

                var order = Order.builder()
                                .status(OrderStatus.WAITING)
                                .orderDate(LocalDateTime.now())
                                .total(BigDecimal.TEN)
                                .client(client)
                                .build();

                getEntityManager().getTransaction().begin();
                getEntityManager().persist(order);
                getEntityManager().getTransaction().commit();
                getEntityManager().clear();

                Order verify = getEntityManager()
                                .find(Order.class, order.getId());
                Assert.assertNotNull(verify.getClient());
        }

        /**
         *
         */
        @Test
        @Ignore
        public void manyToOneOrderedItemTest() {
                Client client = getEntityManager().find(Client.class, ID);
                Product product = getEntityManager().find(Product.class, ID);

                var order = Order.builder()
                                .status(OrderStatus.WAITING)
                                .orderDate(LocalDateTime.now())
                                .total(BigDecimal.TEN)
                                .client(client)
                                .build();

                OrderedItem orderedItem = OrderedItem.builder()
                                .productPrice(product.getPrice())
                                .amount(1)
                                .order(order)
                                .product(product)
                                .build();

                getEntityManager().getTransaction().begin();
                getEntityManager().persist(order);
                getEntityManager().persist(orderedItem);
                getEntityManager().getTransaction().commit();
                getEntityManager().clear();

                OrderedItem verify = getEntityManager()
                                .find(OrderedItem.class, orderedItem.getId());
                Assert.assertNotNull(verify.getOrder());
                Assert.assertNotNull(verify.getProduct());
        }

        /**
         *
         */
        @Test
        @Ignore
        public void oneToManyTest() {
                Client client = getEntityManager().find(Client.class, ID);

                var order = Order.builder()
                                .status(OrderStatus.WAITING)
                                .orderDate(LocalDateTime.now())
                                .total(BigDecimal.TEN)
                                .client(client)
                                .build();

                getEntityManager().getTransaction().begin();
                getEntityManager().persist(order);
                getEntityManager().getTransaction().commit();
                getEntityManager().clear();

                Client verify = getEntityManager()
                                .find(Client.class, client.getId());
                Assert.assertFalse(verify.getOrders().isEmpty());
        }

        /**
         *
         */
        @Test
        public void autoRelationshipTest() {
                Category catPai = Category.builder().name("Eletronics").build();

                Category catFilha = Category.builder()
                                .name("Celular")
                                .categoryFather(catPai)
                                .build();

                getEntityManager().getTransaction().begin();
                getEntityManager().persist(catPai);
                getEntityManager().persist(catFilha);
                getEntityManager().getTransaction().commit();
                getEntityManager().clear();

                Category verify = getEntityManager()
                                .find(Category.class, catFilha.getId());
                Assert.assertNotNull(verify.getCategoryFather());
        }
}
