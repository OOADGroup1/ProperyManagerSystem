package com.propertysys.test;

import com.propertysys.operation.EquipmentOperator;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

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
    public void insert() throws Exception {
        EquipmentBean equipmentBean = new EquipmentBean();
        equipmentBean.setCatlogId(1);
        equipmentBean.setCatlogType("equipment");
        equipmentBean.setEquipId(3);
        equipmentBean.setEquipDesc("Dell mouse");
        equipmentBean.setEquipPrice(300.0);
        equipmentOperator.insert(equipmentBean);
    }

    @Test
    public void delete() throws Exception {
        EquipmentBean equipmentBean = new EquipmentBean();
        equipmentBean.setCatlogId(1);
        equipmentBean.setCatlogType("equipment");
        equipmentBean.setEquipId(3);
        equipmentBean.setEquipDesc("Dell monitor");
        equipmentBean.setEquipPrice(2000.0);
        equipmentOperator.delete(equipmentBean);
    }

    @Test
    public void update() throws Exception {
        EquipmentBean equipmentBean = new EquipmentBean();
        equipmentBean.setCatlogId(1);
        equipmentBean.setCatlogType("equipment");
        equipmentBean.setEquipId(2);
        equipmentBean.setEquipDesc("Dell monitor");
        equipmentBean.setEquipPrice(2000.0);
        equipmentOperator.update(equipmentBean);
    }

    @Test
    public void queryAll() throws Exception {
        List<EquipmentBean> list = equipmentOperator.queryAll();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            EquipmentBean equipmentBean = (EquipmentBean) iter.next();
            System.out.println("id: " + equipmentBean.getEquipId() + " description: " +
            equipmentBean.getEquipDesc() + " price: " + equipmentBean.getEquipPrice());
        }

    }

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