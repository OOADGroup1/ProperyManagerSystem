package com.propertysys.bean;

import java.sql.Timestamp;

/**
 * Created by Sunny on 16/12/28.
 */
public class InstallRecord {
    private int equipSeriesId;
    private int spareSeriesId;
    private Timestamp installDate;

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

    public Timestamp getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Timestamp installDate) {
        this.installDate = installDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstallRecord that = (InstallRecord) o;

        if (equipSeriesId != that.equipSeriesId) return false;
        if (spareSeriesId != that.spareSeriesId) return false;
        if (installDate != null ? !installDate.equals(that.installDate) : that.installDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipSeriesId;
        result = 31 * result + spareSeriesId;
        result = 31 * result + (installDate != null ? installDate.hashCode() : 0);
        return result;
    }
}
