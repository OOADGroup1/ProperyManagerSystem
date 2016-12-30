package com.propertysys.operation;

/**
 * Created by shenying on 16/12/29.
 */
public interface IEquipmentOperator extends IBaseOperator<EquipmentBean> {

    EquipmentBean queryByPK(EquipmentBeanPK pk);
    void deleteByPK(EquipmentBeanPK pk);
}
