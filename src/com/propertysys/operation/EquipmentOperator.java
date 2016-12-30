package com.propertysys.operation;

import com.propertysys.bean.EquipmentBean;
import com.propertysys.bean.EquipmentBeanPK;
import com.propertysys.hibernate.HibernateUtils;
import org.hibernate.HibernateException;

/**
 * Created by Sunny on 16/12/28.
 */
public class EquipmentOperator extends BaseOperator<EquipmentBean> implements IEquipmentOperator {

    //    private Session session = this.session;
//    private Transaction tx = this.tx;


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

    }
}
