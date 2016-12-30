package com.propertysys.operation;

import com.propertysys.bean.EquipItemBean;

import java.util.List;

/**
 * Created by shenying on 16/12/29.
 */
public interface IEuipItemOperator extends IBaseOperator<EquipItemBean> {

    List getAllEquipInfo();
}
