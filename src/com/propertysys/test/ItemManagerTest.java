package com.propertysys.test;

import com.propertysys.bean.EquipItemBean;
import com.propertysys.bean.ItemManagerBean;
import com.propertysys.bean.SpareItemBean;
import com.propertysys.operation.EquipItemOperator;
import com.propertysys.operation.SpareItemOperator;
import com.propertysys.user.ItemManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunny on 16/12/30.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemManagerTest {
    private final int IDLE = 0;
    private final int OCCUPY = 1;
    private final int GARBAGE = 2;
    private ItemManager itemManager;
    private EquipItemOperator equipItemOperator;
    private SpareItemOperator spareItemOperator;
    @Before
    public void setUp() throws Exception {
        ItemManagerBean itemManagerBean= new ItemManagerBean();
        itemManagerBean.setManagerId(1);
        itemManager = new ItemManager(itemManagerBean);
        equipItemOperator = new EquipItemOperator();
        spareItemOperator = new SpareItemOperator();
    }

    @Test
    public void test001BuyEquipItem(){
        EquipItemBean equipItem = new EquipItemBean();
        equipItem.setEquipId(1);
        equipItem.setEquipSeriesId(1);
        equipItem.setEquipStatus(IDLE);
        itemManager.buyEquipItem(equipItem);

        EquipItemBean e = equipItemOperator.queryById(1);
        Assert.assertEquals(equipItem, e);
    }

    @Test
    public void test002BuyEquipItems(){
        List<EquipItemBean> list = new ArrayList<>();
        for(int i = 2; i <= 10; i++){
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
        String hql = "from EquipItemBean e where e.equipSeriesId > 1";
        List<EquipItemBean> testList = equipItemOperator.queryAll(hql);
        EquipItemBean[] el = new EquipItemBean[list.size()];
        list.toArray(el);

        EquipItemBean[] tl = new EquipItemBean[testList.size()];
        testList.toArray(tl);

        Assert.assertArrayEquals(el, tl);
    }

    @Test
    public void test003BuySpareItem(){
        SpareItemBean spareItemBean = new SpareItemBean();
        spareItemBean.setSpareId(1);
        spareItemBean.setSpareSeriesId(1);
        spareItemBean.setSpareStatus(IDLE);

        itemManager.buySpareItem(spareItemBean);

        SpareItemBean s = spareItemOperator.queryById(1);

        Assert.assertEquals(spareItemBean, s);
    }

    @Test
    public void test004BuySpareItems(){
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
    public void test005DiscardEquipById(){
        itemManager.discardEquipById(1);
        EquipItemBean e = equipItemOperator.queryById(1);
        Assert.assertEquals(e.getEquipStatus(), new Integer(GARBAGE));
    }

    @Test
    public void test006DiscardEquip(){
        EquipItemBean equipItemBean = new EquipItemBean();
        equipItemBean.setEquipId(1);
        equipItemBean.setEquipSeriesId(2);
        itemManager.discardEquip(equipItemBean);

        EquipItemBean e = equipItemOperator.queryById(2);
        Assert.assertEquals(e.getEquipStatus(), new Integer(GARBAGE));
    }

    @Test
    public void test007DiscardSpareById(){
        itemManager.discardSpareById(1);
        SpareItemBean s = spareItemOperator.queryById(1);
        Assert.assertEquals(s.getSpareStatus(), new Integer(GARBAGE));
    }

    @Test
    public void test008DiscardSpare(){
        SpareItemBean spareItemBean = new SpareItemBean();
        spareItemBean.setSpareId(1);
        spareItemBean.setSpareSeriesId(2);
        itemManager.dicardSpare(spareItemBean);

        SpareItemBean s = spareItemOperator.queryById(2);
        Assert.assertEquals(s.getSpareStatus(), new Integer(GARBAGE));
    }

}