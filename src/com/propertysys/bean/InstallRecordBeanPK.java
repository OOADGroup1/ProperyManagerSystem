package com.propertysys.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by shenying on 16/12/29.
 */
public class InstallRecordBeanPK implements Serializable {
    private int equipSeriesId;
    private int spareSeriesId;

    @Column(name = "equip_series_id", nullable = false)
    @Id
    public int getEquipSeriesId() {
        return equipSeriesId;
    }

    public void setEquipSeriesId(int equipSeriesId) {
        this.equipSeriesId = equipSeriesId;
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

        InstallRecordBeanPK that = (InstallRecordBeanPK) o;

        if (equipSeriesId != that.equipSeriesId) return false;
        if (spareSeriesId != that.spareSeriesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipSeriesId;
        result = 31 * result + spareSeriesId;
        return result;
    }
}
