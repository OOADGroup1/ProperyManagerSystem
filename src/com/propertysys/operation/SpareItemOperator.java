package com.propertysys.operation;

import com.propertysys.bean.SpareItemBean;

import java.util.List;

/**
 * Created by Sunny on 16/12/28.
 */
public class SpareItemOperator extends BaseOperator<SpareItemBean> implements ISpareItemOperator{

    public List getAllSpareInfo(){
        String hql = "select NEW SpareItemBean(si.spareSeriesId, si.spareStatus, s.catlogType, " +
                "s.spareDesc, s.sparePrice) from SpareItemBean si, SpareBean s " +
                "where si.spareId = s.spareId";
        return queryAll(hql);
    }
}
