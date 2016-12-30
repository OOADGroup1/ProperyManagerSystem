package com.propertysys.bean;

import javax.persistence.*;

/**
 * Created by Sunny on 16/12/30.
 */
@Entity
@Table(name = "EquipItem", schema = "prtydb", catalog = "")
public class EquipItemBean {
    private int equipSeriesId;
    private int equipId;
    private Integer equipStatus;

    @Id
    @Column(name = "equip_series_id", nullable = false)
    public int getEquipSeriesId() {
        return equipSeriesId;
    }

    public void setEquipSeriesId(int equipSeriesId) {
        this.equipSeriesId = equipSeriesId;
    }

    @Basic
    @Column(name = "equip_id", nullable = false)
    public int getEquipId() {
        return equipId;
    }

    public void setEquipId(int equipId) {
        this.equipId = equipId;
    }

    @Basic
    @Column(name = "equip_status", nullable = true)
    public Integer getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(Integer equipStatus) {
        this.equipStatus = equipStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipItemBean that = (EquipItemBean) o;

        if (equipSeriesId != that.equipSeriesId) return false;
        if (equipId != that.equipId) return false;
        if (equipStatus != null ? !equipStatus.equals(that.equipStatus) : that.equipStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipSeriesId;
        result = 31 * result + equipId;
        result = 31 * result + (equipStatus != null ? equipStatus.hashCode() : 0);
        return result;
    }
}
