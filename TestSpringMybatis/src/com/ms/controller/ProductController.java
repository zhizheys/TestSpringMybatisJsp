package com.ms.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ms.controller.viewmodel.Product;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
	private static final Log logger = LogFactory.getLog(ProductController.class);

	@RequestMapping(value = "/product_input", method = RequestMethod.GET)
	public ModelAndView inputProduct() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("product", new Product());
		modelAndView.setViewName("book/addproduct");

		return modelAndView;
	}

	//通过表单上传多少个文件
	@RequestMapping(value = "/product_save", method = RequestMethod.POST)
	@ResponseBody
	public String saveProduct(HttpServletRequest servletRequest, @ModelAttribute Product product,
			BindingResult bindingResult, Model model) {
		List<MultipartFile> files = product.getImages();
		System.out.println("文件数量是" + files.size());
		if (null != files && files.size() > 0) {
			for (MultipartFile file : files) {
				String fileName = file.getOriginalFilename(); // 获得文件名称
				//String filePath=servletRequest.getServletContext().getRealPath("/static/images");
				String filePath="E:" + File.separator + "Test";
				
				File imagFile = new File(filePath, fileName);
				try {
					file.transferTo(imagFile);// 用于将文件写到服务器本地
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		model.addAttribute("product", product);
		
		return "success";
	}
}