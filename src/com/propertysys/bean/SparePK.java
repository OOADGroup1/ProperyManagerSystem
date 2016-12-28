package com.propertysys.bean;

import java.io.Serializable;

/**
 * Created by Sunny on 16/12/28.
 */
public class SparePK implements Serializable {
    private int catlogId;
    private int spareId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SparePK sparePK = (SparePK) o;

        if (catlogId != sparePK.catlogId) return false;
        if (spareId != sparePK.spareId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catlogId;
        result = 31 * result + spareId;
        return result;
    }
}
