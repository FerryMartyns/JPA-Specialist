package br.com.rickferry.starter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Client;
import br.com.rickferry.model.Product;

public class TrasactionOperation extends EntityManagerTest {

    @Test
    public void findOne() {
        Product product = entityManager.find(Product.class, 5);

        Product productVerify = entityManager.find(Product.class, product.getId());

        assertNotNull(productVerify);
    }

    @Test
    public void updateObject() {
        Product product = entityManager.find(Product.class, 5);

        product.setName("Car");
        product.setPrice(new BigDecimal(50000));

        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Product productVerify = entityManager.find(Product.class, product.getId());

        assertEquals("Car", productVerify.getName());
    }

    @Test
    public void removeObject() {
        Product product = entityManager.find(Product.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();

        Product productVerify = entityManager.find(Product.class, 3);
        assertNull(productVerify);
    }

    @Test
    public void insertObject() {
        Product product = Product.builder()
                .name("PS4")
                .description("Beautyfull!")
                .price(new BigDecimal(3000))
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Product verify = entityManager.find(Product.class, product.getId());
        Assert.assertEquals("PS4", verify.getName());
        assertNotNull(verify);
    }
}
