
记录重要的内容

2020年7月18日
1、window.location.href = "/system/index";通过js的BOM操作 进行跳转

2020年7月14日

第四天我们写了轮播图，进行轮播图列表展示，分页，高级查询，文件上传（添加）
我们还修改了文章编辑框，使用了富文本，使添加文章的时候可以有更多的格式ueditor
设置了文章的点击次数，刷新文章，次数+1


第三天学习了页面静态化技术，将数据库的数据展示到前端页面。我们使用到的技术是freeMaker
FreeMarker是一款模板引擎： 即一种基于模板和要改变的数据
全称：FreeMarker Template Language (FTL)
	模板是以.ftl为后缀的
实现步骤	
重要：模板(.ftl)和数据(Map对象或Java实体   ，但是List集合不行)
1.导入freemarker.jar
2.获取模板(Template)对象
	获取Configuration对象 -- 为了获取模板对象
	设置默认加载路径
	设置默认编码
	获取模板
3.准备数据
	map
	java实体对象
4.template.process()生成静态资源
5.创建xxx.ftl模板
	模板中使用el表达式获取数据
6.测试运行


第二天
高级查询、文章数据的增删改查（botostrp的模态框）


第一天
使用GridManager进行列表展示，分页查询




2020年07月09日
要点：radio  单选  value值只能传0 false或1 true  如果后台

bean属性中尽量使用包装类  因为包装类的值为null  基本类型有具体的值


添加和保存的时候
//清空表单，因为修改和添加使用的是同一个模态框，添加数据之后点击取消，再点击添加和修改还是以前的数据，所以需要清空
$("#saveForm").get(0).reset();
//可以使用Dom对象的reset()方法，也可以使用jQuery的clearFrom()方法
//$("saveForm").clearFrom();
//操作表单的时候，隐藏域需要手动清空，不然添加和修改要出错,表示saveForm  下面有个id=id的元素
$("#saveForm #id").val("");


//row表示当前行的对象
//将json对象转成json的字符串
var jsonStr = JSON.stringify(row);
//将json字符串转成json的对象
var jsonObj = JSON.parse(row);



1、表格table设置属性
<table id='table-demo-ajaxPageCode'></table>

2、gridManager 显示列表信息， 接收的参数类型为data类型的集合数据  和 totals查询的数据总条数，为了方便调用，我们将两个参数封装到 了
PageBean对象中，只需要调用即可

3、在进行分页的过程中，因为大多数地方都会用到分页查询，所以我们将localPage 和  pageSize 封装到BaseQuery  中作为公共的查询条件
让ArticleQuery文章模块继承BaseQuery，在ArticleQuery中可以设置文章模块单独的查询属性，用于高级查询
添加一个getBegin方法的begin属性 用于计算localPage  直接传入
/**当前页 */
private Integer localPage;
/**每页显示的条数 */
private Integer pageSize;
作用:设置bean属性
public Integer getBegin() {
	//设置分页查询的第一个参数
	return (this.localPage-1)*this.pageSize;
}
sql语句
<select id="findAll" resultType="Article">
select * from t_article 
<include refid="query"></include>
limit #{begin},#{pageSize}
</select>


//需要导入jQuery的插件，所以之间必须先引入jQuery
	<script src="/static/system/js/jquery.jdirk.js"></script>
	<script src="/static/system/js/form-load.js"></script>
	<script src="/static/system/js/jquery-form.js"></script>
	
//使用serializeObject()方法;自动接收表单数据，转化为json格式
var jsonForm = $("#queryForm").serializeObject();
//GridManager调用静态方法setQuery将数据传递到后台，'demo-baseCode'是
//GridManager的名字，jsonForm  json格式的数据
GridManager.setQuery('demo-ajaxPageCode', jsonForm);






设置gridManager显示表格的参数和分页设置
<script type="text/javascript">
		document
				.querySelector('#table-demo-ajaxPageCode')
				.GM(
						{
							gridManagerName : 'demo-ajaxPageCode', //gridManager的名称
							ajaxData : '/system/article/list', //请求路径 -自动发送的ajax请求
							ajaxType : 'POST',//请求方法
							supportAjaxPage : true, //是否支持分页
							currentPageKey : "localPage", //当前页
							pageSizeKey : "pageSize", //每页显示的条数
							sizeData : [ 5, 10, 15, 20 ], //分页的选项
							pageSize : 5, //默认每页显示多少条
							height:'100%', //显示全部高度 
							columnData : [ //列的数据 -- 返回的json数据对应
									{
										key : 'title',
										text : '文章标题',
										align : 'center'
									},
									{
										key : 'type',
										text : '文章类型',
										align : 'center',
										template : function(cell, row, index,
												key) {
											//返回的是一个json格式的数据，我们需要其中的name属性的值直接cell.name, cell表示该json对象
											return cell.name;
										} 
									},
									{
										key : 'clickCount',
										text : '浏览次数',
										align : 'center'
									},
									{
										key : 'createDate',
										text : '创建时间',
										align : 'center'
									},
									{
										key : 'enable',
										text : '启用状态',
										align : 'center',
										//cell:当前key对应的值   ，row：当前行对象 ，index，当前对象的下标 ，key就是当前值
										template : function(cell, row, index,
												key) {
											return cell ? "<span style='color:green'>启用</span>"
													: "<span style='color:red'>禁用</span>";
										}
									},
									{
										key : 'id',
										text : '操作&emsp;<a href="javascript:;" style="color:green">添加</a>',
										align : 'center',
										template : function(cell, row, index,
												key) {
											return '<a href="javascript:;" style="color:orange">修改</a>&emsp;<a href="javascript:;" style="color:red">删除</a>';
										}
									} ]
						});
	</script>
	
	4、在文章bean属性中，我们设置了字段的文章类型，因为是两张表，所以我们是将，文章类型的表传进来，我们根据遍历获取到的typeid，在去文章类型表中查询，返回文章类型
	在将查询到的文章类型的值设置到文章表的文章类型中
	//接收到查询的数据
		List<Article> articles = mapper.findAll(query);
		//循环遍历数据
		for (Article article : articles) {
			//获取文章类型的id
			Long typeId = article.getTypeId();
			//通过获取到的文章类型id去查询文章类型
			ArticleType type = typeMapper.findTypeById(typeId);
			//将查询到的类型给文章数据中的类型赋值
			article.setType(type);
			
		}
		
		
		5、通过传入的ArticleQuery query 对象中的参数查询totals  
		判断返回的数据条数
		//根据条件进行查询
		Integer totals = mapper.findCount(query);
		//如果查询到的数据为0
		if (totals == 0) {
			//返回数据
			return new PageBean<>();
		}
		因为在PageBean中给字段设置了值，如果查询的数据等于0 ，就直接返回PageBean<>()对象，显示0条数据
	
6、动态生成的按钮，我们需要使用委托事件进行事件的绑定，在使用模态框中按钮进行事件的绑定的时候，需要先清除该按钮的所有事件。
//取消所有事件
$("#delModalButton").off();
$("#delModalButton").unbind();
//绑定事件
$("#delModalButton").on();
$("#delModalButton").bind();

7、GridManager中常用
GridManager.refreshGrid('demo-ajaxPageCode');//刷新表格

8、	
//需要导入jQuery的插件，所以之间必须先引入jQuery
<script src="/static/system/js/jquery.jdirk.js"></script>
<script src="/static/system/js/form-load.js"></script>
<script src="/static/system/js/jquery-form.js"></script>
//重置
$("#saveForm").get(0).reset();
//获取回显的数据
var jsonObj = $(this).data("obj");
//显示到模态框
$("#saveForm").setForm(jsonObj);
//显示模态框
$("#saveModal").modal("show");

//将表单中的数据【表单项必须有name属性值】以Ajax的异步请求的方式进行提交//请求就是表单的action的属性值
				$("#saveForm").ajaxSubmit({
					success : function(msg) { //回调函数
						//判断返回的json格式的数据
						if(msg.success){
							//关闭删除模态框
							$("#saveModal").modal("hide");
							//刷新表格
							GridManager.refreshGrid('demo-ajaxPageCode');
						}else{
							//关闭删除模态框
							$("#saveModal").modal("hide");
							//弹出提示信息
							alert(msg.msg);
						}
					}
	

记录重要的内容

2020年7月14日


第五天
后台登录，登录拦截，回车登录，登录注销，session创建和销毁，前台轮播图显示，记住我

按回车键登录
//e表示事件源 - 引发这次事件的源头 keyCode是它的属性
$(document).on('keypress',function(e){
	if(e.keyCode==13){//回车键是13
		login();
	}
});

记住我勾选
<input type="checkbox" name="remeber" value="1"/>如果选中复选框，后台获取为1；如果不选中，后台获取为null

登录后台接收使用Integer remeber  包装类 返回null

//记住我
if(remeber != null){//用户点击了记住我
	//获取cookie
	Cookie c1 = new Cookie(Constant.USERNAME,username);
	Cookie c2 = new Cookie(Constant.PASSWORD,password);
	//设置作用域范围到根路径下面
	c1.setPath("/");
	c2.setPath("/");
	//设置cookie保存七天
	c1.setMaxAge(7*24*60*60);//7天
	c2.setMaxAge(7*24*60*60);//7天
	//将cookie响应保存			
	resp.addCookie(c1);
	resp.addCookie(c2);
}

前台获取后台响应的cookie
//前台js获取Cookie，获取到的cookie有很多，整个文档中的cookie
var cookies = document.cookie;
//console.debug(cookies);//username=admin; password=Admin
//判断获取到的cookie中是否包含用户名和密码，如果有username或者password，表示点击了记住我
if(cookies.indexOf("username")!=-1){//cookies中有username的信息 = 点击记住我
	//将cookie通过；分号进行分割
	var cookieArray = cookies.split(";");
	//在外面声明username和password，方便调用
	var username = null;
	var password = null;
	//循环遍历分割后获取到的数组
	for(var index in cookieArray){
		//如果遍历到的数组中包含username
		if(cookieArray[index].indexOf("username")!=-1){//代表数组中的这个元素有username的信息
			//我们就截取最后一个=后面的值，不包含=
			username = cookieArray[index].substring(cookieArray[index].lastIndexOf("=")+1);
					}
		if(cookieArray[index].indexOf("password")!=-1){//代表数组中的这个元素有password的信息
			password = cookieArray[index].substring(cookieArray[index].lastIndexOf("=")+1);
		}
	}
	//给登录的表单赋值			
	$("input[name='username']").val(username);
	$("input[name='password']").val(password);
	//勾选记住我
	$("input[name='remember']").prop("checked",true);
}

取消记住我
else{
	//获取到cookie数组
	Cookie[] cookies = req.getCookies();
	//循环遍历数组
	for (Cookie cookie : cookies) {
		System.out.println(cookie.getName());
		//避免将jseesionid删除了  
		//判断获取到的cookie中是否包含username和password
		if(cookie.getName().equals(Constant.USERNAME) || cookie.getName().equals(Constant.PASSWORD) ){
			//清除cookie
			cookie.setMaxAge(0);//清除Cookie
			//清除了也要设置根路径有效才能实现，因为不光是在当前路径下删除，再其他所有的路径下都要删除
			cookie.setPath("/");
			//响应保存
			resp.addCookie(cookie);
		}
	}
}





9、富文本清空
<!-- 加载编辑器的容器   富文本-->
<script id="container" name="content" type="text/plain"></script>

 <!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('container',{
    	initialFrameHeight: '200', /* 自定义富文本的高度 */
    	zIndex:'9999'/* 设置添加图片和表情包的弹框到最上层 */
    });
</script>

//手动清空富文本
var ue = UE.getEditor('container'); //获取富文本
ue.ready(function() { 
	ue.setContent(""); 
}); 

//操作：回显富文本的内容
var ue = UE.getEditor('container'); //获取富文本
ue.ready(function() { 
	ue.setContent(jsonObj.content); 
}); 




第四天我们写了轮播图，进行轮播图列表展示，分页，高级查询，文件上传（添加）
我们还修改了文章编辑框，使用了富文本，使添加文章的时候可以有更多的格式ueditor
设置了文章的点击次数，刷新文章，次数+1


第三天学习了页面静态化技术，将数据库的数据展示到前端页面。我们使用到的技术是freeMaker
FreeMarker是一款模板引擎： 即一种基于模板和要改变的数据
全称：FreeMarker Template Language (FTL)
	模板是以.ftl为后缀的
实现步骤	
重要：模板(.ftl)和数据(Map对象或Java实体   ，但是List集合不行)
1.导入freemarker.jar
2.获取模板(Template)对象
	获取Configuration对象 -- 为了获取模板对象
	设置默认加载路径
	设置默认编码
	获取模板
3.准备数据
	map
	java实体对象
4.template.process()生成静态资源
5.创建xxx.ftl模板
	模板中使用el表达式获取数据
6.测试运行


第二天
高级查询、文章数据的增删改查（botostrp的模态框）


第一天
使用GridManager进行列表展示，分页查询




2020年07月09日
要点：radio  单选  value值只能传0 false或1 true  如果后台

bean属性中尽量使用包装类  因为包装类的值为null  基本类型有具体的值


添加和保存的时候
//清空表单，因为修改和添加使用的是同一个模态框，添加数据之后点击取消，再点击添加和修改还是以前的数据，所以需要清空
$("#saveForm").get(0).reset();
//可以使用Dom对象的reset()方法，也可以使用jQuery的clearFrom()方法
//$("saveForm").clearFrom();
//操作表单的时候，隐藏域需要手动清空，不然添加和修改要出错,表示saveForm  下面有个id=id的元素
$("#saveForm #id").val("");


//row表示当前行的对象
//将json对象转成json的字符串
var jsonStr = JSON.stringify(row);
//将json字符串转成json的对象
var jsonObj = JSON.parse(row);



1、表格table设置属性
<table id='table-demo-ajaxPageCode'></table>

2、gridManager 显示列表信息， 接收的参数类型为data类型的集合数据  和 totals查询的数据总条数，为了方便调用，我们将两个参数封装到 了
PageBean对象中，只需要调用即可

3、在进行分页的过程中，因为大多数地方都会用到分页查询，所以我们将localPage 和  pageSize 封装到BaseQuery  中作为公共的查询条件
让ArticleQuery文章模块继承BaseQuery，在ArticleQuery中可以设置文章模块单独的查询属性，用于高级查询
添加一个getBegin方法的begin属性 用于计算localPage  直接传入
/**当前页 */
private Integer localPage;
/**每页显示的条数 */
private Integer pageSize;
作用:设置bean属性
public Integer getBegin() {
	//设置分页查询的第一个参数
	return (this.localPage-1)*this.pageSize;
}
sql语句
<select id="findAll" resultType="Article">
select * from t_article 
<include refid="query"></include>
limit #{begin},#{pageSize}
</select>


//需要导入jQuery的插件，所以之间必须先引入jQuery
	<script src="/static/system/js/jquery.jdirk.js"></script>
	<script src="/static/system/js/form-load.js"></script>
	<script src="/static/system/js/jquery-form.js"></script>
	
//使用serializeObject()方法;自动接收表单数据，转化为json格式
var jsonForm = $("#queryForm").serializeObject();
//GridManager调用静态方法setQuery将数据传递到后台，'demo-baseCode'是
//GridManager的名字，jsonForm  json格式的数据
GridManager.setQuery('demo-ajaxPageCode', jsonForm);






设置gridManager显示表格的参数和分页设置
<script type="text/javascript">
		document
				.querySelector('#table-demo-ajaxPageCode')
				.GM(
						{
							gridManagerName : 'demo-ajaxPageCode', //gridManager的名称
							ajaxData : '/system/article/list', //请求路径 -自动发送的ajax请求
							ajaxType : 'POST',//请求方法
							supportAjaxPage : true, //是否支持分页
							currentPageKey : "localPage", //当前页
							pageSizeKey : "pageSize", //每页显示的条数
							sizeData : [ 5, 10, 15, 20 ], //分页的选项
							pageSize : 5, //默认每页显示多少条
							height:'100%', //显示全部高度 
							columnData : [ //列的数据 -- 返回的json数据对应
									{
										key : 'title',
										text : '文章标题',
										align : 'center'
									},
									{
										key : 'type',
										text : '文章类型',
										align : 'center',
										template : function(cell, row, index,
												key) {
											//返回的是一个json格式的数据，我们需要其中的name属性的值直接cell.name, cell表示该json对象
											return cell.name;
										} 
									},
									{
										key : 'clickCount',
										text : '浏览次数',
										align : 'center'
									},
									{
										key : 'createDate',
										text : '创建时间',
										align : 'center'
									},
									{
										key : 'enable',
										text : '启用状态',
										align : 'center',
										//cell:当前key对应的值   ，row：当前行对象 ，index，当前对象的下标 ，key就是当前值
										template : function(cell, row, index,
												key) {
											return cell ? "<span style='color:green'>启用</span>"
													: "<span style='color:red'>禁用</span>";
										}
									},
									{
										key : 'id',
										text : '操作&emsp;<a href="javascript:;" style="color:green">添加</a>',
										align : 'center',
										template : function(cell, row, index,
												key) {
											return '<a href="javascript:;" style="color:orange">修改</a>&emsp;<a href="javascript:;" style="color:red">删除</a>';
										}
									} ]
						});
	</script>
	
	4、在文章bean属性中，我们设置了字段的文章类型，因为是两张表，所以我们是将，文章类型的表传进来，我们根据遍历获取到的typeid，在去文章类型表中查询，返回文章类型
	在将查询到的文章类型的值设置到文章表的文章类型中
	//接收到查询的数据
		List<Article> articles = mapper.findAll(query);
		//循环遍历数据
		for (Article article : articles) {
			//获取文章类型的id
			Long typeId = article.getTypeId();
			//通过获取到的文章类型id去查询文章类型
			ArticleType type = typeMapper.findTypeById(typeId);
			//将查询到的类型给文章数据中的类型赋值
			article.setType(type);
			
		}
		
		
		5、通过传入的ArticleQuery query 对象中的参数查询totals  
		判断返回的数据条数
		//根据条件进行查询
		Integer totals = mapper.findCount(query);
		//如果查询到的数据为0
		if (totals == 0) {
			//返回数据
			return new PageBean<>();
		}
		因为在PageBean中给字段设置了值，如果查询的数据等于0 ，就直接返回PageBean<>()对象，显示0条数据
	
6、动态生成的按钮，我们需要使用委托事件进行事件的绑定，在使用模态框中按钮进行事件的绑定的时候，需要先清除该按钮的所有事件。
//取消所有事件
$("#delModalButton").off();
$("#delModalButton").unbind();
//绑定事件
$("#delModalButton").on();
$("#delModalButton").bind();

7、GridManager中常用
GridManager.refreshGrid('demo-ajaxPageCode');//刷新表格

8、	
//需要导入jQuery的插件，所以之间必须先引入jQuery
<script src="/static/system/js/jquery.jdirk.js"></script>
<script src="/static/system/js/form-load.js"></script>
<script src="/static/system/js/jquery-form.js"></script>
//重置
$("#saveForm").get(0).reset();
//获取回显的数据
var jsonObj = $(this).data("obj");
//显示到模态框
$("#saveForm").setForm(jsonObj);
//显示模态框
$("#saveModal").modal("show");

//将表单中的数据【表单项必须有name属性值】以Ajax的异步请求的方式进行提交//请求就是表单的action的属性值
				$("#saveForm").ajaxSubmit({
					success : function(msg) { //回调函数
						//判断返回的json格式的数据
						if(msg.success){
							//关闭删除模态框
							$("#saveModal").modal("hide");
							//刷新表格
							GridManager.refreshGrid('demo-ajaxPageCode');
						}else{
							//关闭删除模态框
							$("#saveModal").modal("hide");
							//弹出提示信息
							alert(msg.msg);
						}
					}
	
