package com.zlxq.rbac.base.util;

public class DictUtil {

	public static String roleString = "100"; //角色
	public static String deptString = "200"; //party表中partytype类型
	public static String partyRelationString = "300"; //partyrelation表中type类型
	public static String equipString = "400"; //设备类型
	public static String qrtypeSting = "500"; //执行码类型
	
	
	public static final class role_lx {
		public static String role_super = "100100";//超级管理员
		public static String role_xtgly = "100200";//系统管理员
		public static String role_ptjs = "100300";//普通角色
	}
	
	public static final class dept_lx {
		public static String dept_gs = "200100";//公司
		public static String dept_bm = "200200";//部门
		public static String dept_ry = "200300";//人员
	}
	
	public static final class partyRel_lx {
		public static String partyRel_gshzz = "300100";//组织和组织
		public static String partyRel_zzhyhz = "300200";//组织和用户组
		public static String partyRel_zzhr = "300300";//组织和人
		public static String partyRel_yhzhr = "300400";//用户组和人
	}
	
	public static final class equip_lx {
		public static String equip_ddj = "400100";//堆垛机
		public static String equip_cgq = "400200";//传感器
	}

	public static final class qrtype_lx {
		public static String qrtype_rk = "500100";//入库执行码
		public static String qrtype_ck = "500200";//出库执行码
		public static String qrtype_pd = "500300";//盘点执行码
	}
}
