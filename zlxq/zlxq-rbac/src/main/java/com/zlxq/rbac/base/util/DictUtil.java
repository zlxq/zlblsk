package com.zlxq.rbac.base.util;

public class DictUtil {

	public static String roleString = "100"; //角色
	public static String deptString = "200"; //party表中partytype类型
	public static String partyRelationString = "200"; //partyrelation表中type类型
	
	
	public static final class role_lx {
		public static String role_super = "100100";//超级管理员
		public static String role_xtgly = "100200";//系统管理员
	}
	
	public static final class dept_lx {
		public static String dept_gs = "200100";//公司
		public static String dept_bm = "200200";//部门
		public static String dept_ry = "200300";//人员
	}
	
	public static final class partyRel_lx {
		public static String partyRel_gs = "300100";//公司
		public static String partyRel_gshzz = "300200";//组织和组织
		public static String partyRel_zzhyhz = "300300";//组织和用户组
		public static String partyRel_zzhr = "300400";//组织和人
		public static String partyRel_yhzhr = "300500";//用户组和人
	}
}
