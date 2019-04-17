package com.framework.web.ssh.dao;

import java.io.Serializable;
import java.util.List;

import com.framework.util.PagingBean;

/**
 * @ClassName: GenericDao
 * @Description: 抽象接口dao层
 * @author: PUB
 * @date: 2019年4月17日 下午10:29:36
 *
 * @param <T>
 * @param <PK>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public abstract interface GenericDao<T, PK extends Serializable> {

	/**
	 * 通过id查询对象
	 * @author zhangl
	 *
	 * @param id
	 * @return
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public T find(PK id);
	
	/**
	 * 通过序列化主键查询对象
	 * @author zhangl
	 *
	 * @param paramPK
	 * @return
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public T findByPk(Serializable paramPK);
	
	/**
	 * 保存更新对象
	 * @author zhangl
	 *
	 * @param entity
	 * @return
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public T save(T entity);
	
	/**
	 * 保存实体
	 * @author zhangl
	 *
	 * @param entity
	 * @return
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public T saveEntity(T entity);
	
	/**
	 * 保存对象
	 * @author zhangl
	 *
	 * @param entity
	 * @return
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public T merge(T entity);
	
	/**
	 * 通过主键移除数据
	 * @author zhangl
	 *
	 * @param id
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public void remove(PK id);
	
	/**
	 * 移除对象
	 * @author zhangl
	 *
	 * @param entity
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public void remove(T entity);
	
	/**
	 * 获得延迟加载数据
	 * 
	 * <pre>
	 * hibernate.initialize(object);
	 * </pre>
	 * 
	 * @author zhangl
	 *
	 * @param object
	 *            需要加载的对象
	 * @createtime 2017年6月5日
	 * @version V1.0
	 */
	public void getLazyData(Object object);

	/**
	 * 根据传递的HQL语句，来查询数据库
	 * 
	 * @author zhangl
	 *
	 * @param hql
	 * @return
	 * @createtime 2017年6月5日
	 * @version V1.0
	 */
	public List<?> findByHQL(String hql);

	/**
	 * SQL查询返回所有结果集List，未对结果集处理； 例：[{ID=111, PARTYNO=ADMIN,
	 * PARTYNAME=系统管理员},{ID=222, PARTYNO=ZS, PARTYNAME=安全保密员}]
	 * 
	 * @author zhangl
	 *
	 * @param sql
	 * @return [{ID=111, PARTYNO=ADMIN,PARTYNAME=系统管理员},{ID=222, PARTYNO=ZS,
	 *         PARTYNAME=安全保密员}]
	 * @createtime 2017年2月26日
	 * @version V1.0
	 */
	public List<?> findByJDBCReturnList(String sql);

	/**
	 * SQL分页查询返回结果集List，未对结果集处理； 例：[{ID=111, PARTYNO=ADMIN,
	 * PARTYNAME=系统管理员},{ID=222, PARTYNO=ZS, PARTYNAME=安全保密员}]；
	 * 
	 * @author zhangl
	 *
	 * @param sql
	 * @return [{ID=111, PARTYNO=ADMIN,PARTYNAME=系统管理员},{ID=222, PARTYNO=ZS,
	 *         PARTYNAME=安全保密员}]
	 * @createtime 2017年2月26日
	 * @version V1.0
	 */
	public List<?> findByJDBCReturnList(PagingBean pb, String sql);

	/**
	 * 查询所有数据返回json字符串
	 * 
	 * @author zhangl
	 *
	 * @param pb
	 * @param sql
	 * @return {"success":true,
	 *         "totalCounts":10,result:[{"no":"111","name":"222"},{"no":"333","name":"444"}]}
	 * @createtime 2017年3月2日
	 * @version V1.0
	 */
	public String findByJDBCReturnJSON(String sql);

	/**
	 * 分页查询返回json字符串
	 * 
	 * @author zhangl
	 *
	 * @param pb
	 * @param sql
	 * @return {"success":true,
	 *         "totalCounts":10,result:[{"no":"111","name":"222"},{"no":"333","name":"444"}]}
	 * @createtime 2017年3月2日
	 * @version V1.0
	 */
	public String findByJDBCReturnJSON(PagingBean pb, String sql);

	/**
	 * 一条数据更新
	 * 
	 * @author zhangl
	 *
	 * @param sql
	 * @return
	 * @createtime 2017年2月26日
	 * @version V1.0
	 */
	public void batchUpdate(String sql);

	/**
	 * 批量数据更新，并且分批提交数据； 注：将10000条数据，可分为1次或多次提交到数据库（与数据库建立连接1次或多次）
	 * 
	 * @author zhangl
	 *
	 * @param sql
	 * @param list
	 *            需要更新的字段，例：update user set no=?, name=?, sex=? where id = '111'
	 *            list 为问号部分。
	 * 
	 *            String[] data = {"no1","name1","sex1"};
	 * 
	 *            List list = [{"no1","name1","sex1"}, {"no2","name2","sex2"}];
	 * @return
	 * @createtime 2017年2月26日
	 * @version V1.0
	 */
	public void batchUpdate(String sql, List<String[]> list);

}