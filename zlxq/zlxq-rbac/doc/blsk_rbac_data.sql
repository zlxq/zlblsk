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

/*Table structure for table `zlxq_dictionary` */

DROP TABLE IF EXISTS `zlxq_dictionary`;

CREATE TABLE `zlxq_dictionary` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PID` bigint(20) DEFAULT NULL,
  `DIC_CODE` varchar(200) DEFAULT NULL COMMENT '字典编号',
  `DIC_NAME` varchar(200) DEFAULT NULL COMMENT '字典名称',
  `DIC_TYPE` varchar(1) DEFAULT NULL COMMENT '字典类型（0分类，1词条）',
  `DIC_NODE` varchar(1000) DEFAULT NULL COMMENT '字典描述',
  `CREATETIME` date DEFAULT NULL,
  `UPDATETIME` date DEFAULT NULL,
  `ISVALIDATE` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKaa4knhmvt9fyosed5khxb0a2d` (`PID`),
  CONSTRAINT `FKaa4knhmvt9fyosed5khxb0a2d` FOREIGN KEY (`PID`) REFERENCES `zlxq_dictionary` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典';

/*Data for the table `zlxq_dictionary` */

/*Table structure for table `zlxq_log` */

DROP TABLE IF EXISTS `zlxq_log`;

CREATE TABLE `zlxq_log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `LOGINNO` varchar(50) DEFAULT NULL COMMENT '登陆号',
  `LOGINNAME` varchar(50) DEFAULT NULL COMMENT '登陆名',
  `LOGINTIME` datetime DEFAULT NULL COMMENT '登陆时间',
  `LOGINIP` varchar(50) DEFAULT NULL COMMENT '登陆IP',
  `LOGINTYPE` varchar(50) DEFAULT NULL COMMENT '登陆类型WEB,APP',
  `MESSAGE` varchar(50) DEFAULT NULL COMMENT '登陆后返回消息(失败，成功)',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zlxq_log` */

/*Table structure for table `zlxq_log_operation` */

DROP TABLE IF EXISTS `zlxq_log_operation`;

CREATE TABLE `zlxq_log_operation` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `LOGID` bigint(20) DEFAULT NULL COMMENT '日志主表ID',
  `OPERTYPE` varchar(110) DEFAULT NULL COMMENT '增加、删除、修改',
  `OPERTIME` datetime DEFAULT NULL COMMENT '操作时间',
  `OPERDES` varchar(1000) DEFAULT NULL COMMENT '操作内容',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  `LOGINID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID` (`ID`),
  KEY `FKc17c5d6gtw9lhu953v3l7wvvq` (`LOGINID`),
  CONSTRAINT `FKc17c5d6gtw9lhu953v3l7wvvq` FOREIGN KEY (`LOGINID`) REFERENCES `zlxq_log` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zlxq_log_operation` */

/*Table structure for table `zlxq_menu` */

DROP TABLE IF EXISTS `zlxq_menu`;

CREATE TABLE `zlxq_menu` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PID` bigint(20) DEFAULT NULL COMMENT '父主键id',
  `MENUCODE` varchar(200) DEFAULT NULL COMMENT '菜单编号',
  `MENUNAME` varchar(200) DEFAULT NULL COMMENT '菜单名称',
  `MENUURL` varchar(200) DEFAULT NULL COMMENT '菜单url',
  `MENUTYPE` varchar(110) DEFAULT NULL COMMENT '菜单类型(1一级菜单，2二级菜单，3三级菜单)',
  `MENUSORT` int(11) DEFAULT NULL COMMENT '排序',
  `ISLEAF` varchar(200) DEFAULT NULL COMMENT '是否是叶子，true或false',
  `ICONCLS` varchar(200) DEFAULT NULL,
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK26q8n7hxvelnxy7vyg97l44x5` (`PID`),
  CONSTRAINT `FK26q8n7hxvelnxy7vyg97l44x5` FOREIGN KEY (`PID`) REFERENCES `zlxq_menu` (`ID`),
  CONSTRAINT `FK_FK_MENU_MENU` FOREIGN KEY (`PID`) REFERENCES `zlxq_menu` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='系统菜单1，模块2，按钮3，url4';

/*Data for the table `zlxq_menu` */

insert  into `zlxq_menu`(`ID`,`PID`,`MENUCODE`,`MENUNAME`,`MENUURL`,`MENUTYPE`,`MENUSORT`,`ISLEAF`,`ICONCLS`,`CREATOR`,`CREATETIME`,`UPDATETIME`,`ISVALIDATE`) values (1,NULL,'BackStageManager','后台管理',NULL,'0',10,'open','icon-city',NULL,NULL,NULL,'1'),(2,1,'SystemMenuManager','系统菜单管理','moudles/rbac/menu/sysmenuview.jsp','1',11,'open','icon-city',NULL,NULL,NULL,'1'),(3,1,'SystemDictManager','系统参数管理','moudles/rbac/dict/sysdictview.jsp','1',12,'open','icon-city',NULL,NULL,NULL,'1'),(4,1,'SysLogManager','系统日志管理','moudles/rbac/log/syslogview.jsp','1',13,'open','icon-city',NULL,NULL,NULL,'1'),(5,NULL,'SystemManager','系统管理',NULL,'0',20,'open','icon-city',NULL,'2019-05-02 13:26:08','2019-05-02 13:26:14','1'),(6,5,'SystemRoleManager','系统角色管理','moudles/rbac/menu/sysmenuview.jsp','1',21,'open','icon-city',NULL,'2019-05-02 13:27:41','2019-05-02 13:27:43','1'),(7,5,'SystemSecretManager','系统权限管理','moudles/rbac/auth/sysauthview.jsp','1',22,'open','icon-city',NULL,NULL,NULL,'1'),(8,5,'DeptManager','客户单位管理','moudles/rbac/dept/sysdeptview.jsp','1',23,'open','icon-city',NULL,NULL,NULL,'1'),(9,5,'UserManager','用户信息管理','moudles/rbac/party/syspartyview.jsp','1',24,'open','icon-city',NULL,NULL,NULL,'1'),(10,NULL,'BigScreenManager','看板管理',NULL,'0',30,'open','icon-city',NULL,NULL,NULL,'1'),(13,10,'UserLayoutManager','客户分布图',NULL,'1',31,'open','icon-city',NULL,NULL,NULL,'1'),(14,10,'EquipMonitorManager','设备监控图',NULL,'1',32,'open','icon-city',NULL,NULL,NULL,'1'),(15,NULL,'BaseDataManager','基础数据',NULL,'0',40,'open','icon-city',NULL,NULL,NULL,'1'),(16,15,'UserParamManager','用户参数配置',NULL,'1',41,'open','icon-city',NULL,NULL,NULL,'1'),(17,15,'EquipInfoManager','设备基础信息',NULL,'1',42,'open','icon-city',NULL,NULL,NULL,'1'),(18,15,'Graphical2DManager','巷道平面图',NULL,'1',43,'open','icon-city',NULL,NULL,NULL,'1'),(19,15,'OrderTempleteManager','单据模板配置',NULL,'1',44,'open','icon-city',NULL,NULL,NULL,'1'),(20,15,'MaterialManager','物料信息管理',NULL,'1',45,'open','icon-city',NULL,NULL,NULL,'1'),(21,15,'WareHouseManager','库房信息管理',NULL,'1',46,'open','icon-city',NULL,NULL,NULL,'1');

/*Table structure for table `zlxq_party` */

DROP TABLE IF EXISTS `zlxq_party`;

CREATE TABLE `zlxq_party` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PARTYNO` varchar(50) DEFAULT NULL COMMENT '人员/组织编号',
  `LOGINNO` varchar(50) DEFAULT NULL COMMENT '登录号',
  `PARTNAME` varchar(50) DEFAULT NULL COMMENT '人员/组织名称',
  `PASSWORD` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `ISSUPER` varchar(1) DEFAULT NULL COMMENT '是否超级管理员',
  `SEX` varchar(110) DEFAULT NULL COMMENT '性别：男，女',
  `PARTYTYPE` varchar(110) DEFAULT NULL COMMENT ' 人、班级、学校',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮件',
  `TEL` varchar(50) DEFAULT NULL COMMENT '电话',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `zlxq_party` */

insert  into `zlxq_party`(`ID`,`PARTYNO`,`LOGINNO`,`PARTNAME`,`PASSWORD`,`ISSUPER`,`SEX`,`PARTYTYPE`,`EMAIL`,`TEL`,`DEPTID`,`CREATOR`,`CREATETIME`,`UPDATETIME`,`ISVALIDATE`) values (1,'admin','admin','超级管理员','123','1',NULL,'100100',NULL,NULL,NULL,NULL,NULL,NULL,'1');

/*Table structure for table `zlxq_party_relation` */

DROP TABLE IF EXISTS `zlxq_party_relation`;

CREATE TABLE `zlxq_party_relation` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PARTYID1` bigint(20) DEFAULT NULL COMMENT '父级的组织/人员主键id',
  `PARTYID2` bigint(20) DEFAULT NULL COMMENT '子级的组织/人员主键id',
  `TYPE` varchar(110) DEFAULT NULL COMMENT '组织-组织/组织-人的关系类型',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FKebse7c3w938bie0ysoabxb29q` (`PARTYID2`),
  KEY `FK9w00tok7uolh594ffjsh9krsm` (`PARTYID1`),
  CONSTRAINT `FK9w00tok7uolh594ffjsh9krsm` FOREIGN KEY (`PARTYID1`) REFERENCES `zlxq_party` (`ID`),
  CONSTRAINT `FK_PARTY_REALTION_REF1` FOREIGN KEY (`PARTYID1`) REFERENCES `zlxq_party` (`ID`),
  CONSTRAINT `FK_PARTY_REALTION_REF2` FOREIGN KEY (`PARTYID2`) REFERENCES `zlxq_party` (`ID`),
  CONSTRAINT `FKebse7c3w938bie0ysoabxb29q` FOREIGN KEY (`PARTYID2`) REFERENCES `zlxq_party` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织与人员的关系表/组织与组织的关系';

/*Data for the table `zlxq_party_relation` */

/*Table structure for table `zlxq_role` */

DROP TABLE IF EXISTS `zlxq_role`;

CREATE TABLE `zlxq_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色主键id',
  `ROLENO` varchar(50) DEFAULT NULL COMMENT '角色编号',
  `ROLENAME` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `ROLETYPE` varchar(110) DEFAULT NULL COMMENT '角色类型',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表（学校管理员，教师，学生，超级用户）';

/*Data for the table `zlxq_role` */

/*Table structure for table `zlxq_role_menu` */

DROP TABLE IF EXISTS `zlxq_role_menu`;

CREATE TABLE `zlxq_role_menu` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色表id',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '菜单表id',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FKgvpyadim3yd19hfc2d18gluuk` (`MENU_ID`),
  KEY `FK7ujh5qelio93r30oo3vsigncf` (`ROLE_ID`),
  CONSTRAINT `FK7ujh5qelio93r30oo3vsigncf` FOREIGN KEY (`ROLE_ID`) REFERENCES `zlxq_role` (`ID`),
  CONSTRAINT `FK_ROLE_MENU_REL1` FOREIGN KEY (`MENU_ID`) REFERENCES `zlxq_menu` (`ID`),
  CONSTRAINT `FK_ROLE_MENU_REL2` FOREIGN KEY (`ROLE_ID`) REFERENCES `zlxq_role` (`ID`),
  CONSTRAINT `FKgvpyadim3yd19hfc2d18gluuk` FOREIGN KEY (`MENU_ID`) REFERENCES `zlxq_menu` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关系表';

/*Data for the table `zlxq_role_menu` */

/*Table structure for table `zlxq_user_role` */

DROP TABLE IF EXISTS `zlxq_user_role`;

CREATE TABLE `zlxq_user_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USERID` bigint(20) DEFAULT NULL COMMENT '用户表主键id''',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色表主键id',
  `RELTYPE` varchar(110) DEFAULT NULL COMMENT '备用关系',
  `DEPTID` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `CREATOR` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `ISVALIDATE` varchar(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`),
  KEY `FK6q3cfhplh6pv359qhy5ulxoih` (`USERID`),
  KEY `FK6f91rui0qi564wni0den97l3l` (`ROLE_ID`),
  CONSTRAINT `FK6f91rui0qi564wni0den97l3l` FOREIGN KEY (`ROLE_ID`) REFERENCES `zlxq_role` (`ID`),
  CONSTRAINT `FK6q3cfhplh6pv359qhy5ulxoih` FOREIGN KEY (`USERID`) REFERENCES `zlxq_party` (`ID`),
  CONSTRAINT `FK_USER_ROLE_REF1` FOREIGN KEY (`ROLE_ID`) REFERENCES `zlxq_role` (`ID`),
  CONSTRAINT `FK_USER_ROLE_REF2` FOREIGN KEY (`USERID`) REFERENCES `zlxq_party` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户与角色的关联表';

/*Data for the table `zlxq_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
