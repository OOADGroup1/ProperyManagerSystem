package com.propertysys.bean;

import java.io.Serializable;

/**
 * Created by Sunny on 16/12/28.
 */
public class SpareRentRecordPK implements Serializable {
    private int employeeId;
    private int spareSeriesId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

        SpareRentRecordPK that = (SpareRentRecordPK) o;

        if (employeeId != that.employeeId) return false;
        if (spareSeriesId != that.spareSeriesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + spareSeriesId;
        return result;
    }
}
