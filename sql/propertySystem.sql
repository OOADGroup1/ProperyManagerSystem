/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/12/30 22:55:50                          */
/*==============================================================*/


drop table if exists Catlog;

drop table if exists Employee;

drop table if exists EquipItem;

drop table if exists EquipManageRecord;

drop table if exists EquipRentRecord;

drop table if exists Equipment;

drop table if exists InstallRecord;

drop table if exists ItemManager;

drop table if exists Spare;

drop table if exists SpareItem;

drop table if exists SpareManageRecord;

drop table if exists SpareRentRecord;

/*==============================================================*/
/* Table: Catlog                                                */
/*==============================================================*/
create table Catlog
(
   catlog_id            int not null auto_increment,
   catlog_type          varchar(50),
   primary key (catlog_id)
);

/*==============================================================*/
/* Table: Employee                                              */
/*==============================================================*/
create table Employee
(
   employee_id          int not null auto_increment,
   employee_name        varchar(50),
   primary key (employee_id)
);

/*==============================================================*/
/* Table: EquipItem                                             */
/*==============================================================*/
create table EquipItem
(
   equip_series_id      int not null auto_increment,
   equip_id             int not null,
   equip_status         int,
   primary key (equip_series_id)
);

/*==============================================================*/
/* Table: EquipManageRecord                                     */
/*==============================================================*/
create table EquipManageRecord
(
   equip_series_id      int not null,
   manager_id           int not null,
   manage_date          timestamp,
   manage_type          varchar(50),
   equip_mng_rec_id     int not null auto_increment,
   primary key (equip_mng_rec_id)
);

/*==============================================================*/
/* Table: EquipRentRecord                                       */
/*==============================================================*/
create table EquipRentRecord
(
   employee_id          int not null,
   equip_series_id      int not null,
   rent_date            timestamp,
   rent_action          varchar(50),
   equip_rent_rec_id    int not null auto_increment,
   primary key (equip_rent_rec_id)
);

/*==============================================================*/
/* Table: Equipment                                             */
/*==============================================================*/
create table Equipment
(
   catlog_id            int not null,
   equip_id             int not null auto_increment,
   catlog_type          varchar(50),
   equip_desc           text,
   equip_price          float,
   primary key (equip_id)
);

/*==============================================================*/
/* Table: InstallRecord                                         */
/*==============================================================*/
create table InstallRecord
(
   equip_series_id      int not null,
   spare_series_id      int not null,
   install_date         timestamp,
   install_rec_id       int not null auto_increment,
   primary key (install_rec_id)
);

/*==============================================================*/
/* Table: ItemManager                                           */
/*==============================================================*/
create table ItemManager
(
   manager_id           int not null auto_increment,
   primary key (manager_id)
);

/*==============================================================*/
/* Table: Spare                                                 */
/*==============================================================*/
create table Spare
(
   catlog_id            int not null,
   spare_id             int not null auto_increment,
   catlog_type          varchar(50),
   spare_desc           text,
   spare_price          float,
   primary key (spare_id)
);

/*==============================================================*/
/* Table: SpareItem                                             */
/*==============================================================*/
create table SpareItem
(
   spare_series_id      int not null auto_increment,
   spare_id             int not null,
   spare_status         int,
   primary key (spare_series_id)
);

/*==============================================================*/
/* Table: SpareManageRecord                                     */
/*==============================================================*/
create table SpareManageRecord
(
   manager_id           int not null,
   spare_series_id      int not null,
   manage_date          timestamp,
   manage_type          varchar(50),
   spare_mng_rec_id     int not null auto_increment,
   primary key (spare_mng_rec_id)
);

/*==============================================================*/
/* Table: SpareRentRecord                                       */
/*==============================================================*/
create table SpareRentRecord
(
   employee_id          int not null,
   spare_series_id      int not null,
   rent_time            timestamp,
   rent_action          varchar(50),
   spare_rent_rec_id    int not null auto_increment,
   primary key (spare_rent_rec_id)
);

alter table EquipItem add constraint FK_equip_describe foreign key (equip_id)
      references Equipment (equip_id) on delete restrict on update restrict;

alter table EquipManageRecord add constraint FK_EquipManageRecord foreign key (equip_series_id)
      references EquipItem (equip_series_id) on delete restrict on update restrict;

alter table EquipManageRecord add constraint FK_EquipManageRecord2 foreign key (manager_id)
      references ItemManager (manager_id) on delete restrict on update restrict;

alter table EquipRentRecord add constraint FK_EquipRentRecord foreign key (employee_id)
      references Employee (employee_id) on delete restrict on update restrict;

alter table EquipRentRecord add constraint FK_EquipRentRecord2 foreign key (equip_series_id)
      references EquipItem (equip_series_id) on delete restrict on update restrict;

alter table Equipment add constraint FK_contain_equip foreign key (catlog_id)
      references Catlog (catlog_id) on delete restrict on update restrict;

alter table InstallRecord add constraint FK_InstallRecord foreign key (equip_series_id)
      references EquipItem (equip_series_id) on delete restrict on update restrict;

alter table InstallRecord add constraint FK_InstallRecord2 foreign key (spare_series_id)
      references SpareItem (spare_series_id) on delete restrict on update restrict;

alter table Spare add constraint FK_contain_spare foreign key (catlog_id)
      references Catlog (catlog_id) on delete restrict on update restrict;

alter table SpareItem add constraint FK_spare_describe foreign key (spare_id)
      references Spare (spare_id) on delete restrict on update restrict;

alter table SpareManageRecord add constraint FK_SpareManageRecord foreign key (manager_id)
      references ItemManager (manager_id) on delete restrict on update restrict;

alter table SpareManageRecord add constraint FK_SpareManageRecord2 foreign key (spare_series_id)
      references SpareItem (spare_series_id) on delete restrict on update restrict;

alter table SpareRentRecord add constraint FK_SpareRentRecord foreign key (employee_id)
      references Employee (employee_id) on delete restrict on update restrict;

alter table SpareRentRecord add constraint FK_SpareRentRecord2 foreign key (spare_series_id)
      references SpareItem (spare_series_id) on delete restrict on update restrict;

