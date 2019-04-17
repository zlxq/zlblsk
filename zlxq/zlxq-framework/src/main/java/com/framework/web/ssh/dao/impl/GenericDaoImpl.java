package com.framework.web.ssh.dao.impl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.FlushMode;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.framework.util.JsonUtil;
import com.framework.util.PagingBean;
import com.framework.web.ssh.dao.GenericDao;

/**
 * 泛型的好处是在编译的时候检查类型安全，并且所有的强制转换都是自动和隐式的，提高代码的重用率
 * 
 * http://laoaenna.iteye.com/blog/1278289 详细介绍
 */

/**
 * @ClassName: GenericDaoImpl
 * @Description: 系统核心数据层接口实现，当前版本（V1.0）底层采用jdbc连接
 *               泛型的好处是在编译的时候检查类型安全，并且所有的强制转换都是自动和隐式的，提高代码的重用率
 *               http://laoaenna.iteye.com/blog/1278289 详细介绍
 * @author: PUB
 * @date: 2019年4月17日 下午10:30:44
 *
 * @param <T>
 * @param <PK>
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
public abstract class GenericDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport
		implements GenericDao<T, PK> {
	protected Log logger = LogFactory.getLog(GenericDaoImpl.class);
	protected JdbcTemplate jdbcTemplate;
	protected Class<?> persistType;

	public void setPersistType(Class<?> persistType) {
		this.persistType = persistType;
	}

	public GenericDaoImpl(Class<?> persistType) {
		this.persistType = persistType;
	}

	/**
	 * 通过id查询对象
	 * 
	 * @author zhangl
	 *
	 * @param id
	 * @return
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	@SuppressWarnings("unchecked")
	public T find(PK id) {
		return (T) getHibernateTemplate().get(this.persistType, id);
	}

	/**
	 * 通过序列化主键查询对象
	 * 
	 * @author zhangl
	 *
	 * @param paramPK
	 * @return
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	@SuppressWarnings("unchecked")
	public T findByPk(Serializable paramPK) {
		return (T) getHibernateTemplate().get(this.persistType, paramPK);
	}

	/**
	 * 保存更新对象
	 * 
	 * @author zhangl
	 *
	 * @param entity
	 * @return
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public T save(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	/**
	 * 保存实体
	 * 
	 * @author zhangl
	 *
	 * @param entity
	 * @return
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public T saveEntity(T entity) {
		getHibernateTemplate().save(entity);
		return entity;
	}

	/**
	 * 保存对象
	 * 
	 * @author zhangl
	 *
	 * @param entity
	 * @return
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	@SuppressWarnings("deprecation")
	public T merge(T entity) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHibernateTemplate().merge(entity);
		return entity;
	}

	/**
	 * 通过主键移除数据
	 * 
	 * @author zhangl
	 *
	 * @param id
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public void remove(PK id) {
		getHibernateTemplate().delete(find(id));
	}

	/**
	 * 移除对象
	 * 
	 * @author zhangl
	 *
	 * @param entity
	 * @createtime 2017年6月17日
	 * @version V1.0
	 */
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}

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
	public void getLazyData(Object object) {
		this.getHibernateTemplate().initialize(object);
	}

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
	public List<?> findByHQL(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

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
	public List<?> findByJDBCReturnList(String sql) {
		logger.debug("===========执行sql==========:\n" + sql);
		return this.jdbcTemplate.queryForList(sql);
	}

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
	public List<?> findByJDBCReturnList(PagingBean pb, String sql) {
		sql = "SELECT T.* FROM (" + sql + ") T LIMIT " + pb.getStartRows() + ", " + pb.getRows() + "";
		List<?> list = findByJDBCReturnList(sql);
		return list;
	}

	/**
	 * 查询所有数据返回json字符串
	 * 
	 * @author zhangl
	 *
	 * @param pb
	 * @param sql
	 * @return {"success":true,
	 *         "total":10,rows:[{"no":"111","name":"222"},{"no":"333","name":"444"}]}
	 * @createtime 2017年3月2日
	 * @version V1.0
	 */
	public String findByJDBCReturnJSON(String sql) {
		List<?> list = findByJDBCReturnList(sql);
		return JsonUtil.getJson(list);
	}

	/**
	 * 分页查询返回json字符串
	 * 
	 * @author zhangl
	 *
	 * @param pb
	 * @param sql
	 * @return {"success":true,
	 *         "total":10,rows:[{"no":"111","name":"222"},{"no":"333","name":"444"}]}
	 * @createtime 2017年3月2日
	 * @version V1.0
	 */
	public String findByJDBCReturnJSON(PagingBean pb, String sql) {
		List<?> list = findByJDBCReturnList(pb, sql);
		int total = findByJDBCReturnCount(sql);
		return JsonUtil.getJson(list, total);
	}

	/**
	 * 返回查询数据总条数
	 * @author zhangl
	 *
	 * @param sql
	 * @return
	 * @createtime 2017年10月22日
	 * @version V1.0
	 */
	private int findByJDBCReturnCount(String sql) {
		sql = "SELECT T.* FROM (" + sql + ") T";
		List<?> list = findByJDBCReturnList(sql);
		return list.size();
	}

		/**
	 * 分页查询返回json字符串
	 * 
	 * @author mengzh
	 *
	 * @param sql
	 * @return [{"no":"111","name":"222"},{"no":"333","name":"444"}]
	 * @createtime 2017年7月10日
	 * @version V1.0
	 */
        public String findByJDBCReturnJSON_combo(String sql) {
		List<?> list = findByJDBCReturnList(sql);
		return JsonUtil.listTOJson(list);
	}

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
	public void batchUpdate(String sql) {
		this.jdbcTemplate.batchUpdate(sql);
	}

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
	public void batchUpdate(String sql, List<String[]> list) {
		BatchPreparedStatementSetter pss = new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				String[] obj = list.get(i);

				for (int j = 0; j < getBatchSize(); j++) {
					ps.setString(j, obj[j]);
				}
			}

			/**
			 * 一次提交批量大小
			 */
			@Override
			public int getBatchSize() {
				return list.size();
			}
		};

		this.jdbcTemplate.batchUpdate(sql, pss);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
