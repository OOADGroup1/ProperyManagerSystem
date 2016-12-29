package com.propertysys.bean;

import javax.persistence.*;

/**
 * Created by shenying on 16/12/29.
 */
@Entity
@Table(name = "Spare", schema = "prtydb", catalog = "")
@IdClass(SpareBeanPK.class)
public class SpareBean {
    private int catlogId;
    private int spareId;
    private String catlogType;
    private String spareDesc;
    private Double sparePrice;

    @Id
    @Column(name = "catlog_id", nullable = false)
    public int getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(int catlogId) {
        this.catlogId = catlogId;
    }

    @Id
    @Column(name = "spare_id", nullable = false)
    public int getSpareId() {
        return spareId;
    }

    public void setSpareId(int spareId) {
        this.spareId = spareId;
    }

    @Basic
    @Column(name = "catlog_type", nullable = true, length = 50)
    public String getCatlogType() {
        return catlogType;
    }

    public void setCatlogType(String catlogType) {
        this.catlogType = catlogType;
    }

    @Basic
    @Column(name = "spare_desc", nullable = true, length = -1)
    public String getSpareDesc() {
        return spareDesc;
    }

    public void setSpareDesc(String spareDesc) {
        this.spareDesc = spareDesc;
    }

    @Basic
    @Column(name = "spare_price", nullable = true, precision = 0)
    public Double getSparePrice() {
        return sparePrice;
    }

    public void setSparePrice(Double sparePrice) {
        this.sparePrice = sparePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpareBean spareBean = (SpareBean) o;

        if (catlogId != spareBean.catlogId) return false;
        if (spareId != spareBean.spareId) return false;
        if (catlogType != null ? !catlogType.equals(spareBean.catlogType) : spareBean.catlogType != null) return false;
        if (spareDesc != null ? !spareDesc.equals(spareBean.spareDesc) : spareBean.spareDesc != null) return false;
        if (sparePrice != null ? !sparePrice.equals(spareBean.sparePrice) : spareBean.sparePrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catlogId;
        result = 31 * result + spareId;
        result = 31 * result + (catlogType != null ? catlogType.hashCode() : 0);
        result = 31 * result + (spareDesc != null ? spareDesc.hashCode() : 0);
        result = 31 * result + (sparePrice != null ? sparePrice.hashCode() : 0);
        return result;
    }
}
