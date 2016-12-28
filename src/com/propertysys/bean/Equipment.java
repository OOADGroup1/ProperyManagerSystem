package com.propertysys.bean;

/**
 * Created by Sunny on 16/12/28.
 */
public class Equipment {
    private int catlogId;
    private int equipId;
    private String catlogType;
    private String equipDesc;
    private Double equipPrice;

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

    public String getCatlogType() {
        return catlogType;
    }

    public void setCatlogType(String catlogType) {
        this.catlogType = catlogType;
    }

    public String getEquipDesc() {
        return equipDesc;
    }

    public void setEquipDesc(String equipDesc) {
        this.equipDesc = equipDesc;
    }

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

        Equipment equipment = (Equipment) o;

        if (catlogId != equipment.catlogId) return false;
        if (equipId != equipment.equipId) return false;
        if (catlogType != null ? !catlogType.equals(equipment.catlogType) : equipment.catlogType != null) return false;
        if (equipDesc != null ? !equipDesc.equals(equipment.equipDesc) : equipment.equipDesc != null) return false;
        if (equipPrice != null ? !equipPrice.equals(equipment.equipPrice) : equipment.equipPrice != null) return false;

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
