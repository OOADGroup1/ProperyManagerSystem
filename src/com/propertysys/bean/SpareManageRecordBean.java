package com.propertysys.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sunny on 16/12/30.
 */
@Entity
@Table(name = "SpareManageRecord", schema = "prtydb", catalog = "")
public class SpareManageRecordBean {
    private int managerId;
    private int spareSeriesId;
    private Timestamp manageDate;
    private String manageType;
    private int spareMngRecId;

    @Basic
    @Column(name = "manager_id", nullable = false)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "spare_series_id", nullable = false)
    public int getSpareSeriesId() {
        return spareSeriesId;
    }

    public void setSpareSeriesId(int spareSeriesId) {
        this.spareSeriesId = spareSeriesId;
    }

    @Basic
    @Column(name = "manage_date", nullable = false)
    public Timestamp getManageDate() {
        return manageDate;
    }

    public void setManageDate(Timestamp manageDate) {
        this.manageDate = manageDate;
    }

    @Basic
    @Column(name = "manage_type", nullable = true, length = 50)
    public String getManageType() {
        return manageType;
    }

    public void setManageType(String manageType) {
        this.manageType = manageType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spare_mng_rec_id", nullable = false)
    public int getSpareMngRecId() {
        return spareMngRecId;
    }

    public void setSpareMngRecId(int spareMngRecId) {
        this.spareMngRecId = spareMngRecId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpareManageRecordBean that = (SpareManageRecordBean) o;

        if (managerId != that.managerId) return false;
        if (spareSeriesId != that.spareSeriesId) return false;
        if (spareMngRecId != that.spareMngRecId) return false;
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
        result = 31 * result + spareMngRecId;
        return result;
    }
}
