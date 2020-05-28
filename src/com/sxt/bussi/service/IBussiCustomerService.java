package com.sxt.bussi.service;

import com.sxt.bussi.form.BussiCustomerForm;
import com.sxt.common.Result;
import com.sxt.common.base.BaseForm;
import com.sxt.common.base.BaseQuery;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.IBaseService;

public interface IBussiCustomerService extends IBaseService<BaseForm,BaseQuery,BaseVO> {
	/**
	 * @Title: createNewCustomer
	 * @author: Mr.T   
	 * @date: 2019年12月2日 上午9:14:50 
	 * @Description: 新增新客户
	 * @param form
	 * @return
	 * @return: Result
	 */
	Result createNewCustomer(BussiCustomerForm form);
	/**
	 * @Title: updateCustomer
	 * @author: Mr.T   
	 * @date: 2019年12月2日 上午9:34:22 
	 * @Description: 更新客户信息
	 * @param form
	 * @return
	 * @return: Result
	 */
	Result updateCustomer(BussiCustomerForm form);

}
