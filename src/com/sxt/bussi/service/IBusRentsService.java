package com.sxt.bussi.service;

import com.sxt.bussi.form.BusChecksForm;
import com.sxt.common.Result;
import com.sxt.common.base.BaseForm;
import com.sxt.common.base.BaseQuery;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.IBaseService;

public interface IBusRentsService extends IBaseService<BaseForm, BaseQuery, BaseVO> {
	/**
	 * @Title: returnCar
	 * @author: Mr.T   
	 * @date: 2019年12月3日 上午10:33:20 
	 * @Description: 还车
	 * @param form
	 * @return
	 * @return: Result
	 */
	Result returnCar(BusChecksForm form);

}
