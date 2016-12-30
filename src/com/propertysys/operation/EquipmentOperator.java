package com.propertysys.operation;

import com.propertysys.hibernate.HibernateUtils;
import org.hibernate.HibernateException;

/**
 * Created by Sunny on 16/12/28.
 */
public class EquipmentOperator extends BaseOperator<EquipmentBean> implements IEquipmentOperator {

    public EquipmentBean queryByPK(EquipmentBeanPK pk){
        EquipmentBean equipmentBean = null;
        try {
            startOperation();
            equipmentBean = (EquipmentBean) session.get(EquipmentBean.class, pk);
            tx.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
        return equipmentBean;
    }

    public void deleteByPK(EquipmentBeanPK pk){
        EquipmentBean equipmentBean = null;
        try {
            startOperation();
            equipmentBean = (EquipmentBean) session.get(EquipmentBean.class, pk);
            session.delete(equipmentBean);
            tx.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }
}
