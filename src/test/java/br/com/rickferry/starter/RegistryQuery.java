package br.com.rickferry.starter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Product;

public class RegistryQuery extends EntityManagerTest {

    @Test
    public void findById() {
        Product product = entityManager.find(Product.class, 1);

        assertNotNull(product);
        assertEquals("Kindle", product.getName());
    }

    @Test
    public void referenceUpdate() {
        Product product = entityManager.find(Product.class, 1);
        product.setName("Microfone Samson");

        entityManager.refresh(product);

        assertEquals("Kindle", product.getName());
    }
}
