package com.sxt.bussi.service;

import com.sxt.bussi.form.BusCarsForm;
import com.sxt.bussi.form.BusRentsForm;
import com.sxt.common.Result;
import com.sxt.common.base.BaseForm;
import com.sxt.common.base.BaseQuery;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.IBaseService;

public interface IBussiBusCarsService extends IBaseService<BaseForm, BaseQuery, BaseVO> {
	/**
	 * @Title: createNewCars
	 * @author: Mr.T   
	 * @date: 2019年12月2日 上午11:42:29 
	 * @Description: 新增车辆信息
	 * @param form
	 * @return
	 * @return: Result
	 */
	Result createNewCars(BusCarsForm form);
	/**
	 * @Title: updateCarInfo
	 * @author: Mr.T   
	 * @date: 2019年12月2日 下午2:41:28 
	 * @Description: 修改车辆信息
	 * @param form
	 * @return
	 * @return: Result
	 */
	Result updateCarInfo(BusCarsForm form);
	/**
	 * @Title: rentCar
	 * @author: Mr.T   
	 * @date: 2019年12月2日 下午5:42:35 
	 * @Description: 出租车辆
	 * @param form
	 * @return
	 * @return: Result
	 */
	Result rentCar(BusRentsForm form);

}
