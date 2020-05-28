package com.sxt.bussi.controller;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxt.bussi.form.BussiCustomerForm;
import com.sxt.bussi.query.BussiCustomerQuery;
import com.sxt.bussi.service.IBussiCustomerService;
import com.sxt.bussi.vo.BussiCustomerVO;
import com.sxt.common.Result;
import com.sxt.common.validator.ValidatorUtil;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

@RestController
@RequestMapping("/bussi/customer")
public class BussiCustomerController {
	@Autowired
	private IBussiCustomerService bussiCustomerService;
	
	/**
	 * @Title: list
	 * @author: Mr.T   
	 * @date: 2019年11月30日 上午10:44:23 
	 * @Description: 分页查询客户
	 * @param query
	 * @return
	 * @return: Object
	 */
	@RequestMapping("/list.do")
	public Object list(BussiCustomerQuery query) {
		return bussiCustomerService.queryPage(query);
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/export.do")
	public void export(BussiCustomerQuery query,HttpServletResponse resp) throws IORuntimeException, IOException {
		Result rs = bussiCustomerService.queryList(query);
		List<BussiCustomerVO> data = (List<BussiCustomerVO>) rs.getData();
		// 创建 excel write 对象   : 与d://test.xlsx 绑定
		ExcelWriter writer = ExcelUtil.getWriter();
		//设置别名
		//自定义标题别名
		writer.addHeaderAlias("id", "ID");
		writer.addHeaderAlias("idCard", "身份证号");
		writer.addHeaderAlias("custName", "客户姓名");
		writer.addHeaderAlias("sex", "性别(1男2女)");
		writer.addHeaderAlias("address", "地址");
		writer.addHeaderAlias("phone", "手机号");
		writer.addHeaderAlias("position", "职位");
		writer.addHeaderAlias("createTime", "创建时间");
		// 合并单元格后的标题行，使用默认标题样式 : 此时excel的文件指针在 第一行 
		writer.merge(7, "客户名单");
		writer.write(data,true);
		resp.setContentType("application/vnd.ms-excel;charset=utf-8"); 
		//test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
		resp.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("客户名单.xls", "UTF-8")); 
		ServletOutputStream out = resp.getOutputStream(); 
		writer.flush(out, true);
		//释放资源
		writer.close();
		IoUtil.close(out);
	}
	
	
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2019年12月2日 上午9:13:48 
	 * @Description: 添加客户的方法
	 * @param form
	 * @return
	 * @return: Object
	 */
	@RequestMapping("/add.do")
	public Object add(BussiCustomerForm   form) {
		ValidatorUtil.validator(form);
		Result rs = bussiCustomerService.createNewCustomer(form);
		return rs;
		
	}
	
	@RequestMapping("/update.do")
	public Object update(BussiCustomerForm   form) {
		ValidatorUtil.validator(form);
		Result rs = bussiCustomerService.updateCustomer(form);
		return rs;
		
	}



}
