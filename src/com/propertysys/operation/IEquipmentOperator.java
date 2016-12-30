package com.propertysys.operation;

import com.propertysys.bean.EquipmentBean;
import com.propertysys.bean.EquipmentBeanPK;

import java.util.List;

/**
 * Created by shenying on 16/12/29.
 */
public interface IEquipmentOperator extends IBaseOperator<EquipmentBean> {

    EquipmentBean queryByPK(EquipmentBeanPK pk);
    void deleteByPK(EquipmentBeanPK pk);
}
