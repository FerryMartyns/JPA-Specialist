package br.com.rickferry.basicmapping;

import static java.lang.String.valueOf;

import org.junit.Assert;
import org.junit.Test;

import br.com.rickferry.EntityManagerTest;
import br.com.rickferry.model.Client;
import br.com.rickferry.model.enums.ClientSex;

public class EnumMapping extends EntityManagerTest {

    /**
     *
     */
    @Test
    public void enumTest() {
        Client client = Client.builder()
                                .name("Adryen")
                                .sex(ClientSex.MASCULINE)
                                .build();

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(client);
        getEntityManager().getTransaction().commit();
        getEntityManager().clear();

        Client verify = getEntityManager().find(Client.class, client.getId());
        Assert.assertEquals("MASCULINE", valueOf(verify.getSex()));
    }
}
