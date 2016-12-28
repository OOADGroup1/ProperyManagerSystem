package com.propertysys.bean;

/**
 * Created by Sunny on 16/12/28.
 */
public class EquipItem {
    private int equipSeriesId;
    private int catlogId;
    private int equipId;
    private Integer equipStatus;

    public int getEquipSeriesId() {
        return equipSeriesId;
    }

    public void setEquipSeriesId(int equipSeriesId) {
        this.equipSeriesId = equipSeriesId;
    }

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

    public Integer getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(Integer equipStatus) {
        this.equipStatus = equipStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipItem equipItem = (EquipItem) o;

        if (equipSeriesId != equipItem.equipSeriesId) return false;
        if (catlogId != equipItem.catlogId) return false;
        if (equipId != equipItem.equipId) return false;
        if (equipStatus != null ? !equipStatus.equals(equipItem.equipStatus) : equipItem.equipStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipSeriesId;
        result = 31 * result + catlogId;
        result = 31 * result + equipId;
        result = 31 * result + (equipStatus != null ? equipStatus.hashCode() : 0);
        return result;
    }
}
