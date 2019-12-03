package cn.sxt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	private File file;
	//�ļ���
	private String fileFileName;
	//�ļ�������
	private String fileContentType;
	//�ϴ�
	public String upload() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String path=request.getRealPath("/upload");
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(new File(path,fileFileName));
		byte[] buffer = new byte[200];
		int len=0;
		while((len=is.read(buffer))!=-1){
			os.write(buffer, 0, len);
		}
		os.close();
		is.close();
		
		return Action.SUCCESS;
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
}
