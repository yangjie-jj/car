package com.sxt.common.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.sxt.common.Constant;
import com.sxt.common.base.BaseForm;
import com.sxt.common.exception.BussiException;

/**
 * @ClassName: ValidatorUtil 
 * @Description: 数据校验器 校验数据的合法性
 * @author: Mr.T
 * @date: 2019年11月29日 下午2:05:01
 */
public class ValidatorUtil {
	/**
	 *  数据校验器
	 */
	static final Validator validator ;
	static {
		// 获取一个数据校验器
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	/**
	 * @Title: validator
	 * @author: Mr.T   
	 * @date: 2019年11月29日 下午2:10:11 
	 * @Description: 具体的校验方法
	 * @param form
	 * @return: void
	 */
	public static void validator(BaseForm form) {
		
		Set<ConstraintViolation<BaseForm>> validate = validator.validate(form);
		
		for (ConstraintViolation<BaseForm> constraintViolation : validate) {
			// 校验不通过的信息
			String message = constraintViolation.getMessage();
			// 校验不通过 抛出异常
			throw new BussiException(Constant.FORM_DATA_CHECK_ERROR_CODE, message);
		}
		
	}

}
