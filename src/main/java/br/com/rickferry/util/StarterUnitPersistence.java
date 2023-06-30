package br.com.rickferry.util;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.rickferry.model.Product;

public class StarterUnitPersistence {

    /**
     *
     */
    private static final Integer VALUE = 199;

    /**
     * @param args
     */
    public static void main(final String[] args) {
        var factory = Persistence.createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = factory.createEntityManager();

        final var product = Product.builder()
                .name("Camisa")
                .description("Poliester")
                .price(BigDecimal.valueOf(VALUE))
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        factory.close();
        entityManager.close();
    }

    @Override
    public final String toString() {
        return "StarterUnitPersistence []";
    }
}
