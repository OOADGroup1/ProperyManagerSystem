package com.propertysys.bean;

import java.io.Serializable;

/**
 * Created by Sunny on 16/12/28.
 */
public class SpareManageRecordPK implements Serializable {
    private int managerId;
    private int spareSeriesId;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

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

        SpareManageRecordPK that = (SpareManageRecordPK) o;

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
