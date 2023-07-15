package br.com.rickferry.relationships;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.CardPayment;
import br.com.rickferry.model.Category;
import br.com.rickferry.model.Client;
import br.com.rickferry.model.Order;
import br.com.rickferry.model.OrderedItem;
import br.com.rickferry.model.Product;
import br.com.rickferry.model.enums.OrderStatus;
import br.com.rickferry.model.enums.PaymentStatus;

public class RelationshipsTest extends EntityManagerTest {

        /**
         *
         */
        private static final int CARD_NUMBER = 1234;
        /**
         *
         */
        private static final Integer ID = 1;

        /**
         *
         */
        @Test
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
                assertNotNull(verify.getClient());
        }

        /**
         *
         */
        @Test
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
                assertFalse(verify.getOrders().isEmpty());
        }

        /**
         *
         */
        @Test
        public void autoRelationshipTest() {
                Category catPai = Category.builder().name("Eletronics").build();

                Category catFilha = Category.builder()
                                .name("Cell Phone")
                                .parentCategory(catPai)
                                .build();

                getEntityManager().getTransaction().begin();
                getEntityManager().persist(catPai);
                getEntityManager().persist(catFilha);
                getEntityManager().getTransaction().commit();
                getEntityManager().clear();

                Category verify = getEntityManager()
                                .find(Category.class, catFilha.getId());
                assertNotNull(verify.getParentCategory());
        }

        /**
         *
         */
        @Test
        public void manyToManyRelationshipTest() {
                Category category = getEntityManager().find(Category.class, 1);
                Product product = getEntityManager().find(Product.class, 1);

                getEntityManager().getTransaction().begin();
                product.setCategories(Arrays.asList(category));
                getEntityManager().getTransaction().commit();
                getEntityManager().clear();

                Category verify = getEntityManager()
                                .find(Category.class, category.getId());
                assertFalse(verify.getProducts().isEmpty());
        }

        /**
         *
         */
        @Test
        public void oneToOneRelationshipTest() {
                Order order = getEntityManager().find(Order.class, 1);
                CardPayment cardPayment = CardPayment.builder()
                                .number(CARD_NUMBER)
                                .paymentStatus(PaymentStatus.PROCESSED)
                                .order(order).build();

                getEntityManager().getTransaction().begin();
                getEntityManager().persist(cardPayment);
                getEntityManager().getTransaction().commit();
                getEntityManager().clear();

                Order verify = getEntityManager()
                                .find(Order.class, order.getId());
                assertNotNull(verify.getCardPayment());
        }
}
