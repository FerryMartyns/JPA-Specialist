package br.com.rickferry.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rickferry.model.Product;

public class StarterUnitPersistence {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = factory.createEntityManager();

        Product product = entityManager.find(Product.class, 1);
        System.out.println(product);

        factory.close();
        entityManager.close();
    }
}
