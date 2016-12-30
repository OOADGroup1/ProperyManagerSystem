package com.propertysys.test;

import com.propertysys.bean.SpareBean;
import com.propertysys.operation.SpareOperator;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sunny on 16/12/30.
 */
public class SpareOperatorTest {
    private SpareOperator spareOperator;
    @Before
    public void setUp() throws Exception {
        spareOperator = new SpareOperator();
    }

    @Test
    public void insert() throws Exception {
        SpareBean spareBean = new SpareBean();
        spareBean.setCatlogId(2);
        spareBean.setCatlogType("spare");
        spareBean.setSpareId(1);
        spareBean.setSpareDesc("CPU");
        spareBean.setSparePrice(2500.0);
        spareOperator.insert(spareBean);
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void queryById() throws Exception {

    }

    @Test
    public void queryAll() throws Exception {

    }

}