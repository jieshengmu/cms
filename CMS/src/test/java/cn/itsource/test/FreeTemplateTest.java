package cn.itsource.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itsource.domain.ArticleType;
import cn.itsource.util.FreeMakerUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
/**
 * @Title: FreeTemplateTest.java
 * @author:牟胜杰
 * @Package:cn.itsource.test
 * @Description:(作用)
 * @date:2020年7月12日 下午2:46:14
 * @version:V1.0  
 */
@ContextConfiguration("classpath:applicationContext.xml")//加载spring的配置文件
@RunWith(SpringJUnit4ClassRunner.class)//开启spring对junit的支持
public class FreeTemplateTest {
	@Test
	public void testFreeTemplate() throws Exception {
		
		//1、导入freetemplate.jar
		
		//2、获取到Configuration对象，为了获取模板
		Configuration config = new Configuration(Configuration.VERSION_2_3_28);
		//3、设置默认加载路径
		File file = new File("src/main/webapp/static/template");
		config.setDirectoryForTemplateLoading(file);
		//4、设置默认编码
		config.setDefaultEncoding("UTF-8");
		
		//5、获取模板
		Template template = config.getTemplate("test.ftl");
		
		//6、准备数据
		//map对象
		//Java实体对象
		ArticleType type = new ArticleType(1L,"大好河山","mondy");
		
		//7、template.process(type, out);生成静态资源
		//获取输出流，确定输出的位置
		FileWriter out = new FileWriter(new File(file,"test.html"));
		template.process(type, out);
		//8、关流
		out.close();
		//9、测试
		
		
		
	}
	@Test
	public void testFreeTemplateMap() throws Exception {
		
		//1、导入freetemplate.jar
		//2、获取到Configuration对象,添加版本号，为了获取模板
		Configuration config = new Configuration(Configuration.VERSION_2_3_28);
		//3、设置默认加载路径
		File file = new File("src/main/webapp/static/template");
		config.setDirectoryForTemplateLoading(file);
		//4、设置默认编码
		config.setDefaultEncoding("UTF-8");
		
		//5、获取模板名字
		Template template = config.getTemplate("test.ftl");
		
		//6、准备数据
		//map对象
		Map<String, Object> map = new HashMap<>();
		map.put("name", "万水千山总是情");
		map.put("code", "卡你会不会零七");
		//Java实体对象
		//7、template.process(type, out);生成静态资源
		//获取输出流，确定输出的位置
		FileWriter out = new FileWriter(new File(file,System.currentTimeMillis() + ".html"));
		template.process(map, out);
	
		//8、关流
		out.close();
		//9、测试
		
		
		
	}
	
	
	@Test
	public void testUtil() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "万水千山总是情");
		map.put("age", 19);
		
		List<String> starts = new ArrayList<String>();
		starts.add("张三");
		starts.add("李四");
		starts.add("王五");
		starts.add("秋儿");
		
		map.put("starts", starts);
		
		String url = FreeMakerUtil.createFile("src/main/webapp/static/template", "test.ftl", map, ".html");
		
		System.out.println(url);
		
	}
	
}
