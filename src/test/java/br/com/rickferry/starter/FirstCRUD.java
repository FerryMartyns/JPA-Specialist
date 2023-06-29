package br.com.rickferry.starter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Client;
import br.com.rickferry.model.enums.ClientSex;

public class FirstCRUD extends EntityManagerTest {

    @Test
    public void findOne() {
        Client client = entityManager.find(Client.class, 1);

        Client clientVerify = entityManager.find(Client.class, client.getId());

        assertNotNull(clientVerify);
    }

    @Test
    public void updateObject() {
        Client client = entityManager.find(Client.class, 2);

        client.setName("Jimy");

        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Client clientVerify = entityManager.find(Client.class, client.getId());

        assertEquals("Jimy", clientVerify.getName());
    }

    @Test
    public void removeObject() {
        Client client = entityManager.find(Client.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();

        Client clientVerify = entityManager.find(Client.class, 2);
        assertNull(clientVerify);
    }

    @Test
    public void insertObject() {
        Client client = Client.builder()
                .name("Kalel")
                .sex(ClientSex.MASCULINE)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Client clientVerify = entityManager.find(Client.class, client.getId());
        Assert.assertEquals("Kalel", clientVerify.getName());
        assertNotNull(clientVerify);
    }
}
