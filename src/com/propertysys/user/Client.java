package com.propertysys.user;

import com.propertysys.bean.EquipItemBean;
import com.propertysys.bean.SpareItemBean;
import com.propertysys.operation.EquipItemOperator;
import com.propertysys.operation.SpareItemOperator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Sunny on 16/12/28.
 */
public class Client {

    private final int IDLE = 1;
    private final int OCCUPY = 0;
    private EquipItemOperator equipItemOperator;
    private SpareItemOperator spareItemOperator;

    public Client(){
        equipItemOperator = new EquipItemOperator();
        spareItemOperator = new SpareItemOperator();
    }
    /**
     * view all the equipments in the company
     */
    private void viewAllEquips(){
        List equipInfo = equipItemOperator.getAllEquipInfo();
        for(Iterator iter = equipInfo.iterator(); iter.hasNext();){
            EquipItemBean equip = (EquipItemBean) iter.next();
            System.out.println("equipSeriesId = " + equip.getEquipSeriesId() +
                    " EquipStatus = " + getStatus(equip.getEquipStatus()) +
                    " CatlogType = " + equip.getCatlogType() +
                    " desc = " + equip.getEquipDesc() +
                    " price = " + equip.getEquipPrice());
        }
    }

    /**
     * view all the spares in the company
     */
    private void viewAllSpares(){
        List spareInfo = spareItemOperator.getAllSpareInfo();
        for(Iterator iter = spareInfo.iterator(); iter.hasNext();){
            SpareItemBean spare= (SpareItemBean) iter.next();
            System.out.println("spareSeriesId=" + spare.getSpareSeriesId() +
                    " spareStatus=" + getStatus(spare.getSpareStatus()) +
                    " CatlogType=" + spare.getCatlogType() +
                    " desc=" + spare.getSpareDesc() +
                    " price=" + spare.getSparePrice());
        }
    }

    /**
     * view all the equipments that a employee has by this employee's Id
     * @param employeeId
     */
    private void viewAllRentEquipsByEmployeeId(int employeeId){
        // TODO
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
