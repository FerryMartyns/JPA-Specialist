package br.com.rickferry.starter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Product;

public class TrasactionOperation extends EntityManagerTest {

    /**
     *
     */
    private static final Integer VALUE = 5000;

    /**
     *
     */
    private static final Integer VALUE_1 = 5;

    /**
     *
     */
    private static final Integer VALUE_2 = 3;

    /**
     *
     */
    private static final Integer VALUE_3 = 3000;

    /**
     *
     */
    @Test
    public void findOne() {
        Product product = getEntityManager().find(Product.class, VALUE_1);

        var productVerify = getEntityManager()
                .find(Product.class, product.getId());

        assertNotNull(productVerify);
    }

    /**
     *
     */
    @Test
    public void updateObject() {
        Product product = getEntityManager().find(Product.class, VALUE_1);

        product.setName("Car");
        product.setPrice(new BigDecimal(VALUE));

        getEntityManager().getTransaction().begin();
        getEntityManager().merge(product);
        getEntityManager().getTransaction().commit();
        getEntityManager().clear();

        var productVerify = getEntityManager()
                .find(Product.class, product.getId());

        assertEquals("Car", productVerify.getName());
    }

    /**
     *
     */
    @Test
    @Ignore
    public void removeObject() {
        Product product = getEntityManager().find(Product.class, VALUE_2);

        getEntityManager().getTransaction().begin();
        getEntityManager().remove(product);
        getEntityManager().getTransaction().commit();

        Product productVerify = getEntityManager().find(Product.class, VALUE_2);
        assertNull(productVerify);
    }

    /**
     *
     */
    @Test
    public void insertObject() {
        Product product = Product.builder()
                .name("PS4")
                .description("Beautyfull!")
                .price(new BigDecimal(VALUE_3))
                .build();

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(product);
        getEntityManager().getTransaction().commit();
        getEntityManager().clear();

        Product verify = getEntityManager()
                .find(Product.class, product.getId());
        Assert.assertEquals("PS4", verify.getName());
        assertNotNull(verify);
    }
}
