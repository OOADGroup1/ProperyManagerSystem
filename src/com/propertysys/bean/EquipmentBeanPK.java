package com.propertysys.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by shenying on 16/12/29.
 */
public class EquipmentBeanPK implements Serializable {
    private int catlogId;
    private int equipId;

    @Column(name = "catlog_id", nullable = false)
    @Id
    public int getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(int catlogId) {
        this.catlogId = catlogId;
    }

    @Column(name = "equip_id", nullable = false)
    @Id
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

        EquipmentBeanPK that = (EquipmentBeanPK) o;

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
