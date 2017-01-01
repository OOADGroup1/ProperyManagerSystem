package com.propertysys.test;

import com.propertysys.bean.EquipmentBean;
import com.propertysys.operation.EquipmentOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
    public void test001Insert() throws Exception {
        EquipmentBean equipmentBean = new EquipmentBean();
        equipmentBean.setCatlogId(1);
        equipmentBean.setCatlogType("equipment");
        equipmentBean.setEquipId(4);
        equipmentBean.setEquipDesc("Dell mainframe");
        equipmentBean.setEquipPrice(3000.0);
        equipmentOperator.insert(equipmentBean);
        //顺便测试queryById
        EquipmentBean equipmentBean1 = equipmentOperator.queryById(4);
        Assert.assertEquals(equipmentBean, equipmentBean1);

    }

    @Test
    public void test002InsertAll() throws Exception {
        List<EquipmentBean> list = new ArrayList<>();
        for(int i = 5; i < 11; i++){
            EquipmentBean equipmentBean = new EquipmentBean();
            equipmentBean.setCatlogId(1);
            equipmentBean.setCatlogType("equipment");
            equipmentBean.setEquipId(i);
            equipmentBean.setEquipDesc("Description" + i);
            equipmentBean.setEquipPrice(i * 1000.0);
            list.add(equipmentBean);
        }
        equipmentOperator.insertAll(list);
        //顺便测试queryByHql
        String hql = "from EquipmentBean e where e.equipId > 4";
        List list1 = equipmentOperator.queryAll(hql);
        Assert.assertEquals(6, list1.size());
    }

    @Test
    public void test003Delete() throws Exception {
        EquipmentBean equipmentBean = new EquipmentBean();
        equipmentBean.setCatlogId(1);
        equipmentBean.setCatlogType("equipment");
        equipmentBean.setEquipId(4);
        equipmentBean.setEquipDesc("Dell mainframe");
        equipmentBean.setEquipPrice(3000.0);
        equipmentOperator.delete(equipmentBean);
        EquipmentBean equipmentBean1 = equipmentOperator.queryById(4);
        Assert.assertEquals(null, equipmentBean1);
    }

    @Test
    public void test004DeleteById() throws Exception {
        equipmentOperator.delete(3);
        EquipmentBean equipmentBean = equipmentOperator.queryById(3);
        Assert.assertEquals(null, equipmentBean);
    }

    @Test
    public void test005Update() throws Exception {
        EquipmentBean equipmentBean = new EquipmentBean();
        equipmentBean.setCatlogId(1);
        equipmentBean.setCatlogType("equipment");
        equipmentBean.setEquipId(1);
        equipmentBean.setEquipDesc("Dell monitor");
        equipmentBean.setEquipPrice(1000.0);
        equipmentOperator.update(equipmentBean);
        EquipmentBean equipmentBean1 = equipmentOperator.queryById(1);
        Assert.assertEquals(equipmentBean, equipmentBean1);
    }

    @Test
    public void test006QueryAll() throws Exception {
        List<EquipmentBean> list = equipmentOperator.queryAll();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            EquipmentBean equipmentBean = (EquipmentBean) iter.next();
            System.out.println("id: " + equipmentBean.getEquipId() + " description: " +
            equipmentBean.getEquipDesc() + " price: " + equipmentBean.getEquipPrice());
        }
        Assert.assertEquals(8, list.size());
    }



}