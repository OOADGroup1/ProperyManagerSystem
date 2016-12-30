package com.propertysys.bean;

import javax.persistence.*;

/**
 * Created by Sunny on 16/12/30.
 */
@Entity
@Table(name = "SpareItem", schema = "prtydb", catalog = "")
public class SpareItemBean {
    private int spareSeriesId;
    private int spareId;
    private Integer spareStatus;
    private String catlogType;
    private String spareDesc;
    private Double sparePrice;

    public SpareItemBean(){}

    public SpareItemBean(int spareSeriesId, Integer spareStatus,
                         String catlogType, String spareDesc, Double sparePrice){
        this.spareSeriesId = spareSeriesId;
        this.spareStatus = spareStatus;
        this.catlogType = catlogType;
        this.spareDesc = spareDesc;
        this.sparePrice = sparePrice;
    }

    public void setCatlogType(String catlogType){
        this.catlogType = catlogType;
    }

    public String getCatlogType(){
        return catlogType;
    }

    public void setSpareDesc(String spareDesc){
        this.spareDesc = spareDesc;
    }

    public String getSpareDesc(){
        return spareDesc;
    }

    public void setSparePrice(Double sparePrice){
        this.sparePrice = sparePrice;
    }

    public Double getSparePrice(){
        return sparePrice;
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
    @Column(name = "spare_id", nullable = false)
    public int getSpareId() {
        return spareId;
    }

    public void setSpareId(int spareId) {
        this.spareId = spareId;
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
        if (spareId != that.spareId) return false;
        if (spareStatus != null ? !spareStatus.equals(that.spareStatus) : that.spareStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = spareSeriesId;
        result = 31 * result + spareId;
        result = 31 * result + (spareStatus != null ? spareStatus.hashCode() : 0);
        return result;
    }
}
