package com.propertysys.test;

import com.propertysys.bean.SpareItemBean;
import com.propertysys.operation.SpareItemOperator;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shenying on 16/12/30.
 */
public class SpareItemOperatorTest {
    private SpareItemOperator spareItemOperator;

    @Before
    public void setUp() throws Exception{
        spareItemOperator = new SpareItemOperator();
    }

    @Test
    public void getAllSpareInfo() throws Exception {
        List spareInfo = spareItemOperator.getAllSpareInfo();
        for(Iterator iter = spareInfo.iterator(); iter.hasNext();){
            Object[] spare = (Object[]) iter.next();
            System.out.println("equipSeriesId=" + (int) spare[0] +
                    " EquipStatus=" + (Integer)spare[1] +
                    " CatlogType=" + (String) spare[2] +
                    " desc=" + (String) spare[3] +
                    " price=" + (Double) spare[4]);
        }
    }


}