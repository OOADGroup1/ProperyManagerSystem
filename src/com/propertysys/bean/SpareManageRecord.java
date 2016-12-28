package com.propertysys.bean;

import java.sql.Timestamp;

/**
 * Created by Sunny on 16/12/28.
 */
public class SpareManageRecord {
    private int managerId;
    private int spareSeriesId;
    private Timestamp manageDate;
    private String manageType;

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

    public Timestamp getManageDate() {
        return manageDate;
    }

    public void setManageDate(Timestamp manageDate) {
        this.manageDate = manageDate;
    }

    public String getManageType() {
        return manageType;
    }

    public void setManageType(String manageType) {
        this.manageType = manageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpareManageRecord that = (SpareManageRecord) o;

        if (managerId != that.managerId) return false;
        if (spareSeriesId != that.spareSeriesId) return false;
        if (manageDate != null ? !manageDate.equals(that.manageDate) : that.manageDate != null) return false;
        if (manageType != null ? !manageType.equals(that.manageType) : that.manageType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = managerId;
        result = 31 * result + spareSeriesId;
        result = 31 * result + (manageDate != null ? manageDate.hashCode() : 0);
        result = 31 * result + (manageType != null ? manageType.hashCode() : 0);
        return result;
    }
}
