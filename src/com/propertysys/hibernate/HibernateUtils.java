package com.propertysys.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by shenying on 16/12/28.
 */
public class HibernateUtils {

    private static SessionFactory factory;

    //static只初始化一次.
    static{
        try{
            //默认读取的是hibernate.cfg.xml 文件.
            Configuration cfg = new Configuration().configure();

            //建立SessionFactory.
            factory = cfg.buildSessionFactory();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Session getSession(){
        return factory.openSession();
    }

    public static void closeSession(Session session){
        if(session!=null){ //判断是否为空
            if(session.isOpen()){ //判断是否是打开状态再进行关闭.
                session.close();
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
