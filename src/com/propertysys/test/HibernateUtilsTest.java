package com.propertysys.test;

import com.propertysys.bean.EmployeeBean;
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
        }finally{
            HibernateUtils.closeSession(session);
        }

    }

//    @Test
//    public void testHibernate() throws Exception{
//        Configuration cfg = new Configuration().configure();
//
//        //建立SessionFactory.
//        SessionFactory factroy = cfg.buildSessionFactory();
//        //取得session.
//        Session session = null;
//
//        try
//        {
//            //通过工厂取得session
//            session = factroy.openSession();
//
//            //开启事务.
//            session.beginTransaction();
//            //给对象赋值.
//            Employee employee = new Employee();
//            employee.setEmployeeId(0);
//            employee.setEmployeeName("alex");
//            session.save(employee);
//
//            //先拿到前面事务的对象.再提交事务.
//            session.getTransaction().commit();
//        }catch( Exception e)
//        {
//            e.printStackTrace();
//            //回滚事务.
//            session.getTransaction().rollback();
//        }finally{
//
//            if(session!=null)
//            {
//                if(session.isOpen())
//                {
//                    //关闭session.
//                    //hibernate中已经将connection的的关闭封装了.
//                    //我们没有看到任何一条sql语句.
//                    session.close();
//                }
//            }
//        }
//    }

}