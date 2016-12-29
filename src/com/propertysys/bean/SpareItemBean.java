package com.propertysys.bean;

import javax.persistence.*;

/**
 * Created by shenying on 16/12/29.
 */
@Entity
@Table(name = "SpareItem", schema = "prtydb", catalog = "")
public class SpareItemBean {
    private int spareSeriesId;
    private Integer spareStatus;

    @Id
    @Column(name = "spare_series_id", nullable = false)
    public int getSpareSeriesId() {
        return spareSeriesId;
    }

    public void setSpareSeriesId(int spareSeriesId) {
        this.spareSeriesId = spareSeriesId;
    }

    @Basic
    @Column(name = "spare_status", nullable = true)
    public Integer getSpareStatus() {
        return spareStatus;
    }

    public void setSpareStatus(Integer spareStatus) {
        this.spareStatus = spareStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpareItemBean that = (SpareItemBean) o;

        if (spareSeriesId != that.spareSeriesId) return false;
        if (spareStatus != null ? !spareStatus.equals(that.spareStatus) : that.spareStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = spareSeriesId;
        result = 31 * result + (spareStatus != null ? spareStatus.hashCode() : 0);
        return result;
    }
}
