package com.sxt.sys.form;

import com.sxt.common.base.BaseForm;

public class SysMenuForm extends BaseForm {

	/**
	 *	权限ID
	 */
	private Integer id;
	
	/**
	 * 	父节点ID
	 */
	private  Integer parentId;
	
	/**
	 * 	标题
	 */
	private String title;
	/**
	 * 	图标
	 */
	private String icon;
	/**
	 * 	资源地址
	 */
	private String href;
	/**
	 * 	是否展开
	 */
	private Byte spread;
	/**
	 * 	是否可用 1 可用		2 不可用
	 */
	private Integer flag ;
	/**
	 * 	打开方式  :  _blank  新窗口   _self  当前矿口 
	 */
	private String target;
	/**
	 * 	菜单的级别  
	 */
	private Integer lv;
	/**
	 * 	菜单的排序
	 */
	private Integer sort;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Byte getSpread() {
		return spread;
	}
	public void setSpread(Byte spread) {
		this.spread = spread;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Integer getLv() {
		return lv;
	}
	public void setLv(Integer lv) {
		this.lv = lv;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	
	
}
