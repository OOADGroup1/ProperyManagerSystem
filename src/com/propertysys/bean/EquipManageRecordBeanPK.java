package com.propertysys.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by shenying on 16/12/29.
 */
public class EquipManageRecordBeanPK implements Serializable {
    private int equipSeriesId;
    private int managerId;

    @Column(name = "equip_series_id", nullable = false)
    @Id
    public int getEquipSeriesId() {
        return equipSeriesId;
    }

    public void setEquipSeriesId(int equipSeriesId) {
        this.equipSeriesId = equipSeriesId;
    }

    @Column(name = "manager_id", nullable = false)
    @Id
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

        EquipManageRecordBeanPK that = (EquipManageRecordBeanPK) o;

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
