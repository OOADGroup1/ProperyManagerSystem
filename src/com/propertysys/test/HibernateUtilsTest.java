package com.propertysys.test;

import com.propertysys.hibernate.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by shenying on 16/12/29.
 */
public class HibernateUtilsTest {



    @Test
    public void testSession() throws Exception {
        Session session = HibernateUtils.getSession();
        Transaction ts = session.beginTransaction();
        EmployeeBean employee = new EmployeeBean();
        try {
            employee.setEmployeeId(0);
            employee.setEmployeeName("alex");
            session.save(employee);
            ts.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
        }finally{
            HibernateUtils.closeSession(session);
        }

    }

}