<!-- 第一行是文档声明，表示这是一个HTML页面，告诉浏览器用HTML的语法解析渲染  -->
<!DOCTYPE html>
<!-- ctrl+shift+/ 取消是\  -->
<html>
<!-- 根标签 -->
<!-- html头标签，可以写字符集、标题、引用CSS、或者声明JS脚本、或者引用JS脚本其他解释内容等 
		现在一般JS引用或者JS声明不会写在头标签，一般写在body最后面
	-->
<head>
<meta charset="UTF-8">
<!-- 用来声明设置当前HTML的字符集  -->
<title>我的第一个HTML页面</title>
<!-- 设置当前HTML页面的标题 -->
</head>
<body>
	<!-- 写当前HTML页面的要显示的内容，即写的都是HTML的元素标签  -->
	<h1>${name}</h1>
	<#if age lt 18 > 未成年
	 <#elseif age gte 18 && age lt 40>
	努力奋斗 
	<#else> 年老了 
	</#if>

	<#list starts as start> ${start} </#list>


</body>
</html>