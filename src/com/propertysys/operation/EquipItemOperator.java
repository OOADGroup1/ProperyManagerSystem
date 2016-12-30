package com.propertysys.operation;

import java.util.List;


/**
 * Created by Sunny on 16/12/28.
 */
public class EquipItemOperator extends BaseOperator<EquipItemBean> implements IEuipItemOperator{

    public List getAllEquipInfo(){
        String hql = "select e.equipSeriesId, e.equipStatus, " +
                "em.equipDesc, em.equipPrice from EquipItemBean e, EquipmentBean em " +
                "where e.equipId = em.equipId";
        return queryAll(hql);
    }
}
