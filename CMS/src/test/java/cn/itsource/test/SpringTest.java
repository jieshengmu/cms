package cn.itsource.test;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itsource.domain.ArticleType;
import freemarker.template.Configuration;
import freemarker.template.Template;
@ContextConfiguration("classpath:applicationContext.xml")//加载spring的配置文件
@RunWith(SpringJUnit4ClassRunner.class)//开启spring测试
public class SpringTest {
	@Autowired//依赖注入，会根据当前字段的类型进行查找，并赋值
	private Date now;
	
	@Test
	public void testTime() throws Exception {
		//打印当前系统时间
		System.out.println(now);
	}
	
	
	
	
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
		ArticleType type = new ArticleType(1L,"大好河山","m哦哦哦y");
		
		//7、template.process(type, out);生成静态资源
		//获取输出流，确定输出的位置
		FileWriter out = new FileWriter(new File(file,"test.html"));
		template.process(type, out);
		//8、关流
		out.close();
		//9、测试
		
	
	
	
	
	
	
	
	}
	
	
	

}
