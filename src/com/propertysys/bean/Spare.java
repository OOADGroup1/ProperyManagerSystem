package com.propertysys.bean;

/**
 * Created by Sunny on 16/12/28.
 */
public class Spare {
    private int catlogId;
    private int spareId;
    private String catlogType;
    private String spareDesc;
    private Double sparePrice;

    public int getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(int catlogId) {
        this.catlogId = catlogId;
    }

    public int getSpareId() {
        return spareId;
    }

    public void setSpareId(int spareId) {
        this.spareId = spareId;
    }

    public String getCatlogType() {
        return catlogType;
    }

    public void setCatlogType(String catlogType) {
        this.catlogType = catlogType;
    }

    public String getSpareDesc() {
        return spareDesc;
    }

    public void setSpareDesc(String spareDesc) {
        this.spareDesc = spareDesc;
    }

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

        Spare spare = (Spare) o;

        if (catlogId != spare.catlogId) return false;
        if (spareId != spare.spareId) return false;
        if (catlogType != null ? !catlogType.equals(spare.catlogType) : spare.catlogType != null) return false;
        if (spareDesc != null ? !spareDesc.equals(spare.spareDesc) : spare.spareDesc != null) return false;
        if (sparePrice != null ? !sparePrice.equals(spare.sparePrice) : spare.sparePrice != null) return false;

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
