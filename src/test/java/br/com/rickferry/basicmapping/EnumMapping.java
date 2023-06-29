package br.com.rickferry.basicmapping;

import static java.lang.String.valueOf;

import org.junit.Assert;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Client;
import br.com.rickferry.model.enums.ClientSex;

public class EnumMapping extends EntityManagerTest {

    @Test
    public void enumTest() {
        Client client = Client.builder()
                                .name("Adryen")
                                .sex(ClientSex.MASCULINE)
                                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Client verify = entityManager.find(Client.class, client.getId());
        Assert.assertEquals("MASCULINE", valueOf(verify.getSex()));
    }
}
