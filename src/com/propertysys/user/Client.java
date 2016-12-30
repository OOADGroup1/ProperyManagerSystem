package com.propertysys.user;

import com.propertysys.bean.EquipItemBean;
import com.propertysys.bean.SpareItemBean;
import com.propertysys.bean.SpareRentRecordBean;
import com.propertysys.operation.EquipItemOperator;
import com.propertysys.operation.EquipRentRecordOperator;
import com.propertysys.operation.SpareItemOperator;
import com.propertysys.operation.SpareRentRecordOperator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Sunny on 16/12/28.
 */
public class Client {

    private final int IDLE = 1;
    private final int OCCUPY = 0;
    private EquipItemOperator equipItemOperator;
    private EquipRentRecordOperator equipRentRecordOperator;
    private SpareItemOperator spareItemOperator;
    private SpareRentRecordOperator spareRentRecordOperator;

    public Client(){
        equipItemOperator = new EquipItemOperator();
        equipRentRecordOperator = new EquipRentRecordOperator();
        spareItemOperator = new SpareItemOperator();
        spareRentRecordOperator = new SpareRentRecordOperator();
    }
    /**
     * view all the equipments in the company
     */
    private void viewAllEquips(){
        List equipInfo = equipItemOperator.getAllEquipInfo();
        for(Iterator iter = equipInfo.iterator(); iter.hasNext();){
            Object[] equip = (Object[]) iter.next();
            System.out.println("equipSeriesId=" + (int) equip[0] +
                    " EquipStatus=" + getStatus((Integer)equip[1])  +
                    " CatlogType=" + (String) equip[2] +
                    " desc=" + (String) equip[3] +
                    " price=" + (Double) equip[4]);
        }
    }

    /**
     * view all the spares in the company
     */
    private void viewAllSpares(){
        List spareInfo = spareItemOperator.getAllSpareInfo();
        for(Iterator iter = spareInfo.iterator(); iter.hasNext();){
            Object[] spare = (Object[]) iter.next();
            System.out.println("spareSeriesId=" + (int) spare[0] +
                    " SpareStatus=" + getStatus((Integer)spare[1])  +
                    " CatlogType=" + (String) spare[2] +
                    " desc=" + (String) spare[3] +
                    " price=" + (Double) spare[4]);
        }
    }

    /**
     * view all the equipments that a employee has by this employee's Id
     * @param employeeId
     */
    private void viewAllRentEquipsByEmployeeId(int employeeId){
//        String hql = "select e.equipSeriesId from EquipRentRecordBean e " +
//                "wherer e.employeeId = ?";
//        equipRentRecordOperator.queryAll();
    }

    /**
     * view all the spares that a employee has by this employee's Id
     * @param employeeId
     */
    private void viewAllRentSparesByEmployeeId(int employeeId){
        // TODO
    }

    /**
     * view the equipment's life cycle(buy, borrow, return, discard) by EquipId
     * @param equipId
     */
    private void viewEquipLifeCycleById(int equipId){
        // TODO
    }

    /**
     * view the equipment's life cycle(buy, borrow, return, discard) by EquipId
     * @param spareId
     */
    private void viewSpareLifeCycleById(int spareId){
        // TODO
    }

    /**
     * view the equipments's installation record of the spares By EquipId
     * @param equipId
     */
    private void viewEquipInstallRecoById(int equipId){
        // TODO
    }

    private String getStatus(int stauts){
        if (stauts == IDLE){
            return "idle";
        } else if (stauts == OCCUPY){
            return "Occupied";
        }
        return null;
    }

}
