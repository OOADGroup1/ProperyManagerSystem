package com.propertysys.test;

import com.propertysys.bean.EquipItemBean;
import com.propertysys.bean.ItemManagerBean;
import com.propertysys.bean.SpareItemBean;
import com.propertysys.operation.EquipItemOperator;
import com.propertysys.operation.EquipManageRecordOperator;
import com.propertysys.operation.SpareItemOperator;
import com.propertysys.operation.SpareManageRecordOperator;
import com.propertysys.user.ItemManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunny on 16/12/30.
 */
public class ItemManagerTest {
    private final int IDLE = 1;
    private final int OCCUPY = 0;
    private final int GARBAGE = 2;
    private ItemManager itemManager;
    private EquipItemOperator equipItemOperator;
    private EquipManageRecordOperator equipManageRecordOperator;
    private SpareItemOperator spareItemOperator;
    private SpareManageRecordOperator spareManageRecordOperator;
    @Before
    public void setUp() throws Exception {
        ItemManagerBean itemManagerBean= new ItemManagerBean();
        itemManagerBean.setManagerId(1);
        itemManager = new ItemManager(itemManagerBean);
        equipItemOperator = new EquipItemOperator();
        equipManageRecordOperator = new EquipManageRecordOperator();
        spareItemOperator = new SpareItemOperator();
        spareManageRecordOperator = new SpareManageRecordOperator();
    }

    @Test
    public void testBuyEquipItem(){
        EquipItemBean equipItem = new EquipItemBean();
        equipItem.setEquipId(1);
        equipItem.setEquipSeriesId(1);
        equipItem.setEquipStatus(IDLE);
        itemManager.buyEquipItem(equipItem);

        EquipItemBean e = equipItemOperator.queryById(3);
        Assert.assertEquals(equipItem, e);
    }

    @Test
    public void testBuyEquipItems(){
        List<EquipItemBean> list = new ArrayList<>();
        for(int i = 4; i <= 10; i++){
            EquipItemBean e = new EquipItemBean();
            e.setEquipId(1);
            e.setEquipSeriesId(i);
            e.setEquipStatus(IDLE);
            list.add(e);
        }
        for(int i = 11; i <= 15; i++){
            EquipItemBean e = new EquipItemBean();
            e.setEquipId(2);
            e.setEquipSeriesId(i);
            e.setEquipStatus(IDLE);
            list.add(e);
        }

        itemManager.buyEquipItems(list);
        String hql = "from EquipItemBean e where e.equipSeriesId > 3";
        List<EquipItemBean> testList = equipItemOperator.queryAll(hql);
        EquipItemBean[] el = new EquipItemBean[list.size()];
        list.toArray(el);

        EquipItemBean[] tl = new EquipItemBean[testList.size()];
        testList.toArray(tl);

        Assert.assertArrayEquals(el, tl);
    }

    @Test
    public void testBuySpareItem(){
        SpareItemBean spareItemBean = new SpareItemBean();
        spareItemBean.setSpareId(1);
        spareItemBean.setSpareSeriesId(1);
        spareItemBean.setSpareStatus(IDLE);

        itemManager.buySpareItem(spareItemBean);

        SpareItemBean s = spareItemOperator.queryById(1);

        Assert.assertEquals(spareItemBean, s);
    }

    @Test
    public void testBuySpareItems(){
        List<SpareItemBean> list = new ArrayList<>();
        for(int i = 2; i <= 10; i++){
            SpareItemBean s = new SpareItemBean();
            s.setSpareId(1);
            s.setSpareSeriesId(i);
            s.setSpareStatus(IDLE);
            list.add(s);
        }

        for(int i = 11; i <= 15; i++){
            SpareItemBean s = new SpareItemBean();
            s.setSpareId(2);
            s.setSpareSeriesId(i);
            s.setSpareStatus(IDLE);
            list.add(s);
        }

        itemManager.buySpareItems(list);
        String hql = "from SpareItemBean s where s.spareSeriesId > 1";
        List<SpareItemBean> testList = spareItemOperator.queryAll(hql);
        SpareItemBean[] el = new SpareItemBean[list.size()];
        list.toArray(el);

        SpareItemBean[] tl = new SpareItemBean[testList.size()];
        testList.toArray(tl);

        Assert.assertArrayEquals(el, tl);
    }

    @Test
    public void testDiscardEquipById(){

    }

}