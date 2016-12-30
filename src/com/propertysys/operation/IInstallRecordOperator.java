package com.propertysys.operation;

import com.propertysys.bean.InstallRecordBean;

import java.util.List;

/**
 * Created by shenying on 16/12/29.
 */
public interface IInstallRecordOperator extends IBaseOperator<InstallRecordBean> {

    List<InstallRecordBean> viewInstallRecByEquipId(int equipId);
}
