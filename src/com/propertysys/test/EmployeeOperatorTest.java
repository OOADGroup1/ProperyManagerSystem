package com.propertysys.test;

import com.propertysys.bean.EmployeeBean;
import com.propertysys.operation.EmployeeOperator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shenying on 16/12/29.
 */
public class EmployeeOperatorTest {
    private Session session;
    private Transaction ts;
    private EmployeeOperator employeeOperator;

    @Before
    public void setUp() throws Exception {
        employeeOperator = new EmployeeOperator();
    }

    @Test
    public void insert() throws Exception {
        EmployeeBean employeeBean = new EmployeeBean();
        employeeBean.setEmployeeId(4);
        employeeBean.setEmployeeName("anna");
        employeeOperator.insert(employeeBean);
    }

    @Test
    public void delete() throws Exception {
        EmployeeBean employeeBean = new EmployeeBean();
        employeeBean.setEmployeeId(4);
        employeeBean.setEmployeeName("anna");
        employeeOperator.delete(employeeBean);
    }

    @Test
    public void delete1() throws Exception {
        employeeOperator.delete(3);
    }

    @Test
    public void update() throws Exception {
        EmployeeBean employeeBean = new EmployeeBean();
        employeeBean.setEmployeeId(2);
        employeeBean.setEmployeeName("new name");
        employeeOperator.update(employeeBean);
    }

    @Test
    public void queryById() throws Exception {
        EmployeeBean employeeBean = employeeOperator.queryById(0);
        System.out.println(employeeBean.getEmployeeName());
    }

    @Test
    public void queryAll() throws Exception {
        List<EmployeeBean> list = employeeOperator.queryAll();
        for(Iterator iter = list.iterator(); iter.hasNext();) {
            EmployeeBean employeeBean = (EmployeeBean) iter.next();
            System.out.println("id=" + employeeBean.getEmployeeId() +
                    " name=" + employeeBean.getEmployeeName());
        }
    }

}