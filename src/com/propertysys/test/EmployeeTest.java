package com.propertysys.test;

import com.propertysys.bean.EmployeeBean;
import com.propertysys.bean.EquipItemBean;
import com.propertysys.bean.InstallRecordBean;
import com.propertysys.bean.SpareItemBean;
import com.propertysys.operation.EquipItemOperator;
import com.propertysys.operation.EquipRentRecordOperator;
import com.propertysys.operation.InstallRecordOperator;
import com.propertysys.operation.SpareItemOperator;
import com.propertysys.user.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sun.security.x509.OCSPNoCheckExtension;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sunny on 16/12/30.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeTest {
    private final int IDLE = 1;
    private final int OCCUPY = 0;
    private final String BORROW = "borrow";
    private final String RETURN = "return";
    private Employee employee;
    private InstallRecordOperator installRecordOperator;
    private EquipItemOperator equipItemOperator;
    private SpareItemOperator spareItemOperator;

    public EmployeeTest() {
    }

    @Before
    public void setUp() throws Exception {
        EmployeeBean employeeBean = new EmployeeBean();
        employeeBean.setEmployeeId(1);
        employeeBean.setEmployeeName("anna");
        employee = new Employee(employeeBean);
        installRecordOperator = new InstallRecordOperator();
        equipItemOperator = new EquipItemOperator();
        spareItemOperator = new SpareItemOperator();
    }

    @Test
    public void test001Install() throws Exception {
        employee.install(1, 1);
        String hql = "from InstallRecordBean r where r.equipSeriesId = 1 and r.spareSeriesId = 1";
        InstallRecordBean ir = installRecordOperator.queryAll(hql).get(0);
        installRecordOperator.delete(ir);
        List<InstallRecordBean> irList = installRecordOperator.queryAll(hql);
        Assert.assertEquals(0, irList.size());
    }

    @Test
    public void test002BorrowEquip(){
        employee.rentEquip(3, BORROW);
        EquipItemBean e = equipItemOperator.queryById(3);
        Assert.assertEquals(new Integer(OCCUPY), e.getEquipStatus());
    }

    @Test
    public void test003ReturnEquip(){
        employee.rentEquip(3, RETURN);
        EquipItemBean e = equipItemOperator.queryById(3);
        Assert.assertEquals(new Integer(IDLE), e.getEquipStatus());
    }


    @Test
    public void test004BorrowEquips(){
        int [] equipIds = {4, 5, 6, 7, 8};
        employee.rentEquips(equipIds, BORROW);
        int allOccupy = 0;
        for(int i = 4; i < 9; i++){
            EquipItemBean e = equipItemOperator.queryById(i);
            allOccupy |= e.getEquipStatus();
        }
        Assert.assertEquals(0, allOccupy);
    }

    @Test
    public void test005ReturnEquips(){
        int [] equipIds = {4, 5, 6, 7, 8};
        employee.rentEquips(equipIds, RETURN);
        int allIdle = 1;
        for(int i = 4; i < 9; i++){
            EquipItemBean e = equipItemOperator.queryById(i);
            allIdle &= e.getEquipStatus();
        }
        Assert.assertEquals(1, allIdle);
    }

    @Test
    public void test006BorrowSpare(){
        employee.rentSpare(3, BORROW);
        SpareItemBean s = spareItemOperator.queryById(3);
        Assert.assertEquals(new Integer(OCCUPY), s.getSpareStatus());
    }

    @Test
    public void test007ReturnSpare(){
        employee.rentSpare(3, RETURN);
        SpareItemBean s = spareItemOperator.queryById(3);
        Assert.assertEquals(new Integer(IDLE), s.getSpareStatus());
    }

    @Test
    public void test008BorrowSpares(){
        int [] spareIds = {4, 5, 6, 7, 8};
        employee.rentSpares(spareIds, BORROW);
        int allOccupy = 0;
        for(int i = 4; i < 9; i++){
            SpareItemBean s = spareItemOperator.queryById(i);
            allOccupy |= s.getSpareStatus();
        }
        Assert.assertEquals(0, allOccupy);
    }

    @Test
    public void test009ReturnSpares(){
        int [] spareIds = {4, 5, 6, 7, 8};
        employee.rentSpares(spareIds, RETURN);
        int allIdle = 1;
        for(int i = 4; i < 9; i++){
            SpareItemBean s = spareItemOperator.queryById(i);
            allIdle &= s.getSpareStatus();
        }
        Assert.assertEquals(1, allIdle);

    }
}