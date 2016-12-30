package com.propertysys.test;

import com.propertysys.operation.EquipItemOperator;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Sunny on 16/12/30.
 */
public class EquipItemOperatorTest {
    private final int IDLE = 1;
    private final int OCCUPY = 0;
    private EquipItemOperator equipItemOperator;
    @Before
    public void setUp() throws Exception {
        equipItemOperator = new EquipItemOperator();
    }

    @Test
    public void insert() throws Exception {
        EquipItemBean equipItemBean = new EquipItemBean();
        equipItemBean.setEquipSeriesId(3);
        equipItemBean.setEquipStatus(IDLE);
        equipItemBean.setEquipId(1);
        equipItemBean.setCatlogId(1);
        equipItemOperator.insert(equipItemBean);
    }

    @Test
    public void delete() throws Exception {
        EquipItemBean equipItemBean = new EquipItemBean();
        equipItemBean.setEquipSeriesId(3);
        equipItemBean.setEquipStatus(IDLE);
        equipItemBean.setEquipId(1);
        equipItemBean.setCatlogId(1);
        equipItemOperator.delete(equipItemBean);
    }

    @Test
    public void update() throws Exception {
        EquipItemBean equipItemBean = new EquipItemBean();
        equipItemBean.setEquipSeriesId(2);
        equipItemBean.setEquipStatus(OCCUPY);
        equipItemBean.setEquipId(1);
        equipItemBean.setCatlogId(1);
        equipItemOperator.update(equipItemBean);
    }

    @Test
    public void queryById() throws Exception {
        EquipItemBean equipItemBean = equipItemOperator.queryById(1);
        System.out.println(equipItemBean.getEquipStatus());
    }

    @Test
    public void queryAll() throws Exception {
        List<EquipItemBean> list = equipItemOperator.queryAll();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            EquipItemBean equipItemBean = (EquipItemBean) iter.next();
            System.out.println("id: " + equipItemBean.getEquipSeriesId() +
                    " status: " + equipItemBean.getEquipStatus());
        }
    }

    @Test
    public void getAllEquipInfo() throws Exception {
        List equipInfo = equipItemOperator.getAllEquipInfo();
        for(Iterator iter = equipInfo.iterator(); iter.hasNext();){
            Object equip = iter.next();
            System.out.print(equip.toString());
//            System.out.println("equipId=" + equip. +
//                    " CatlogType=" + equipInfo.get(1) +
//                    " desc=" + equipInfo.get(2) +
//                    " price=" + equipInfo.get(3));
        }

    }
}