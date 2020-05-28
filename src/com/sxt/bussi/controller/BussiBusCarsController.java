package com.sxt.bussi.controller;

import com.sxt.bussi.form.BusCarsForm;
import com.sxt.bussi.form.BusRentsForm;
import com.sxt.bussi.query.BusCarsQuery;
import com.sxt.bussi.service.IBussiBusCarsService;
import com.sxt.common.Result;
import com.sxt.common.util.WebUtil;
import com.sxt.common.validator.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/bussi/car")
public class BussiBusCarsController {
	@Autowired
	private IBussiBusCarsService bussiBusCarsService;
	
	@RequestMapping("/list.do")
	public Object list(BusCarsQuery query) {
		return bussiBusCarsService.queryPage(query);
	}
	
	
	@RequestMapping("/add.do")
	public Object add(BusCarsForm form, MultipartFile carImg) throws IllegalStateException, IOException {
		ValidatorUtil.validator(form);
		// 保存图片
		// 将图片的网络路径 存在 数据库
		//找到保存图片的文件夹
		String path = WebUtil.getServletContext().getRealPath("uploadImg");
		String fileName = carImg.getOriginalFilename();// 获取文件名
		fileName = UUID.randomUUID().toString()+ fileName;
		File file = new File(path+File.separator+fileName);
		//保存文件
		carImg.transferTo(file);
		form.setImg("uploadImg/"+fileName);
		Result rs = bussiBusCarsService.createNewCars(form);
		return rs;
	}
	
	@RequestMapping("/update.do")
	public Object update(BusCarsForm form, MultipartFile carImg) throws IllegalStateException, IOException {
		ValidatorUtil.validator(form);
		// 保存图片
		// 将图片的网络路径 存在 数据库 
		//找到保存图片的文件夹
		String path = WebUtil.getServletContext().getRealPath("uploadImg");
		String fileName = carImg.getOriginalFilename();// 获取文件名
		fileName = UUID.randomUUID().toString()+ fileName;
		File file = new File(path+File.separator+fileName);
		//保存文件
		carImg.transferTo(file);
		form.setImg("uploadImg/"+fileName);
		Result rs = bussiBusCarsService.updateCarInfo(form);
		return rs;
	}
	
	@RequestMapping("/rent.do")
	public Object rent(BusRentsForm form) {
		/**
		 * 1. 新增1条数租车记录
		 * 2. 修改当前车辆的状态 : 
		 */
		Result rs = bussiBusCarsService.rentCar(form);
		return rs;
	}
}
