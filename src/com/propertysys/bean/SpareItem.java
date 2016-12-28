package com.propertysys.bean;

/**
 * Created by Sunny on 16/12/28.
 */
public class SpareItem {
    private int spareSeriesId;
    private int catlogId;
    private int spareId;
    private Integer spareStatus;

    public int getSpareSeriesId() {
        return spareSeriesId;
    }

    public void setSpareSeriesId(int spareSeriesId) {
        this.spareSeriesId = spareSeriesId;
    }

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

        SpareItem spareItem = (SpareItem) o;

        if (spareSeriesId != spareItem.spareSeriesId) return false;
        if (catlogId != spareItem.catlogId) return false;
        if (spareId != spareItem.spareId) return false;
        if (spareStatus != null ? !spareStatus.equals(spareItem.spareStatus) : spareItem.spareStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = spareSeriesId;
        result = 31 * result + catlogId;
        result = 31 * result + spareId;
        result = 31 * result + (spareStatus != null ? spareStatus.hashCode() : 0);
        return result;
    }
}
