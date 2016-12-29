package com.propertysys.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by shenying on 16/12/29.
 */
@Entity
@Table(name = "ItemManager", schema = "prtydb", catalog = "")
public class ItemManagerBean {
    private int managerId;

    @Id
    @Column(name = "manager_id", nullable = false)
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

        ItemManagerBean that = (ItemManagerBean) o;

        if (managerId != that.managerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return managerId;
    }
}
