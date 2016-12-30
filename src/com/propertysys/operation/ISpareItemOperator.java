package com.propertysys.operation;

import com.propertysys.bean.SpareItemBean;

import java.util.List;

/**
 * Created by shenying on 16/12/29.
 */
public interface ISpareItemOperator extends IBaseOperator<SpareItemBean> {

    List getAllSpareInfo();
    List getAllSpareInfo(String keyword);
}
