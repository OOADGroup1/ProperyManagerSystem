package com.propertysys.bean;

import java.io.Serializable;

/**
 * Created by Sunny on 16/12/28.
 */
public class EquipmentPK implements Serializable {
    private int catlogId;
    private int equipId;

    public int getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(int catlogId) {
        this.catlogId = catlogId;
    }

    public int getEquipId() {
        return equipId;
    }

    public void setEquipId(int equipId) {
        this.equipId = equipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentPK that = (EquipmentPK) o;

        if (catlogId != that.catlogId) return false;
        if (equipId != that.equipId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catlogId;
        result = 31 * result + equipId;
        return result;
    }
}
