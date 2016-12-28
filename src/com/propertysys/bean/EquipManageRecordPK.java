package com.propertysys.bean;

import java.io.Serializable;

/**
 * Created by Sunny on 16/12/28.
 */
public class EquipManageRecordPK implements Serializable {
    private int equipSeriesId;
    private int managerId;

    public int getEquipSeriesId() {
        return equipSeriesId;
    }

    public void setEquipSeriesId(int equipSeriesId) {
        this.equipSeriesId = equipSeriesId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipManageRecordPK that = (EquipManageRecordPK) o;

        if (equipSeriesId != that.equipSeriesId) return false;
        if (managerId != that.managerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipSeriesId;
        result = 31 * result + managerId;
        return result;
    }
}
