package com.propertysys.user;

import com.propertysys.bean.EquipItemBean;
import com.propertysys.bean.SpareItemBean;
import com.propertysys.bean.SpareRentRecordBean;
import com.propertysys.operation.EquipItemOperator;
import com.propertysys.operation.EquipRentRecordOperator;
import com.propertysys.operation.SpareItemOperator;
import com.propertysys.operation.SpareRentRecordOperator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sunny on 16/12/28.
 */
public class Client {

    private final int IDLE = 0;
    private final int OCCUPY = 1;
    private final String BORROW = "borrow";
    private final String RETURN = "return";
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
    public void viewAllEquips(){
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
    public void viewAllSpares(){
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
    public void viewAllRentEquipsByEmployeeId(int employeeId){// 0
        String hql = "select r.equipSeriesId, r.rentAction " +
                "from EquipRentRecordBean r, EquipItemBean e " +
                "where e.equipStatus = ? and e.equipSeriesId = r.equipSeriesId " +
                "and r.employeeId = ?";
        List equips = equipRentRecordOperator.queryAll(hql, new Object[] {OCCUPY, employeeId});
        System.out.println("Employee(EmployeeId: " + employeeId + ") has equipments:");
        viewHasList(equips);
    }

    /**
     * view all the spares that a employee has by this employee's Id
     * @param employeeId
     */
    public void viewAllRentSparesByEmployeeId(int employeeId){
        String hql = "select r.spareSeriesId, r.rentAction " +
                "from SpareRentRecordBean r, SpareItemBean s " +
                "where s.spareStatus = ? and s.spareSeriesId = r.spareSeriesId " +
                "and r.employeeId = ?";
        List spares = spareRentRecordOperator.queryAll(hql, new Object[] {OCCUPY, employeeId});
        System.out.println("Employee(EmployeeId: " + employeeId + ") has spares:");
        viewHasList(spares);
    }

    /**
     * view the equipment's life cycle(buy, borrow, return, discard) by EquipId
     * @param equipId
     */
    public void viewEquipLifeCycleById(int equipId){
        // TODO
    }

    /**
     * view the equipment's life cycle(buy, borrow, return, discard) by EquipId
     * @param spareId
     */
    public void viewSpareLifeCycleById(int spareId){
        // TODO
    }

    /**
     * view the equipments's installation record of the spares By EquipId
     * @param equipId
     */
    public void viewEquipInstallRecoById(int equipId){
        // TODO
    }

    /**
     * get the status name
     * @param status status symbol
     * @return status name
     */
    private String getStatus(int status){
        if (status == IDLE){
            return "idle";
        } else if (status == OCCUPY){
            return "Occupied";
        }
        return null;
    }

    /**
     * From items list, pick the items that only have "Borrow" status
     * @param items item list
     */
    private void viewHasList(List items){
        List<Integer> returnedList = new ArrayList<>();
        for(Iterator iter = items.iterator(); iter.hasNext();){
            Object[] info = (Object[]) iter.next();
            if (((String)info[1]).equals(RETURN)){
                returnedList.add((int)info[0]);
                iter.remove();
            }
        }
        for(Iterator iter = items.iterator(); iter.hasNext();){ // remove all the item that has return state
            Object[] info = (Object[]) iter.next();
            if (hasContains(returnedList, (int)info[0])){
                iter.remove();
            }
        }
        for(Iterator iter = items.iterator(); iter.hasNext();){ // print the hasList
            Object[] info = (Object[]) iter.next();
            System.out.println("seriesId: " + (int)info[0]);
        }
    }

    /**
     * check whether key is in the list
     * @param list
     * @param key
     * @return
     */
    private boolean hasContains(List<Integer> list, int key){
        for (Integer i :
                list) {
            if (i == key)
                return true;
        }
        return false;
    }

}
