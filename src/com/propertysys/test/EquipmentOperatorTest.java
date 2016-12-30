package com.propertysys.test;

import com.propertysys.bean.EmployeeBean;
import com.propertysys.bean.EquipmentBean;
import com.propertysys.bean.EquipmentBeanPK;
import com.propertysys.operation.EquipmentOperator;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shenying on 16/12/30.
 */
public class EquipmentOperatorTest {

    private EquipmentOperator equipmentOperator;

    @Before
    public void setUp() throws Exception {
        equipmentOperator = new EquipmentOperator();
    }

    @Test
    public void queryByPK() throws Exception {
        EquipmentBeanPK pk = new EquipmentBeanPK();
        pk.setCatlogId(0);
        pk.setEquipId(1);
        EquipmentBean equipmentBean = equipmentOperator.queryByPK(pk);
        System.out.println("equipId=" + equipmentBean.getEquipId() +
                " catlogId=" + equipmentBean.getCatlogId() +
                " CatlogType=" + equipmentBean.getCatlogType() +
                " desc=" + equipmentBean.getEquipDesc() +
                " price=" + equipmentBean.getEquipPrice());
    }

    @Test
    public void deleteByPK() throws Exception {
        EquipmentBeanPK pk = new EquipmentBeanPK();
        pk.setCatlogId(0);
        pk.setEquipId(1);
        equipmentOperator.deleteByPK(pk);
    }
}