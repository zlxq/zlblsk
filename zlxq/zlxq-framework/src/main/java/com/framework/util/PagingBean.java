package com.framework.util;

import java.io.Serializable;

/**
 * 
 * @ClassName: PagingBean
 * @Description: 分页
 * @author: PUB
 * @date: 2019年4月17日 下午10:25:40
 *
 * @Copyright: 2019 www.zlxq.com Inc. All rights reserved.
 *
 */
@SuppressWarnings("serial")
public class PagingBean implements Serializable {

	public static final int INIT_ROWS = 30;
	/**
	 * 数据总条数
	 */
	private int total;
	/**
	 * 每页数据条数
	 */
	private int rows;
	/**
	 * 第几页
	 */
	private int page;
	/**
	 * 起始数据索引
	 */
	private int startRows;
	/**
	 * 结束数据索引
	 */
	private int endRows;

	public PagingBean() {

	}

	public PagingBean(int start, int limit) {
		this.rows = Integer.valueOf(rows);
		this.page = Integer.valueOf(page);
	}

	public PagingBean(int total, int rows, int page, int startRows, int endRows) {
		super();
		this.total = total;
		this.rows = rows;
		this.page = page;
		this.startRows = startRows;
		this.endRows = endRows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStartRows() {
		return startRows;
	}

	public void setStartRows(int startRows) {
		this.startRows = startRows;
	}

	public int getEndRows() {
		return endRows;
	}

	public void setEndRows(int endRows) {
		this.endRows = endRows;
	}

}
