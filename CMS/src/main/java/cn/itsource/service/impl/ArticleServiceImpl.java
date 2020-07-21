package cn.itsource.service.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import cn.itsource.domain.Article;
import cn.itsource.domain.ArticleType;
import cn.itsource.mapper.ArticleMapper;
import cn.itsource.mapper.ArticleTypeMapper;
import cn.itsource.query.ArticleQuery;
import cn.itsource.service.IArticleService;
import cn.itsource.util.Constant;
import cn.itsource.util.FreeMakerUtil;
import cn.itsource.util.PageBean;

/**
 * @author 作者 E-mail:牟胜杰
 * @version 创建时间：2020年7月9日 上午10:36:52
 */
@Service//创建对象
public class ArticleServiceImpl implements IArticleService {
	@Autowired//依赖注入，会根据当前字段类型查找，给当前字段赋值
	private ArticleMapper mapper;
	@Autowired//依赖注入，会根据当前字段类型查找，给当前字段赋值
	private ArticleTypeMapper typeMapper;

	/**
	 * @Description:(作用:查询所有文章列表)
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月9日上午11:46:46
	 * @version:V1.0
	 */
	@Override
	public PageBean<Article> findAll(ArticleQuery query) { 
		//根据查询条件查询总条数
		Integer totals = mapper.findCount(query);
		//如果总条数为0，没有数据
		if (totals == 0) {
			return new PageBean<Article>();//0和空集合
		}

		//接收查询到的数据
		List<Article> articles = mapper.findAll(query);
		//循环遍历
		for (Article article : articles) {
			//获取文章类型id
			Long typeId = article.getTypeId();
			//根据id查询文章类型
			ArticleType articleType = typeMapper.findTypeById(typeId);
			//在文章列表中设置文章类型
			article.setType(articleType);
		}
		//返回有数据的PageBean
		return new PageBean<>(totals, articles);
	}


	/**
	 * @Description:(作用:传入id调用方法进行删除)
	 * @param:@param id   
	 * @author:牟胜杰
	 * @date:2020年7月10日下午1:19:19
	 * @version:V1.0
	 */
	@Override
	public void del(Long id,HttpServletRequest req) {
		//根据id查询对象
		Article article = mapper.findById(id);
		//获取article对象的url
		String url = article.getUrl();
		//删除数据库对象
		mapper.del(id);
		//获取到url路径
		String templatePath = req.getServletContext().getRealPath("/static/template");
		//创建文件对象
		File file = new File(templatePath,url);
		//判断静态资源文件是否存在
		if (file.exists()) {
			//存在则进行删除
			file.delete();
		}
	}


	/**
	 * @Description:(作用:作用:添加和修改)
	 * @param:@param article   
	 * @author:牟胜杰
	 * @date:2020年7月10日下午4:53:03
	 * @version:V1.0
	 */
	@Override
	public void save(Article article,HttpServletRequest req) {
		//通过相对路径获取模板的绝对路径
		String templatePath = req.getServletContext().getRealPath("/static/template");
		//将路径存入文件中
		File file = new File(templatePath);
		//如果文件夹不存在
		if (!file.exists()) {
			//就创建
			file.mkdirs();
		}
		//调用FreeMakerUtil工具类生成静态资源，返回文件名url
		String url = FreeMakerUtil.createFile(templatePath, "article.ftl", article, ".html");
		//将获取到的url设置进对象，保存到数据库
		article.setUrl(url);

		//通过判断传过来的对象的id值是否为null，为null为添加，不为null为修改
		if (article.getId() == null) {
			//添加
			mapper.add(article);
		}else{
			//根据id查询对象
			Article dbArticle = mapper.findById(article.getId());
			//修改
			mapper.update(article);
			
			//获取url2
			String url2 = dbArticle.getUrl();
			if (url2 != null) {
				//创建文件对象
				File file1 = new File(templatePath,url2);
				//判断静态资源文件是否存在
				if (file1.exists()) {
					//存在则进行删除
					file1.delete();
				}
				
			}
		}

	}


	/**
	 * @Description:(作用:查询前台显示数据)
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月12日上午11:10:17
	 * @version:V1.0
	 */
	@Override
	public Map<String, Object> getArticles() {
		//创建map集合
		Map<String, Object> map = new HashMap<>();
		//技术文章
		List<Article> data1 = mapper.findArticleByCode(Constant.TECHNOLOGY);
		map.put(Constant.TECHNOLOGY, data1);
		//行业新闻
		List<Article> data2 = mapper.findArticleByCode(Constant.INDUSTRY);
		map.put(Constant.INDUSTRY, data2);
		//学科资讯
		List<Article> data3 = mapper.findArticleByCode(Constant.SUBJECT);
		map.put(Constant.SUBJECT, data3);
		//返回map集合
		return map;
	}


	/**
	 * @Description:(作用:根据url查询文章添加点击次数)
	 * @param:@param url
	 * @param:@return   
	 * @author:牟胜杰
	 * @date:2020年7月13日上午10:06:56
	 * @version:V1.0
	 */
	@Override
	public Article updateClickCount(String url) {
		//根据url去数据库查询，返回一个数据库对象
		Article dbArticle =  mapper.findByUrl(url);
		//获取该文章的点击次数，在重新设置该文章的点击次数+1
		dbArticle.setClickCount(dbArticle.getClickCount() + 1);
		//更新到数据库
		mapper.update(dbArticle);
		//返回对象
		return dbArticle;
	}
}
