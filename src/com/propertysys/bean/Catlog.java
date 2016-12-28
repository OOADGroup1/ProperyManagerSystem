package com.propertysys.bean;

/**
 * Created by Sunny on 16/12/28.
 */
public class Catlog {
    private int catlogId;
    private String catlogType;

    public int getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(int catlogId) {
        this.catlogId = catlogId;
    }

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

        Catlog catlog = (Catlog) o;

        if (catlogId != catlog.catlogId) return false;
        if (catlogType != null ? !catlogType.equals(catlog.catlogType) : catlog.catlogType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catlogId;
        result = 31 * result + (catlogType != null ? catlogType.hashCode() : 0);
        return result;
    }
}
