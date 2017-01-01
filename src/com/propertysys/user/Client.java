package com.propertysys.user;

import com.propertysys.bean.*;
import com.propertysys.operation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sunny on 16/12/28.
 */
public class Client {

    private final int IDLE = 0;
    private final int OCCUPY = 1;
    private final int DISCARD = 2;
    private final String BORROW = "borrow";
    private final String RETURN = "return";
    private EquipItemOperator equipItemOperator;
    private EquipRentRecordOperator equipRentRecordOperator;
    private EquipManageRecordOperator equipManageRecordOperator;
    private SpareItemOperator spareItemOperator;
    private SpareRentRecordOperator spareRentRecordOperator;
    private SpareManageRecordOperator spareManageRecordOperator;
    private InstallRecordOperator installRecordOperator;

    public Client(){
        equipItemOperator = new EquipItemOperator();
        equipRentRecordOperator = new EquipRentRecordOperator();
        equipManageRecordOperator = new EquipManageRecordOperator();
        spareItemOperator = new SpareItemOperator();
        spareRentRecordOperator = new SpareRentRecordOperator();
        spareManageRecordOperator = new SpareManageRecordOperator();
        installRecordOperator = new InstallRecordOperator();
    }
    /**
     * view all the equipments in the company
     */
    public List viewAllEquips(){
        List equipInfo = equipItemOperator.getAllEquipInfo();
        for(Iterator iter = equipInfo.iterator(); iter.hasNext();){
            Object[] equip = (Object[]) iter.next();
            System.out.println("equipSeriesId=" + (int) equip[0] +
                    " EquipStatus=" + getStatus((Integer)equip[1])  +
                    " CatlogType=" + (String) equip[2] +
                    " desc=" + (String) equip[3] +
                    " price=" + (Double) equip[4]);
        }
        return equipInfo;
    }

    /**
     * view all the equipments in the company by keyword
     * @param keyword
     */
    public List viewAllEquips(String keyword){
        List equipInfo = equipItemOperator.getAllEquipInfo(keyword);
        for(Iterator iter = equipInfo.iterator(); iter.hasNext();){
            Object[] equip = (Object[]) iter.next();
            System.out.println("equipSeriesId=" + (int) equip[0] +
                    " EquipStatus=" + getStatus((Integer)equip[1])  +
                    " CatlogType=" + (String) equip[2] +
                    " desc=" + (String) equip[3] +
                    " price=" + (Double) equip[4]);
        }
        return equipInfo;
    }

    /**
     * view all the spares in the company
     */
    public List viewAllSpares(){
        List spareInfo = spareItemOperator.getAllSpareInfo();
        for(Iterator iter = spareInfo.iterator(); iter.hasNext();){
            Object[] spare = (Object[]) iter.next();
            System.out.println("spareSeriesId=" + (int) spare[0] +
                    " SpareStatus=" + getStatus((Integer)spare[1])  +
                    " CatlogType=" + (String) spare[2] +
                    " desc=" + (String) spare[3] +
                    " price=" + (Double) spare[4]);
        }
        return spareInfo;
    }

    /**
     * view all the spares in the company by keyword
     * @param keyword
     */
    public List viewAllSpares(String keyword){
        List spareInfo = spareItemOperator.getAllSpareInfo(keyword);
        for(Iterator iter = spareInfo.iterator(); iter.hasNext();){
            Object[] spare = (Object[]) iter.next();
            System.out.println("spareSeriesId=" + (int) spare[0] +
                    " SpareStatus=" + getStatus((Integer)spare[1])  +
                    " CatlogType=" + (String) spare[2] +
                    " desc=" + (String) spare[3] +
                    " price=" + (Double) spare[4]);
        }
        return spareInfo;
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
    public int viewEquipLifeCycleById(int equipId){
        String manageHql = "from EquipManageRecordBean m where m.equipSeriesId = ? " +
                "order by m.manageDate ASC";
        List<EquipManageRecordBean> manageList = equipManageRecordOperator.queryAll(manageHql, equipId);
        String rentHql = "from EquipRentRecordBean r where r.equipSeriesId = ? " +
                "order by r.rentDate ASC";
        List<EquipRentRecordBean> rentList = equipRentRecordOperator.queryAll(rentHql, equipId);
        System.out.println("The life cycle of equipment(equipSeriesId: "+ equipId +") is:");
        viewEquipLifeCycle(manageList, rentList);
        return (manageList.size()+rentList.size());
    }

    /**
     * view the equipment's life cycle(buy, borrow, return, discard) by EquipId
     * @param spareId
     */
    public int viewSpareLifeCycleById(int spareId){
        String manageHql = "from SpareManageRecordBean m where m.spareSeriesId = ? " +
                "order by m.manageDate ASC";
        List<SpareManageRecordBean> manageList = spareManageRecordOperator.queryAll(manageHql, spareId);
        String rentHql = "from SpareRentRecordBean r where r.spareSeriesId = ? " +
                "order by r.rentTime ASC";
        List<SpareRentRecordBean> rentList = spareRentRecordOperator.queryAll(rentHql, spareId);
        System.out.println("The life cycle of spare(spareSeriesId: "+ spareId +") is:");
        viewSpareLifeCycle(manageList, rentList);
        return (manageList.size()+rentList.size());
    }

    /**
     * view the equipments's installation record of the spares By EquipId
     * @param equipId
     */
    public List viewEquipInstallRecoById(int equipId){
        List<InstallRecordBean> list = installRecordOperator.viewInstallRecByEquipId(equipId);
        System.out.println("Equipment(EquipSeriesId:" + equipId + ")'s install history:");
        for (InstallRecordBean installRec:
                list) {
            System.out.println(installRec.getInstallDate() +
                    " installed Spare(SpareSeriesId: " + installRec.getSpareSeriesId() + ")");
        }
        return list;
    }

    /**
     * get the status name
     * @param status status symbol
     * @return status name
     */
    private String getStatus(int status){
        if (status == IDLE){
            return "Idle";
        } else if (status == OCCUPY){
            return "Occupied";
        } else if(status == DISCARD)
            return "Discard";
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

    /**
     * view the equipment's life cycle
     * @param manageList management record list
     * @param rentList rent record list
     */
    private void viewEquipLifeCycle(List<EquipManageRecordBean> manageList,
                                    List<EquipRentRecordBean> rentList){
        for (EquipManageRecordBean manageRec :
                manageList) {
            System.out.println(manageRec.getManageDate() + "    " + manageRec.getManageType());
        }
        for (EquipRentRecordBean rentRec:
             rentList) {
            System.out.println(rentRec.getRentDate() + "    " +
                    rentRec.getRentAction() + " by EmployeeID(" + rentRec.getEmployeeId() + ")");
        }
    }

    /**
     * view the spare's life cycle
     * @param manageList management record list
     * @param rentList rent record list
     */
    private void viewSpareLifeCycle(List<SpareManageRecordBean> manageList,
                                    List<SpareRentRecordBean> rentList){
        for (SpareManageRecordBean manageRec :
                manageList) {
            System.out.println(manageRec.getManageDate() + "    " + manageRec.getManageType());
        }
        for (SpareRentRecordBean rentRec:
                rentList) {
            System.out.println(rentRec.getRentTime() + "    " +
                    rentRec.getRentAction() + " by EmployeeID(" + rentRec.getEmployeeId() + ")");
        }
    }

}
