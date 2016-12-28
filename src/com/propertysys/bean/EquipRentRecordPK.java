package com.propertysys.bean;

import java.io.Serializable;

/**
 * Created by Sunny on 16/12/28.
 */
public class EquipRentRecordPK implements Serializable {
    private int employeeId;
    private int equipSeriesId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEquipSeriesId() {
        return equipSeriesId;
    }

    public void setEquipSeriesId(int equipSeriesId) {
        this.equipSeriesId = equipSeriesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipRentRecordPK that = (EquipRentRecordPK) o;

        if (employeeId != that.employeeId) return false;
        if (equipSeriesId != that.equipSeriesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + equipSeriesId;
        return result;
    }
}
