package com.propertysys.user;

import com.propertysys.bean.*;
import com.propertysys.operation.EquipItemOperator;
import com.propertysys.operation.EquipManageRecordOperator;
import com.propertysys.operation.SpareItemOperator;
import com.propertysys.operation.SpareManageRecordOperator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.sql.Timestamp;

/**
 * Created by Sunny on 16/12/28.
 */
public class ItemManager {

    private final String BUY = "buy";
    private final String DISCARD = "discard";
    private ItemManagerBean itemManagerBean;
    private EquipItemOperator equipItemOperator;
    private EquipManageRecordOperator equipManageRecordOperator;
    private SpareItemOperator spareItemOperator;
    private SpareManageRecordOperator spareManageRecordOperator;

    public ItemManager(ItemManagerBean itemManagerBean){
        this.itemManagerBean = itemManagerBean;
        equipItemOperator = new EquipItemOperator();
        equipManageRecordOperator = new EquipManageRecordOperator();
        spareItemOperator = new SpareItemOperator();
        spareManageRecordOperator = new SpareManageRecordOperator();
    }
    /**
     * buy equipment
     * @param equipItem
     */
    private void buyEquipItem(EquipItemBean equipItem){
        // add equipItem
        equipItemOperator.insert(equipItem);
        // add equipManageRecord
        EquipManageRecordBean equipManageRecordBean = new EquipManageRecordBean();
        equipManageRecordBean.setEquipSeriesId(equipItem.getEquipSeriesId());
        equipManageRecordBean.setManagerId(itemManagerBean.getManagerId());
        equipManageRecordBean.setManageDate(new Timestamp(System.currentTimeMillis()));
        equipManageRecordBean.setManageType(BUY);
        equipManageRecordOperator.insert(equipManageRecordBean);
    }

    /**
     * buy a list of equipments
     * @param equipItemList
     */
    private void buyEquipItems(List<EquipItemBean> equipItemList){
        // add equipment list
        equipItemOperator.insertAll(equipItemList);
        // add record list
        List<EquipManageRecordBean> buyList = new ArrayList<EquipManageRecordBean>();
        for(Iterator iter = equipItemList.iterator(); iter.hasNext();) {
            EquipItemBean equipItemBean = (EquipItemBean) iter.next();
            EquipManageRecordBean equipManageRecordBean = new EquipManageRecordBean();
            equipManageRecordBean.setEquipSeriesId(equipItemBean.getEquipSeriesId());
            equipManageRecordBean.setManagerId(itemManagerBean.getManagerId());
            equipManageRecordBean.setManageDate(new Timestamp(System.currentTimeMillis()));
            equipManageRecordBean.setManageType(BUY);
            buyList.add(equipManageRecordBean);
        }
        equipManageRecordOperator.insertAll(buyList);
    }

    /**
     * but spare
     * @param spareItem
     */
    private void buySpareItem(SpareItemBean spareItem){
        // add spareItem
        spareItemOperator.insert(spareItem);
        // add SpareManageRecord
        SpareManageRecordBean spareManageRecordBean = new SpareManageRecordBean();
        spareManageRecordBean.setSpareSeriesId(spareItem.getSpareSeriesId());
        spareManageRecordBean.setManagerId(itemManagerBean.getManagerId());
        spareManageRecordBean.setManageDate(new Timestamp(System.currentTimeMillis()));
        spareManageRecordBean.setManageType(BUY);
        spareManageRecordOperator.insert(spareManageRecordBean);
    }

    /**
     * buy a list of spares
     * @param spareItemList
     */
    private void buySpareItems(List<SpareItemBean> spareItemList){
        // add spare list
        spareItemOperator.insertAll(spareItemList);
        // add record list
        List<SpareManageRecordBean> buyList = new ArrayList<SpareManageRecordBean>();
        for(Iterator iter = spareItemList.iterator(); iter.hasNext();) {
            SpareItemBean spareItemBean = (SpareItemBean) iter.next();
            SpareManageRecordBean spareManageRecordBean = new SpareManageRecordBean();
            spareManageRecordBean.setSpareSeriesId(spareItemBean.getSpareSeriesId());
            spareManageRecordBean.setManagerId(itemManagerBean.getManagerId());
            spareManageRecordBean.setManageDate(new Timestamp(System.currentTimeMillis()));
            spareManageRecordBean.setManageType(BUY);
            buyList.add(spareManageRecordBean);
        }
        spareManageRecordOperator.insertAll(buyList);
    }

    /**
     * discard the equipment by equipId
     * @param equipId
     */
    private void discardEquipById(int equipId){
        // delete equip from equipItem table
        equipItemOperator.delete(equipId);
        // add discard record
        EquipManageRecordBean equipManageRecordBean = new EquipManageRecordBean();
        equipManageRecordBean.setEquipSeriesId(equipId);
        equipManageRecordBean.setManagerId(itemManagerBean.getManagerId());
        equipManageRecordBean.setManageDate(new Timestamp(System.currentTimeMillis()));
        equipManageRecordBean.setManageType(DISCARD);
        equipManageRecordOperator.insert(equipManageRecordBean);
    }

    /**
     * discard the equipment by equipItem
     * @param equipItem
     */
    private void discardEquip(EquipItemBean equipItem){
        // delete equip from equipItem table
        equipItemOperator.delete(equipItem);
        // add discard record
        EquipManageRecordBean equipManageRecordBean = new EquipManageRecordBean();
        equipManageRecordBean.setEquipSeriesId(equipItem.getEquipSeriesId());
        equipManageRecordBean.setManagerId(itemManagerBean.getManagerId());
        equipManageRecordBean.setManageDate(new Timestamp(System.currentTimeMillis()));
        equipManageRecordBean.setManageType(DISCARD);
        equipManageRecordOperator.insert(equipManageRecordBean);
    }

    /**
     * discard the spare by spareId
     * @param spareId
     */
    private void discardSpareById(int spareId){
        // delete spare from spareItem table
        spareItemOperator.delete(spareId);
        // add discard record
        SpareManageRecordBean spareManageRecordBean = new SpareManageRecordBean();
        spareManageRecordBean.setSpareSeriesId(spareId);
        spareManageRecordBean.setManagerId(itemManagerBean.getManagerId());
        spareManageRecordBean.setManageDate(new Timestamp(System.currentTimeMillis()));
        spareManageRecordBean.setManageType(DISCARD);
        spareManageRecordOperator.insert(spareManageRecordBean);
    }

    /**git
     * discard the spare by spareItem
     * @param spareItem
     */
    private void dicardSpare(SpareItemBean spareItem){
        // delete spare from spareItem table
        spareItemOperator.delete(spareItem);
        // add discard record
        SpareManageRecordBean spareManageRecordBean = new SpareManageRecordBean();
        spareManageRecordBean.setSpareSeriesId(spareItem.getSpareSeriesId());
        spareManageRecordBean.setManagerId(itemManagerBean.getManagerId());
        spareManageRecordBean.setManageDate(new Timestamp(System.currentTimeMillis()));
        spareManageRecordBean.setManageType(DISCARD);
        spareManageRecordOperator.insert(spareManageRecordBean);
    }


}
