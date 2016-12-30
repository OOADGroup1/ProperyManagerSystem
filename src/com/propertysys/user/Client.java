package com.propertysys.user;

import com.propertysys.bean.EquipItemBean;
import com.propertysys.operation.EquipItemOperator;
import com.propertysys.operation.SpareItemOperator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Sunny on 16/12/28.
 */
public class Client {

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
        String hql = "";
        List<EquipItemBean> list = equipItemOperator.queryAll();
        for(Iterator iter = list.iterator(); iter.hasNext();) {
            EquipItemBean equipItemBean = (EquipItemBean) iter.next();
            System.out.println("id: " + equipItemBean.getEquipSeriesId() +
                    " status: " + equipItemBean.getEquipStatus());
        }

    }

    /**
     * view all the spares in the company
     */
    private void viewAllSpares(){
        // TODO
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


}
