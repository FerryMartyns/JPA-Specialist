package br.com.rickferry.basicmapping;

import org.junit.Assert;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Category;

public class PrimaryKeyStrategyTest extends EntityManagerTest{
    
    @Test
    public void keyStrategyTest(){
        Category category = Category.builder().name("").name("").categoryFatherId(1).build();

        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Category verify = entityManager.find(Category.class, category.getId());
        Assert.assertNotNull(verify);
    }
}
