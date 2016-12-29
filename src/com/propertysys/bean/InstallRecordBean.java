package com.propertysys.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by shenying on 16/12/29.
 */
@Entity
@Table(name = "InstallRecord", schema = "prtydb", catalog = "")
@IdClass(InstallRecordBeanPK.class)
public class InstallRecordBean {
    private int equipSeriesId;
    private int spareSeriesId;
    private Timestamp installDate;

    @Id
    @Column(name = "equip_series_id", nullable = false)
    public int getEquipSeriesId() {
        return equipSeriesId;
    }

    public void setEquipSeriesId(int equipSeriesId) {
        this.equipSeriesId = equipSeriesId;
    }

    @Id
    @Column(name = "spare_series_id", nullable = false)
    public int getSpareSeriesId() {
        return spareSeriesId;
    }

    public void setSpareSeriesId(int spareSeriesId) {
        this.spareSeriesId = spareSeriesId;
    }

    @Basic
    @Column(name = "install_date", nullable = false)
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

        InstallRecordBean that = (InstallRecordBean) o;

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
