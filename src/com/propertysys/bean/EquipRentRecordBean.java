package com.propertysys.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sunny on 16/12/30.
 */
@Entity
@Table(name = "EquipRentRecord", schema = "prtydb", catalog = "")
public class EquipRentRecordBean {
    private int employeeId;
    private int equipSeriesId;
    private Timestamp rentDate;
    private String rentAction;
    private int equipRentRecId;

    @Basic
    @Column(name = "employee_id", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "equip_series_id", nullable = false)
    public int getEquipSeriesId() {
        return equipSeriesId;
    }

    public void setEquipSeriesId(int equipSeriesId) {
        this.equipSeriesId = equipSeriesId;
    }

    @Basic
    @Column(name = "rent_date", nullable = false)
    public Timestamp getRentDate() {
        return rentDate;
    }

    public void setRentDate(Timestamp rentDate) {
        this.rentDate = rentDate;
    }

    @Basic
    @Column(name = "rent_action", nullable = true, length = 50)
    public String getRentAction() {
        return rentAction;
    }

    public void setRentAction(String rentAction) {
        this.rentAction = rentAction;
    }

    @Id
    @Column(name = "equip_rent_rec_id", nullable = false)
    public int getEquipRentRecId() {
        return equipRentRecId;
    }

    public void setEquipRentRecId(int equipRentRecId) {
        this.equipRentRecId = equipRentRecId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipRentRecordBean that = (EquipRentRecordBean) o;

        if (employeeId != that.employeeId) return false;
        if (equipSeriesId != that.equipSeriesId) return false;
        if (equipRentRecId != that.equipRentRecId) return false;
        if (rentDate != null ? !rentDate.equals(that.rentDate) : that.rentDate != null) return false;
        if (rentAction != null ? !rentAction.equals(that.rentAction) : that.rentAction != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + equipSeriesId;
        result = 31 * result + (rentDate != null ? rentDate.hashCode() : 0);
        result = 31 * result + (rentAction != null ? rentAction.hashCode() : 0);
        result = 31 * result + equipRentRecId;
        return result;
    }
}
