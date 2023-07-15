package br.com.rickferry.basicmapping;

import org.junit.Assert;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Category;

public class PrimaryKeyStrategyTest extends EntityManagerTest {

    /**
     *
     */
    @Test
    public void keyStrategyTest() {
        var category = Category.builder()
                .name("")
                .parentCategory(null)
                .build();

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(category);
        getEntityManager().getTransaction().commit();
        getEntityManager().clear();

        Category verify = getEntityManager()
                .find(Category.class, category.getId());
        Assert.assertNotNull(verify);
    }
}
