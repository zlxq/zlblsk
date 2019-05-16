package com.zlxq.rbac.dict.dao;

import java.util.List;

import com.zlxq.rbac.base.core.dao.BaseDao;

import pojo.ZlxqDictionary;

public abstract interface ZlxqDictionaryDao extends BaseDao<ZlxqDictionary> {

	/**
	 * 动态加载字典树节点
	 * @author zhangl
	 *
	 * @param id
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	String getDictTree(String id);

	/**
	 * 平铺展示字典列表
	 * @author zhangl
	 *
	 * @param id
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	String getDictGrid(String id);

	/**
	 * 通过字典编号或名称查询字典list
	 * @author zhangl
	 *
	 * @param diccode
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	List getDictInfo(String diccode);

}
