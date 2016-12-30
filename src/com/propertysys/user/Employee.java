package com.propertysys.user;

import com.propertysys.bean.*;
import com.propertysys.operation.*;

import javax.rmi.CORBA.Tie;
import java.sql.Timestamp;

/**
 * Created by Sunny on 16/12/28.
 */
public class Employee {

    private final int IDLE = 1;
    private final int OCCUPY = 0;
    private final String BORROW = "borrow";
    private final String RETURN = "return";
    private EmployeeBean employeeBean;
    private EquipItemOperator equipItemOperator;
    private EquipRentRecordOperator equipRentRecordOperator;
    private SpareItemOperator spareItemOperator;
    private SpareRentRecordOperator spareRentRecordOperator;
    private InstallRecordOperator installRecordOperator;

    public Employee(EmployeeBean employeeBean){
        this.employeeBean = employeeBean;
        equipItemOperator = new EquipItemOperator();
        equipRentRecordOperator = new EquipRentRecordOperator();
        spareItemOperator = new SpareItemOperator();
        spareRentRecordOperator = new SpareRentRecordOperator();
        installRecordOperator = new InstallRecordOperator();
    }

    /**
     * install the spare on equipment
     * @param equipSeries Series num of the equipment
     * @param spareSeries Series num of the spare
     */
    public void install(int equipSeries, int spareSeries){
        InstallRecordBean installRecordBean = new InstallRecordBean();
        installRecordBean.setEquipSeriesId(equipSeries);
        installRecordBean.setSpareSeriesId(spareSeries);
        installRecordBean.setInstallDate(new Timestamp(System.currentTimeMillis()));
        installRecordOperator.insert(installRecordBean);
    }

    /**
     * rent equipment
     * @param equipId Id of the equipment that needs to be rent
     * @param method rent methos: borrow or return
     */
    public void rentEquip(int equipId, String method){
        int status;
        if ((status = getNextItemStatus(method)) == -1)
            return;
        // modify equipment status
        EquipItemBean equipItemBean = equipItemOperator.queryById(equipId);
        equipItemBean.setEquipStatus(status);
        equipItemOperator.update(equipItemBean);
        // add record
        EquipRentRecordBean equipRentRecordBean = new EquipRentRecordBean();
        equipRentRecordBean.setEmployeeId(employeeBean.getEmployeeId());
        equipRentRecordBean.setEquipSeriesId(equipItemBean.getEquipSeriesId());
        equipRentRecordBean.setRentAction(method);
        equipRentRecordBean.setRentDate(new Timestamp(System.currentTimeMillis()));
        equipRentRecordOperator.insert(equipRentRecordBean);
    }

    /**
     * rent a list of equipments
     * @param equipIds  Id of the equipment that needs to be rent
     * @param method rent method: borrow or return
     */
    public void rentEquips(int[] equipIds, String method){
        for (int equipId:
                equipIds) {
            rentEquip(equipId, method);
        }
    }

    /**
     * rent spare
     * @param spareId Id of the spare that needs to be borrowed
     * @param method rent method: borrow or return
     */
    public void rentSpare(int spareId, String method){
        int status;
        if ((status = getNextItemStatus(method)) == -1)
            return;
        // modify spare status
        SpareItemBean spareItemBean = spareItemOperator.queryById(spareId);
        spareItemBean.setSpareStatus(status);
        spareItemOperator.update(spareItemBean);
        // add borrow record
        SpareRentRecordBean spareRentRecordBean = new SpareRentRecordBean();
        spareRentRecordBean.setEmployeeId(employeeBean.getEmployeeId());
        spareRentRecordBean.setSpareSeriesId(spareItemBean.getSpareSeriesId());
        spareRentRecordBean.setRentAction(method);
        spareRentRecordBean.setRentTime(new Timestamp(System.currentTimeMillis()));
        spareRentRecordOperator.insert(spareRentRecordBean);
    }

    /**
     * borrow a list of spares
     * @param spareIds
     * @param method rent method: borrow or return
     */
    public void rentSpares(int[] spareIds, String method){
        for (int spareId :
                spareIds) {
            rentSpare(spareId,method);
        }
    }

    private int getNextItemStatus(String method){
        if (method.equals(BORROW)){
            return OCCUPY;
        } else if (method.equals(RETURN)){
            return IDLE;
        }
        return -1;
    }

}
