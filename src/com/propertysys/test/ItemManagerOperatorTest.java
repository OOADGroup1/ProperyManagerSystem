package com.propertysys.test;

import com.propertysys.operation.ItemManagerOperator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by shenying on 16/12/30.
 */
public class ItemManagerOperatorTest {
    private Session session;
    private Transaction ts;
    private ItemManagerOperator itemManagerOperator;

    @Before
    public void setUp() throws Exception {
        itemManagerOperator = new ItemManagerOperator();
    }

    @Test
    public void insert() throws Exception {
        ItemManagerBean itemManagerBean = new ItemManagerBean();
        itemManagerBean.setManagerId(0);
        itemManagerOperator.insert(itemManagerBean);
    }
}