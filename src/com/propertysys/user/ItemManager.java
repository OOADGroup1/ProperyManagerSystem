package com.propertysys.user;

import com.propertysys.bean.EquipItemBean;
import com.propertysys.bean.SpareItemBean;
import com.propertysys.operation.EquipItemOperator;
import com.propertysys.operation.SpareItemOperator;
import com.sun.tools.javac.util.List;

/**
 * Created by Sunny on 16/12/28.
 */
public class ItemManager {

    private EquipItemOperator equipItemOperator;
    private SpareItemOperator spareItemOperator;

    public ItemManager(){
        equipItemOperator = new EquipItemOperator();
        spareItemOperator = new SpareItemOperator();
    }
    /**
     * buy equipment
     * @param equipItem
     */
    private void buyEquipItem(EquipItemBean equipItem){
        equipItemOperator.insert(equipItem);
    }

    /**
     * buy a list of equipments
     * @param equipItemList
     */
    private void buyEquipItems(List<EquipItemBean> equipItemList){
        equipItemOperator.insertAll(equipItemList);
    }

    /**
     * but spare
     * @param spareItem
     */
    private void buySpareItem(SpareItemBean spareItem){
        spareItemOperator.insert(spareItem);
    }

    /**
     * buy a list of spares
     * @param spareItemList
     */
    private void buySpareItems(List<SpareItemBean> spareItemList){
        spareItemOperator.insertAll(spareItemList);
    }

    /**
     * discard the equipment by equipId
     * @param equipId
     */
    private void discardEquipById(int equipId){
        equipItemOperator.delete(equipId);
    }

    /**
     * discard the equipment by equipItem
     * @param equipItem
     */
    private void discardEquip(EquipItemBean equipItem){
        equipItemOperator.delete(equipItem);
    }

    /**
     * discard the spare by spareId
     * @param spareId
     */
    private void discardSpareById(int spareId){
        spareItemOperator.delete(spareId);
    }

    /**
     * discard the spare by spareItem
     * @param spareItem
     */
    private void dicardSpare(SpareItemBean spareItem){
        spareItemOperator.delete(spareItem);
    }


}
