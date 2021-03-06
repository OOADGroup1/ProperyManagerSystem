package com.propertysys.operation;

import com.propertysys.bean.EquipItemBean;

import java.util.List;


/**
 * Created by Sunny on 16/12/28.
 */
public class EquipItemOperator extends BaseOperator<EquipItemBean> implements IEuipItemOperator{

    public List getAllEquipInfo(){
        String hql = "select e.equipSeriesId, e.equipStatus, em.catlogType, " +
                "em.equipDesc, em.equipPrice from EquipItemBean e, EquipmentBean em " +
                "where e.equipId = em.equipId";
        return queryAll(hql);
    }

    public List getAllEquipInfo(String keyword){
        String hql = "select e.equipSeriesId, e.equipStatus, em.catlogType, " +
                "em.equipDesc, em.equipPrice from EquipItemBean e, EquipmentBean em " +
                "where e.equipId = em.equipId and em.equipDesc like '%" + keyword + "%'";
        return queryAll(hql);
    }
}
