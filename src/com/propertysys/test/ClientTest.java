package com.propertysys.test;

import com.propertysys.user.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void testViewAllEquips() throws Exception {
        List equipInfo = client.viewAllEquips();
        Assert.assertEquals(15, equipInfo.size());
    }

    @Test
    public void testViewAllEquipsByKey() throws Exception {
        String testKey = "monitor";
        List equipInfo = client.viewAllEquips(testKey);
        Assert.assertEquals(10, equipInfo.size());
    }

    @Test
    public void testViewAllSpares() throws Exception {
        List spareInfo = client.viewAllSpares();
        Assert.assertEquals(15, spareInfo.size());
    }

    @Test
    public void testViewAllSparesByKey() throws Exception {
        String testKey = "CPU";
        List spareInfo = client.viewAllSpares(testKey);
        Assert.assertEquals(10, spareInfo.size());
    }

    @Test
    public void testViewAllRentEquipsByEmployeeId() throws Exception {
        // 这个方法的实现没办法直接使用assert做测试，需要进行人工比较。
        client.viewAllRentEquipsByEmployeeId(1);
    }

    @Test
    public void testViewAllRentSparesByEmployeeId() throws Exception {
        // 这个方法的实现没办法直接使用assert做测试，需要进行人工比较。
        client.viewAllRentSparesByEmployeeId(1);
    }

    @Test
    public void testViewEquipLifeCycleById() throws Exception {
        int count = client.viewEquipLifeCycleById(1);
        Assert.assertEquals(2, count);
    }

    @Test
    public void testViewSpareLifeCycleById() throws Exception {
        int count = client.viewSpareLifeCycleById(1);
        Assert.assertEquals(2, count);
    }

    @Test
    public void testViewEquipInstallRecoById() throws Exception {
        List list = client.viewEquipInstallRecoById(2);
        Assert.assertEquals(1, list.size());
    }
}