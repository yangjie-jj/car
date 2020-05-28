package com.sxt.common.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxt.common.Constant;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.extra.qrcode.QrCodeUtil;

@Controller
@RequestMapping("/common")
public class CheckCodeController {
	
	@RequestMapping("/checkCode.do")
	public void checkCode(HttpSession session,HttpServletResponse resp) throws IOException {
		
		CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 10);
		
		String code = captcha.getCode();
		//将验证码放入session
		session.setAttribute(Constant.CHECK_CODE, code);
		//将验证码 对外输出
		captcha.write(resp.getOutputStream());
		
	}
	
	@RequestMapping("/qrCode.do")
	public void qrCode(HttpSession session,HttpServletResponse resp) throws IOException {
		
		BufferedImage generate = QrCodeUtil.generate("http://www.baidu.com", 100, 100);
		// 将image输出
		ImageIO.write(generate, "jpg", resp.getOutputStream());
	}

}
