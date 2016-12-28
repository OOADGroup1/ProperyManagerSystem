package com.propertysys.bean;

/**
 * Created by Sunny on 16/12/28.
 */
public class ItemManager {
    private int managerId;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemManager that = (ItemManager) o;

        if (managerId != that.managerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return managerId;
    }
}
