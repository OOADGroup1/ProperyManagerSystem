package com.propertysys.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by shenying on 16/12/29.
 */
@Entity
@Table(name = "EquipManageRecord", schema = "prtydb", catalog = "")
@IdClass(EquipManageRecordBeanPK.class)
public class EquipManageRecordBean {
    private int equipSeriesId;
    private int managerId;
    private Timestamp manageDate;
    private String manageType;

    @Id
    @Column(name = "equip_series_id", nullable = false)
    public int getEquipSeriesId() {
        return equipSeriesId;
    }

    public void setEquipSeriesId(int equipSeriesId) {
        this.equipSeriesId = equipSeriesId;
    }

    @Id
    @Column(name = "manager_id", nullable = false)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipManageRecordBean that = (EquipManageRecordBean) o;

        if (equipSeriesId != that.equipSeriesId) return false;
        if (managerId != that.managerId) return false;
        if (manageDate != null ? !manageDate.equals(that.manageDate) : that.manageDate != null) return false;
        if (manageType != null ? !manageType.equals(that.manageType) : that.manageType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipSeriesId;
        result = 31 * result + managerId;
        result = 31 * result + (manageDate != null ? manageDate.hashCode() : 0);
        result = 31 * result + (manageType != null ? manageType.hashCode() : 0);
        return result;
    }
}
