package com.propertysys.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sunny on 16/12/30.
 */
@Entity
@Table(name = "SpareRentRecord", schema = "prtydb", catalog = "")
public class SpareRentRecordBean {
    private int employeeId;
    private int spareSeriesId;
    private Timestamp rentTime;
    private String rentAction;
    private int spareRentRecId;

    @Basic
    @Column(name = "employee_id", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "spare_series_id", nullable = false)
    public int getSpareSeriesId() {
        return spareSeriesId;
    }

    public void setSpareSeriesId(int spareSeriesId) {
        this.spareSeriesId = spareSeriesId;
    }

    @Basic
    @Column(name = "rent_time", nullable = false)
    public Timestamp getRentTime() {
        return rentTime;
    }

    public void setRentTime(Timestamp rentTime) {
        this.rentTime = rentTime;
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
    @Column(name = "spare_rent_rec_id", nullable = false)
    public int getSpareRentRecId() {
        return spareRentRecId;
    }

    public void setSpareRentRecId(int spareRentRecId) {
        this.spareRentRecId = spareRentRecId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpareRentRecordBean that = (SpareRentRecordBean) o;

        if (employeeId != that.employeeId) return false;
        if (spareSeriesId != that.spareSeriesId) return false;
        if (spareRentRecId != that.spareRentRecId) return false;
        if (rentTime != null ? !rentTime.equals(that.rentTime) : that.rentTime != null) return false;
        if (rentAction != null ? !rentAction.equals(that.rentAction) : that.rentAction != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + spareSeriesId;
        result = 31 * result + (rentTime != null ? rentTime.hashCode() : 0);
        result = 31 * result + (rentAction != null ? rentAction.hashCode() : 0);
        result = 31 * result + spareRentRecId;
        return result;
    }
}
