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

    /**
     *
     */
    private static final Integer VALUE = 1;

    /**
     *
     */
    //@Test
    public void findOne() {
        Client client = getEntityManager().find(Client.class, VALUE);

        Client clientVerify = getEntityManager()
                .find(Client.class, client.getId());

        assertNotNull(clientVerify);
    }

    /**
     *
     */
    //@Test
    public void updateObject() {
        Client client = getEntityManager().find(Client.class, VALUE);

        client.setName("Jimy");

        getEntityManager().getTransaction().begin();
        getEntityManager().merge(client);
        getEntityManager().getTransaction().commit();
        getEntityManager().clear();

        Client clientVerify = getEntityManager()
                .find(Client.class, client.getId());

        assertEquals("Jimy", clientVerify.getName());
    }

    /**
     *
     */
    //@Test
    public void removeObject() {
        Client client = getEntityManager().find(Client.class, VALUE);

        getEntityManager().getTransaction().begin();
        getEntityManager().remove(client);
        getEntityManager().getTransaction().commit();
        getEntityManager().clear();

        Client clientVerify = getEntityManager()
                .find(Client.class, client.getId());
        assertNull(clientVerify);
    }

    /**
     *
     */
    @Test
    public void insertObject() {
        Client client = Client.builder()
                .name("Kalel")
                .sex(ClientSex.MASCULINE)
                .build();

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(client);
        getEntityManager().getTransaction().commit();
        getEntityManager().clear();

        Client clientVerify = getEntityManager()
                .find(Client.class, client.getId());
        Assert.assertEquals("Kalel", clientVerify.getName());
        assertNotNull(clientVerify);
    }
}
