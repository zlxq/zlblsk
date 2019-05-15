/*
SQLyog v10.2 
MySQL - 5.7.17-log : Database - blsk
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blsk` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blsk`;

/*Table structure for table `blsk_bill_detail` */

DROP TABLE IF EXISTS `blsk_bill_detail`;

CREATE TABLE `blsk_bill_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `BILLID` bigint(20) DEFAULT NULL COMMENT '单据ID',
  `MATERIALID` bigint(20) DEFAULT NULL COMMENT '物料ID',
  `MNO` varchar(50) DEFAULT NULL COMMENT '物料号',
  `MCODE` varchar(50) DEFAULT NULL COMMENT '物料编码',
  `MNAME` varchar(50) DEFAULT NULL COMMENT '物料名称',
  `COUNT` varchar(50) DEFAULT NULL COMMENT '请求数量',
  `UNIT` varchar(50) DEFAULT NULL COMMENT '计量单位',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK_BILL_DETAIL_REF` (`BILLID`),
  CONSTRAINT `FK_BILL_DETAIL_REF` FOREIGN KEY (`BILLID`) REFERENCES `blsk_bill_info` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据明细';

/*Data for the table `blsk_bill_detail` */

/*Table structure for table `blsk_bill_info` */

DROP TABLE IF EXISTS `blsk_bill_info`;

CREATE TABLE `blsk_bill_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `BILLNO` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `BILLNAME` varchar(50) DEFAULT NULL COMMENT '单据名称',
  `BILLTYPE` varchar(110) DEFAULT NULL COMMENT '入库单、出库单、盘点单',
  `BILL_LEVEL` varchar(110) DEFAULT NULL COMMENT '单据优先级',
  `USERID` bigint(20) DEFAULT NULL COMMENT '发起人ID',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '发起人名',
  `REQ_TIME` datetime DEFAULT NULL COMMENT '发起时间',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据对外接口表';

/*Data for the table `blsk_bill_info` */

/*Table structure for table `blsk_equip_info` */

DROP TABLE IF EXISTS `blsk_equip_info`;

CREATE TABLE `blsk_equip_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `EQUIP_NO` varchar(50) DEFAULT NULL COMMENT '设备编号',
  `EQUIP_CODE` varchar(50) DEFAULT NULL COMMENT '设备编码',
  `EQUIP_NAME` varchar(50) DEFAULT NULL COMMENT '设备名称',
  `EQUIP_TYPE` varchar(50) DEFAULT NULL COMMENT '设备类型（堆垛机、传感器）',
  `EQUIP_STATE` varchar(110) DEFAULT NULL COMMENT '设备通讯状态',
  `SORT` varchar(50) DEFAULT NULL COMMENT '排序',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备基本信息';

/*Data for the table `blsk_equip_info` */

/*Table structure for table `blsk_head_tpl` */

DROP TABLE IF EXISTS `blsk_head_tpl`;

CREATE TABLE `blsk_head_tpl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NO` varchar(50) DEFAULT NULL COMMENT '系统唯一编号',
  `CODE` varchar(50) DEFAULT NULL COMMENT '数据库对应字段名称',
  `TEXT` varchar(50) DEFAULT NULL COMMENT '界面显示的内容',
  `COMMENT` varchar(50) DEFAULT NULL COMMENT '字段描述',
  `TYPE` varchar(50) DEFAULT NULL COMMENT '字段类型',
  `ISSEARCH` varchar(50) DEFAULT NULL COMMENT '是否查询条件',
  `OPERATOR` varchar(50) DEFAULT NULL COMMENT '运算符',
  `MOUDLE` varchar(50) DEFAULT NULL COMMENT '所属模块',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '所属单位',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动态表头配置表';

/*Data for the table `blsk_head_tpl` */

/*Table structure for table `blsk_inv_io` */

DROP TABLE IF EXISTS `blsk_inv_io`;

CREATE TABLE `blsk_inv_io` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `BILLID` bigint(20) DEFAULT NULL COMMENT '单据ID',
  `BILLNO` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `IONO` varchar(50) DEFAULT NULL COMMENT '根据实际出入库情况，生产实际单号',
  `IOTYPE` varchar(110) DEFAULT NULL COMMENT '出库、入库、盘点',
  `LEVEL` varchar(110) DEFAULT NULL COMMENT '优先级',
  `EXEC_TYPE` varchar(110) DEFAULT NULL COMMENT '单据执行类型（先入先出、先进后远等）',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK_IO_BILL_REF` (`BILLID`),
  CONSTRAINT `FK_IO_BILL_REF` FOREIGN KEY (`BILLID`) REFERENCES `blsk_bill_info` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出入库、盘点单据实际业务需求表';

/*Data for the table `blsk_inv_io` */

/*Table structure for table `blsk_inv_item` */

DROP TABLE IF EXISTS `blsk_inv_item`;

CREATE TABLE `blsk_inv_item` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `IOID` bigint(20) DEFAULT NULL COMMENT '执行单据ID',
  `MATERIALID` bigint(20) DEFAULT NULL COMMENT '物料ID',
  `MNO` varchar(50) DEFAULT NULL COMMENT '物料号',
  `MCODE` varchar(50) DEFAULT NULL COMMENT '物料编码',
  `MANME` varchar(50) DEFAULT NULL COMMENT '物料名称',
  `USERID` bigint(20) DEFAULT NULL COMMENT '执行人ID',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '执行人',
  `REQ_NUM` bigint(20) DEFAULT NULL COMMENT '需求数量',
  `COUNT` bigint(20) DEFAULT NULL COMMENT '执行数量',
  `EXECTIME` datetime DEFAULT NULL COMMENT '执行时间',
  `ITEM_STATE` varchar(110) DEFAULT NULL COMMENT '状态（执行中、暂停、完成）',
  `ITEM_TYPE` varchar(110) DEFAULT NULL COMMENT '出库、入库、盘点',
  `DEPTID` bigint(20) DEFAULT NULL,
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK_IO_ITEM_REF` (`IOID`),
  CONSTRAINT `FK_IO_ITEM_REF` FOREIGN KEY (`IOID`) REFERENCES `blsk_inv_io` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据执行明细';

/*Data for the table `blsk_inv_item` */

/*Table structure for table `blsk_inv_space` */

DROP TABLE IF EXISTS `blsk_inv_space`;

CREATE TABLE `blsk_inv_space` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PID` bigint(20) DEFAULT NULL COMMENT '父ID',
  `NO` varchar(50) DEFAULT NULL COMMENT '库房/库位编号',
  `NAME` varchar(50) DEFAULT NULL COMMENT '库房/单元/库位/放置台名称',
  `TYPE` varchar(110) DEFAULT NULL COMMENT '库房、库位类型',
  `SAPCE_NAME` varchar(50) DEFAULT NULL COMMENT '库房名称',
  `UNITNAME` varchar(50) DEFAULT NULL COMMENT '单元名称',
  `ALLNAME` varchar(50) DEFAULT NULL COMMENT '全名',
  `LOR` varchar(110) DEFAULT NULL COMMENT '左侧或右侧',
  `INVROW` varchar(50) DEFAULT NULL COMMENT '排',
  `INVFLOOR` varchar(50) DEFAULT NULL COMMENT '层',
  `INVCOLUMN` varchar(50) DEFAULT NULL COMMENT '列/格',
  `ISCLOSE` varchar(110) DEFAULT NULL COMMENT '是否关闭',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK_SPACE_CHILD_SPACE_REF` (`PID`),
  CONSTRAINT `FK_SPACE_CHILD_SPACE_REF` FOREIGN KEY (`PID`) REFERENCES `blsk_inv_space` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房、库位表';

/*Data for the table `blsk_inv_space` */

/*Table structure for table `blsk_inv_store` */

DROP TABLE IF EXISTS `blsk_inv_store`;

CREATE TABLE `blsk_inv_store` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `BILLID` bigint(20) DEFAULT NULL COMMENT '单据ID',
  `IOID` bigint(20) DEFAULT NULL COMMENT '执行ID',
  `MATERIALID` bigint(20) DEFAULT NULL COMMENT '物料ID',
  `SPACEID` bigint(20) DEFAULT NULL COMMENT '库房id',
  `INVUNITID` bigint(20) DEFAULT NULL COMMENT '单元id',
  `KWID` bigint(20) DEFAULT NULL COMMENT '库位id',
  `SPACENAME` varchar(50) DEFAULT NULL COMMENT '库房名称',
  `UNITNAME` varchar(50) DEFAULT NULL COMMENT '单元名称',
  `BILLNO` varchar(50) DEFAULT NULL COMMENT '单据号',
  `IONO` varchar(50) DEFAULT NULL COMMENT '执行号',
  `MNO` varchar(50) DEFAULT NULL COMMENT '物料号',
  `MCODE` varchar(50) DEFAULT NULL COMMENT '物料编码',
  `MNAME` varchar(50) DEFAULT NULL COMMENT '物料名称',
  `INV_COUNT` bigint(20) DEFAULT NULL COMMENT '库存数量',
  `DEPTID` bigint(20) DEFAULT NULL,
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存结果';

/*Data for the table `blsk_inv_store` */

/*Table structure for table `blsk_material_info` */

DROP TABLE IF EXISTS `blsk_material_info`;

CREATE TABLE `blsk_material_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CODE` varchar(50) DEFAULT NULL COMMENT '编码',
  `NO` varchar(50) DEFAULT NULL COMMENT '编号',
  `MODEL` varchar(50) DEFAULT NULL COMMENT '型号',
  `NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `TYPE` varchar(110) DEFAULT NULL COMMENT '类型',
  `LENGTH` varchar(50) DEFAULT NULL COMMENT '长',
  `WIDTH` varchar(50) DEFAULT NULL COMMENT '宽',
  `HIGHT` varchar(50) DEFAULT NULL COMMENT '高',
  `UNIT` varchar(50) DEFAULT NULL COMMENT '计量单位',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物料基本档';

/*Data for the table `blsk_material_info` */

/*Table structure for table `blsk_material_property` */

DROP TABLE IF EXISTS `blsk_material_property`;

CREATE TABLE `blsk_material_property` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MATERIALID` bigint(20) DEFAULT NULL COMMENT '物料ID',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK_MATERIAL_CHILD_POP` (`MATERIALID`),
  CONSTRAINT `FK_MATERIAL_CHILD_POP` FOREIGN KEY (`MATERIALID`) REFERENCES `blsk_material_info` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='根据不同单位创建不同的单位对应的属性表，表中默认字段为ID和DEPTID';

/*Data for the table `blsk_material_property` */

/*Table structure for table `blsk_order_ref` */

DROP TABLE IF EXISTS `blsk_order_ref`;

CREATE TABLE `blsk_order_ref` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `TEMPLATEID` bigint(20) DEFAULT NULL COMMENT '模板ID',
  `TPL_HEADER` varchar(50) DEFAULT NULL COMMENT '模板列头',
  `O_HEADER` varchar(50) DEFAULT NULL COMMENT '规定列头',
  `TYPE` varchar(110) DEFAULT NULL COMMENT '模板类型（入库、出库、盘点）',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '所属单位',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK_ORDER_REF` (`TEMPLATEID`),
  CONSTRAINT `FK_ORDER_REF` FOREIGN KEY (`TEMPLATEID`) REFERENCES `blsk_order_template` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据模板与具体单据表中对应关系';

/*Data for the table `blsk_order_ref` */

/*Table structure for table `blsk_order_template` */

DROP TABLE IF EXISTS `blsk_order_template`;

CREATE TABLE `blsk_order_template` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `NO` varchar(50) DEFAULT NULL COMMENT '模板编号',
  `TYPE` varchar(110) DEFAULT NULL COMMENT '模板类型（入库、出库、盘点）',
  `ORDERNO` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `ONO_LINE` bigint(20) DEFAULT NULL COMMENT '单据编号所在行',
  `HEADER` varchar(2000) DEFAULT NULL COMMENT '列头',
  `HEADER_LINE` bigint(20) DEFAULT NULL COMMENT '列头所在行',
  `FILE_LOCAL_PATH` varchar(200) DEFAULT NULL COMMENT '本地路径',
  `FILE_SERVER_PATH` varchar(200) DEFAULT NULL COMMENT '服务器路径',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '所属单位',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据模板配置表';

/*Data for the table `blsk_order_template` */

/*Table structure for table `blsk_space_address` */

DROP TABLE IF EXISTS `blsk_space_address`;

CREATE TABLE `blsk_space_address` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PARTYID` bigint(20) DEFAULT NULL COMMENT '客户单位',
  `SPACEID` bigint(20) DEFAULT NULL COMMENT '库房',
  `IP` varchar(50) DEFAULT NULL COMMENT 'IP地址',
  `LONGITUDE` varchar(50) DEFAULT NULL COMMENT '经度（地图纵坐标）',
  `LATITUDE` varchar(50) DEFAULT NULL COMMENT '纬度（地图横坐标）',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK_SAPCE_ADDRESS_REF` (`SPACEID`),
  CONSTRAINT `FK_SAPCE_ADDRESS_REF` FOREIGN KEY (`SPACEID`) REFERENCES `blsk_inv_space` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户库房地址（扩展一个客户在多个地区存在库房），便于以地图形式查找客户分布图';

/*Data for the table `blsk_space_address` */

/*Table structure for table `blsk_space_equip` */

DROP TABLE IF EXISTS `blsk_space_equip`;

CREATE TABLE `blsk_space_equip` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `SPACEID` bigint(20) DEFAULT NULL COMMENT '库房ID',
  `EQUIPID` bigint(20) DEFAULT NULL COMMENT '设备ID',
  `STATE` varchar(110) DEFAULT NULL COMMENT '设备运行状态',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK_EQUIP_SPACE_REF` (`EQUIPID`),
  KEY `FK_SPACE_EQUIP_REF` (`SPACEID`),
  CONSTRAINT `FK_EQUIP_SPACE_REF` FOREIGN KEY (`EQUIPID`) REFERENCES `blsk_equip_info` (`ID`),
  CONSTRAINT `FK_SPACE_EQUIP_REF` FOREIGN KEY (`SPACEID`) REFERENCES `blsk_inv_space` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房与设备之间关系，主要描述当前堆垛机、传感器对应库房中的层、排、格，后台单据上物料的出入库确定计算给哪个设备发送指令\n';

/*Data for the table `blsk_space_equip` */

/*Table structure for table `blsk_space_item` */

DROP TABLE IF EXISTS `blsk_space_item`;

CREATE TABLE `blsk_space_item` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `EQUIPID` bigint(20) DEFAULT NULL COMMENT '设备ID',
  `ITEMID` bigint(20) DEFAULT NULL COMMENT '明细ID',
  `STATE` varchar(110) DEFAULT NULL COMMENT '运行状态',
  `DEPTID` bigint(20) DEFAULT NULL,
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK_EQUIP_ITEM_REF` (`EQUIPID`),
  KEY `FK_ITEM_EQUIP_REF` (`ITEMID`),
  CONSTRAINT `FK_EQUIP_ITEM_REF` FOREIGN KEY (`EQUIPID`) REFERENCES `blsk_equip_info` (`ID`),
  CONSTRAINT `FK_ITEM_EQUIP_REF` FOREIGN KEY (`ITEMID`) REFERENCES `blsk_inv_io` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备与出库、入库、盘点实际执行关系表';

/*Data for the table `blsk_space_item` */

/*Table structure for table `blsk_space_property` */

DROP TABLE IF EXISTS `blsk_space_property`;

CREATE TABLE `blsk_space_property` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `SPACEID` bigint(20) DEFAULT NULL COMMENT '库房ID',
  `TYPE` varchar(110) DEFAULT NULL COMMENT '类型（默认不可调整，可调整）',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK_SPACE_PROPERTY_REF` (`SPACEID`),
  CONSTRAINT `FK_SPACE_PROPERTY_REF` FOREIGN KEY (`SPACEID`) REFERENCES `blsk_inv_space` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房库位属性表，属性根据具体内容进行添加或调整，初始没有属性';

/*Data for the table `blsk_space_property` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
