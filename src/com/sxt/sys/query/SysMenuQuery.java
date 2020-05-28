package com.sxt.sys.query;

import com.sxt.common.base.BaseQuery;

public class SysMenuQuery extends BaseQuery {

	private String title;
	
	private Integer flag;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	
}
