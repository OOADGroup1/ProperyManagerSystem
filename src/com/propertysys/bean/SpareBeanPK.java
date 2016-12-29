package com.propertysys.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by shenying on 16/12/29.
 */
public class SpareBeanPK implements Serializable {
    private int catlogId;
    private int spareId;

    @Column(name = "catlog_id", nullable = false)
    @Id
    public int getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(int catlogId) {
        this.catlogId = catlogId;
    }

    @Column(name = "spare_id", nullable = false)
    @Id
    public int getSpareId() {
        return spareId;
    }

    public void setSpareId(int spareId) {
        this.spareId = spareId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpareBeanPK that = (SpareBeanPK) o;

        if (catlogId != that.catlogId) return false;
        if (spareId != that.spareId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catlogId;
        result = 31 * result + spareId;
        return result;
    }
}
