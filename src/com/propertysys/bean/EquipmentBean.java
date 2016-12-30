package com.propertysys.bean;

import javax.persistence.*;

/**
 * Created by Sunny on 16/12/30.
 */
@Entity
@Table(name = "Equipment", schema = "prtydb", catalog = "")
public class EquipmentBean {
    private int catlogId;
    private int equipId;
    private String catlogType;
    private String equipDesc;
    private Double equipPrice;

    @Basic
    @Column(name = "catlog_id", nullable = false)
    public int getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(int catlogId) {
        this.catlogId = catlogId;
    }

    @Id
    @Column(name = "equip_id", nullable = false)
    public int getEquipId() {
        return equipId;
    }

    public void setEquipId(int equipId) {
        this.equipId = equipId;
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
    @Column(name = "equip_desc", nullable = true, length = -1)
    public String getEquipDesc() {
        return equipDesc;
    }

    public void setEquipDesc(String equipDesc) {
        this.equipDesc = equipDesc;
    }

    @Basic
    @Column(name = "equip_price", nullable = true, precision = 0)
    public Double getEquipPrice() {
        return equipPrice;
    }

    public void setEquipPrice(Double equipPrice) {
        this.equipPrice = equipPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentBean that = (EquipmentBean) o;

        if (catlogId != that.catlogId) return false;
        if (equipId != that.equipId) return false;
        if (catlogType != null ? !catlogType.equals(that.catlogType) : that.catlogType != null) return false;
        if (equipDesc != null ? !equipDesc.equals(that.equipDesc) : that.equipDesc != null) return false;
        if (equipPrice != null ? !equipPrice.equals(that.equipPrice) : that.equipPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catlogId;
        result = 31 * result + equipId;
        result = 31 * result + (catlogType != null ? catlogType.hashCode() : 0);
        result = 31 * result + (equipDesc != null ? equipDesc.hashCode() : 0);
        result = 31 * result + (equipPrice != null ? equipPrice.hashCode() : 0);
        return result;
    }
}
