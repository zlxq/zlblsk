package com.zlxq.rbac.dict.service;

import com.zlxq.rbac.base.core.service.BaseService;

import pojo.ZlxqDictionary;

public abstract interface ZlxqDictionaryService extends BaseService<ZlxqDictionary> {

	/**
	 * 查询字典树
	 * @author zhangl
	 *
	 * @param id
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	String getDictTree(String id);

	/**
	 * 平铺展示字典信息
	 * @author zhangl
	 *
	 * @param id
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	String getDictGrid(String id);

	/**
	 * 保存字典
	 * @author zhangl
	 *
	 * @param zlxqDictionary
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 * @param pid 
	 */
	String saveDict(ZlxqDictionary zlxqDictionary, String pid);

	/**
	 * 修改字典表单
	 * @author zhangl
	 *
	 * @param zlxqDictionary
	 * @param id
	 * @return
	 * @createtime 2017年7月5日
	 * @version V1.0
	 */
	String editDict(ZlxqDictionary zlxqDictionary, String id);

	/**
	 * 删除字典
	 * @author zhangl
	 *
	 * @param ids
	 * @return
	 * @createtime 2017年7月20日
	 * @version V1.0
	 */
	String delDict(String ids);

}
