package com.sxt.sys.form;

import com.sxt.common.base.BaseForm;

public class SysRolesForm  extends BaseForm{
	 /**
     * 角色编号
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色备注
     */
    private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
