package br.com.rickferry.util;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rickferry.model.Product;

public class StarterUnitPersistence {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = factory.createEntityManager();

        Product product = Product.builder().name("Camisa").description("Poliester").price(new BigDecimal(199.00)).build();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        factory.close();
        entityManager.close();
    }
}
