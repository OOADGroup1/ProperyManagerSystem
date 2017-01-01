package com.propertysys.test;

import com.propertysys.bean.InstallRecordBean;
import com.propertysys.operation.InstallRecordOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Object;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shenying on 16/12/31.
 */
public class InstallRecordOperatorTest {

    private InstallRecordOperator installRecordOperator;

    @Before
    public void setUp() throws Exception {
        installRecordOperator = new InstallRecordOperator();
    }

    @Test
    public void viewInstallRecByEquipId() throws Exception {
        List<InstallRecordBean> list = installRecordOperator.viewInstallRecByEquipId(2);
        for (InstallRecordBean installRec:
                list) {
            System.out.println(installRec.getInstallDate() +
                    " installed Spare(SpareSeriesId: " + installRec.getSpareSeriesId() + ")");
        }
        Assert.assertEquals(1, list.size());
    }

}