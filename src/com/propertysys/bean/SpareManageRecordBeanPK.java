package com.propertysys.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by shenying on 16/12/29.
 */
public class SpareManageRecordBeanPK implements Serializable {
    private int managerId;
    private int spareSeriesId;

    @Column(name = "manager_id", nullable = false)
    @Id
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Column(name = "spare_series_id", nullable = false)
    @Id
    public int getSpareSeriesId() {
        return spareSeriesId;
    }

    public void setSpareSeriesId(int spareSeriesId) {
        this.spareSeriesId = spareSeriesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpareManageRecordBeanPK that = (SpareManageRecordBeanPK) o;

        if (managerId != that.managerId) return false;
        if (spareSeriesId != that.spareSeriesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = managerId;
        result = 31 * result + spareSeriesId;
        return result;
    }
}
