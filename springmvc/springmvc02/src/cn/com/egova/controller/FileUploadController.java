package cn.com.egova.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController implements ServletContextAware{
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@RequestMapping(value="upload.do",method=RequestMethod.POST)
	public String handleUpload(@RequestParam("file")CommonsMultipartFile cmf){
		if(!cmf.isEmpty()){
			String path = servletContext.getRealPath("/upload");
			System.out.println(path);
			String fileName = cmf.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			System.out.println(fileType);
			File file = new File(path,new Date().getTime()+fileType);
			try {
				cmf.getFileItem().write(file);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return "redirect:upload_ok.jsp";
		}else{
			return "redirect:upload_error.jsp";
		}
	}
}
