package com.propertysys.operation;

import com.propertysys.hibernate.HibernateUtils;
import org.hibernate.*;

import java.util.Iterator;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import static com.propertysys.hibernate.HibernateUtils.getSession;

/**
 * Created by shenying on 16/12/29.
 */
@SuppressWarnings("unchecked")
public abstract class BaseOperator<T> implements IBaseOperator<T> {
    protected Class<T> clazz;

    public BaseOperator(){
        ParameterizedType type = (ParameterizedType) this.getClass()
                .getGenericSuperclass();
        this.clazz = (Class) type.getActualTypeArguments()[0];
    }

    protected Session session;
    protected Transaction tx;

    @Override
    public void insert(T t) {
        try {
            startOperation();
            session.save(t);
            tx.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    @Override
    public void insertAll(List<T> list){
        try {
            startOperation();
            for(Iterator iter = list.iterator(); iter.hasNext();) {
                session.save((T) iter.next());
            }
            tx.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }


    @Override
    public void delete(T t) {
        try {
            startOperation();
            session.delete(t);
            tx.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    @Override
    public void delete(int id) {
        try {
            startOperation();
            Object object = (Object) getSession().get(clazz, id);
            session.delete(object);
            tx.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }

    }

    @Override
    public void update(T t) {
        try {
            startOperation();
            session.update(t);
            tx.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T queryById(int id) {
        T t = null;
        try {
            startOperation();
            t = (T) session.get(clazz, id);
            tx.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
        return t;
    }

    @Override
    public List<T> queryAll(String hql, Object[] args){
        List<T> listT = null;
        try {
            startOperation();
            Query query = session.createQuery(hql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    query.setParameter(i, args[i]);
                }
            }
            listT = query.list();
            tx.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
        return listT;
    }

    @Override
    public List<T> queryAll(String hql, Object arg){
        return this.queryAll(hql, new Object[] { arg });
    }

    @Override
    public List<T> queryAll(String hql){
        return this.queryAll(hql, null);
    }

    @Override
    public List<T> queryAll() {
        List<T> listT = null;
        try {
            startOperation();
            listT = session.createQuery("from " + clazz.getSimpleName()).list();
            tx.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
        return listT;
    }

    protected void startOperation() throws HibernateException {
        session = getSession();
        tx = session.beginTransaction();
    }


}
