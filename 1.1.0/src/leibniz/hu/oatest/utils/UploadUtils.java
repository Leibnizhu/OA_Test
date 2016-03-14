package leibniz.hu.oatest.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

public class UploadUtils {
	
	public static String saveUploadFile(File upload){
		//把日期类型格式化为"/yyyy/MM/dd/"格式
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		String basePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		String subPath = sdf.format(new Date());
		//如果文件夹不存在，就创建文件夹
		File dir = new File(basePath+subPath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		String path = basePath+subPath+UUID.randomUUID().toString();
		File dest = new File(path);
		//把文件移动到dest处
		upload.renameTo(dest);
		return path;
	}
}
