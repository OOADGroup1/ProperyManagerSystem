package com.propertysys.test;

import com.propertysys.user.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shenying on 16/12/30.
 */
public class ClientTest {

    private Client client;

    @Before
    public void setUp() throws Exception {
        client = new Client();
    }

    @Test
    public void viewAllEquips() throws Exception {

    }

    @Test
    public void viewAllSpares() throws Exception {

    }

    @Test
    public void viewAllRentEquipsByEmployeeId() throws Exception {
        client.viewAllRentEquipsByEmployeeId(0);
    }

    @Test
    public void viewAllRentSparesByEmployeeId() throws Exception {

    }

    @Test
    public void viewEquipLifeCycleById() throws Exception {
        client.viewEquipLifeCycleById(20160102);
    }

    @Test
    public void viewSpareLifeCycleById() throws Exception {

    }

    @Test
    public void viewEquipInstallRecoById() throws Exception {

    }
}