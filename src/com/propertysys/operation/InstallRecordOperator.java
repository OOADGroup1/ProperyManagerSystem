package com.propertysys.operation;

import com.propertysys.bean.InstallRecordBean;

import java.util.List;

/**
 * Created by Sunny on 16/12/28.
 */
public class InstallRecordOperator extends BaseOperator<InstallRecordBean> implements IInstallRecordOperator{

    public List<InstallRecordBean> viewInstallRecByEquipId(int equipId){
        String hql = "from InstallRecordBean i where i.equipSeriesId = ? " +
                "order by i.installRecId ASC";
        return queryAll(hql, equipId);
    }
}
