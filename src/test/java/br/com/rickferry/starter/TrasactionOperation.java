package br.com.rickferry.starter;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Product;

public class TrasactionOperation extends EntityManagerTest {

    @Test
    public void removeObject() {
        Product product = entityManager.find(Product.class, 1);
        
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();

        Product productVerify = entityManager.find(Product.class, 1);
        Assert.assertNull(productVerify);
    }

    @Test
    public void insertObject() {
        Product product = Product.builder()
                .id(2)
                .name("PS5")
                .description("Lindo!")
                .price(new BigDecimal(5000)).build();

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Product productVerify = entityManager.find(Product.class, product.getId());
        Assert.assertEquals("PS5", productVerify.getName());
        assertNotNull(productVerify);
    }
}
