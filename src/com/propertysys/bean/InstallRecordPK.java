package com.propertysys.bean;

import java.io.Serializable;

/**
 * Created by Sunny on 16/12/28.
 */
public class InstallRecordPK implements Serializable {
    private int equipSeriesId;
    private int spareSeriesId;

    public int getEquipSeriesId() {
        return equipSeriesId;
    }

    public void setEquipSeriesId(int equipSeriesId) {
        this.equipSeriesId = equipSeriesId;
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

        InstallRecordPK that = (InstallRecordPK) o;

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
