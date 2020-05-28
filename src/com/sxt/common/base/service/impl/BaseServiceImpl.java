package com.sxt.common.base.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.common.PageInfo;
import com.sxt.common.Result;
import com.sxt.common.base.BaseForm;
import com.sxt.common.base.BaseQuery;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.mapper.BaseMapper;
import com.sxt.common.base.service.IBaseService;

public class BaseServiceImpl implements IBaseService<BaseForm,BaseQuery,BaseVO> {
	
	private BaseMapper  baseMapper;
	/**
	 * @Title:BaseServiceImpl
	 * @Description: 使用构造方法  让 BaseServiceImpl中每个BaseMapper  不是同一个Mapper
	 * @param baseMapper
	 */
	public BaseServiceImpl(BaseMapper baseMapper) {
		this.baseMapper = baseMapper;
	}
	

	@Override
	public Result add(BaseForm form) {
		baseMapper.insert(form);
		return new Result();
	}

	@Override
	public Result delete(Integer id) {
		baseMapper.delete(id);
		return new Result();
	}

	@Override
	public Result queryList(BaseQuery query) {
		List<BaseVO> list = baseMapper.selectList(query);
		return new Result(list);
	}

	@Override
	public Result queryPage(BaseQuery query) {
		Page<BaseVO> page = PageHelper.startPage(query.getPage(), query.getLimit());
		baseMapper.selectList(query);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setData(page.getResult());
		pageInfo.setCount(page.getTotal());
		return new Result(pageInfo);
	}

	@Override
	public Result update(BaseForm form) {
		baseMapper.update(form);
		return new Result();
	}


}
