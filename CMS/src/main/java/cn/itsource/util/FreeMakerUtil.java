package cn.itsource.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @Title: FreeMakerUtil.java
 * @author:牟胜杰
 * @Package:cn.itsource.util
 * @Description:(作用FreeMakerUtil工具类，方便调用)
 * @date:2020年7月12日 下午3:41:58
 * @version:V1.0  
 */
public class FreeMakerUtil {
	
	
	/**
	 * @Description:(作用:)
	 * @param:@param templatePath    模板路径
	 * @param:@param templateName	 模板名称	
	 * @param:@param data			数据
	 * @param:@param suffix			后缀
	 * @param:@return   			返回生成文件的名称
	 * @return:String      			返回值类型  
	 * @author:牟胜杰
	 * @date:2020年7月12日下午3:43:43
	 * @version:V1.0
	 */
	public static String createFile(String templatePath,String templateName,Object data,String suffix) {
		//为了关流，声明到外面
		FileWriter out = null;
				try {
					
					//1、导入freetemplate.jar
					//2、获取到Configuration对象,添加版本号，为了获取模板
					Configuration config = new Configuration(Configuration.VERSION_2_3_28);
					//3、设置默认加载路径
					File file = new File(templatePath);
					config.setDirectoryForTemplateLoading(file);
					//4、设置默认编码
					config.setDefaultEncoding("UTF-8");
					//5、获取模板名字
					Template template = config.getTemplate(templateName);
					//6、准备数据
					//map对象
					//Java实体对象
					//7、template.process(type, out);生成静态资源
					//设置文件输出的名称
					String url = System.currentTimeMillis() + suffix;
					//获取输出流
					out = new FileWriter(new File(file,url));
					template.process(data, out);
					return url;
				} catch (IOException | TemplateException e) {
					e.printStackTrace();
				}finally {
					if (out != null) {
						try {
							//8、关流
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				return null;
	}
}
