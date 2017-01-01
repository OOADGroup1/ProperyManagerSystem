package com.propertysys.test;

import com.propertysys.bean.EquipItemBean;
import com.propertysys.operation.EquipItemOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Sunnygit on 16/12/30.
 */
public class EquipItemOperatorTest {
    private EquipItemOperator equipItemOperator;
    @Before
    public void setUp() throws Exception {
        equipItemOperator = new EquipItemOperator();
    }

    @Test
    public void getAllEquipInfo() throws Exception {
        List equipInfo = equipItemOperator.getAllEquipInfo();
        for(Iterator iter = equipInfo.iterator(); iter.hasNext();){
            Object[] equip = (Object[]) iter.next();
            System.out.println("equipSeriesId=" + (int) equip[0] +
                    " EquipStatus=" + (Integer)equip[1] +
                    " CatlogType=" + (String) equip[2] +
                    " desc=" + (String) equip[3] +
                    " price=" + (Double) equip[4]);
        }
        Assert.assertEquals(15, equipInfo.size());

    }

    @Test
    public void getAllEquipInfo1() throws Exception {
        String testKey = "mo";
        List equipInfo = equipItemOperator.getAllEquipInfo(testKey);
        for(Iterator iter = equipInfo.iterator(); iter.hasNext();){
            Object[] equip = (Object[]) iter.next();
            System.out.println("equipSeriesId=" + (int) equip[0] +
                    " EquipStatus=" + (Integer)equip[1] +
                    " CatlogType=" + (String) equip[2] +
                    " desc=" + (String) equip[3] +
                    " price=" + (Double) equip[4]);
        }
        Assert.assertEquals(10, equipInfo.size());
    }

}