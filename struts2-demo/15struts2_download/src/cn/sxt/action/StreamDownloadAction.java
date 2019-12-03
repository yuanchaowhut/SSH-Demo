package cn.sxt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class StreamDownloadAction {
	private String fileName;
	public String execute(){
		return Action.SUCCESS;
	}
	public InputStream getInputStream() throws FileNotFoundException{
		HttpServletRequest req=ServletActionContext.getRequest();
		//��ȡ·��
		String path=req.getRealPath("/download");
		return new FileInputStream(new File(path,fileName));
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
