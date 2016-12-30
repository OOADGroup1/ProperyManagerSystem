package com.propertysys.bean;

import javax.persistence.*;

/**
 * Created by Sunny on 16/12/30.
 */
@Entity
@Table(name = "Catlog", schema = "prtydb", catalog = "")
public class CatlogBean {
    private int catlogId;
    private String catlogType;

    @Id
    @Column(name = "catlog_id", nullable = false)
    public int getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(int catlogId) {
        this.catlogId = catlogId;
    }

    @Basic
    @Column(name = "catlog_type", nullable = true, length = 50)
    public String getCatlogType() {
        return catlogType;
    }

    public void setCatlogType(String catlogType) {
        this.catlogType = catlogType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatlogBean that = (CatlogBean) o;

        if (catlogId != that.catlogId) return false;
        if (catlogType != null ? !catlogType.equals(that.catlogType) : that.catlogType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catlogId;
        result = 31 * result + (catlogType != null ? catlogType.hashCode() : 0);
        return result;
    }
}
