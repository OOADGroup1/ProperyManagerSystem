package com.propertysys.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by shenying on 16/12/29.
 */
public class SpareRentRecordBeanPK implements Serializable {
    private int employeeId;
    private int spareSeriesId;

    @Column(name = "employee_id", nullable = false)
    @Id
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

        SpareRentRecordBeanPK that = (SpareRentRecordBeanPK) o;

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
