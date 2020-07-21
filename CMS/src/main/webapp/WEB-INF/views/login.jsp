<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/WEB-INF/views/common/topStatic.jsp"%>
<title>CMS登陆</title>
</head>
<body>
	<section class="material-half-bg">
	<div class="cover"></div>
	</section>
	<section class="login-content">
	<div class="logo">
		<h1>cms后台登陆</h1>
	</div>
	<div class="login-box">
		<form class="login-form" method="post" action="/system/login">
			<h3 class="login-head">
				<i class="fa fa-lg fa-fw fa-user"></i>登陆&emsp;<span id="loginMsg"></span>
			</h3>
			<div class="form-group">
				<label class="control-label">用户名</label> <input class="form-control"
					type="text" name="username" placeholder="用户名" autofocus>
			</div>
			<div class="form-group">
				<label class="control-label">密码</label> <input class="form-control"
					type="password" name="password" placeholder="密码">
			</div>
			<div class="form-group">
				<div class="utility">
					<div class="animated-checkbox">
						<label> <input type="checkbox" name="remember" value="1"><span
							class="label-text">记住我</span>
						</label>
					</div>
				</div>
			</div>
			<div class="form-group btn-container">
				<button type="button" class="btn btn-primary btn-block loginBtn">
					<i class="fa fa-sign-in fa-lg fa-fw"></i>登陆
				</button>
			</div>
		</form>
	</div>
	</section>
	<%@include file="/WEB-INF/views/common/bottomStatic.jsp"%>
	<script type="text/javascript">
	$(function(){
		//点击登录按钮，发送请求
		$(".loginBtn").click(function(){
			login();
		});
		
		
		//点击回车登录
		$(document).on('keypress',function(e){//keyCode  代表键盘的键  e代表触发事件的源对象，简称事件源 
			if(e.keyCode == 13){
				login();
			}
			
		});
		
		//登录方法抽取 
		function login(){
			//通过表单发送ajaxSubmit请求，请求路径为action中的路径，方法为post  method
			$(".login-form").ajaxSubmit({
				success:function(msg){//回调函数
					if(msg.success){
					//登录成功进行跳转到后台首页
					location.href="/system/index";
					}else{
						//设置错误响应信息位置
						$("#loginMsg").html(msg.msg).css("color","red").css("fontSize","15px");
					}
				},
				dataType:"json"//指定服务器返回的数据类型，类似于$.ajax()中的dataType
			});
		}
		//获取username和password的cookie，如果存在就单独获取cookie的值，将值设置到表单中
		var cookies = document.cookie;//username=admin; password=123
		if(cookies.indexOf("username=") != -1){//字符串包含username，点了记住我
			//根据；分割字符串cookies，返回一个数组
			var arr = cookies.split(";")
			//声明username和password，赋值为null
			var username = null;
			var password = null;
			//循环遍历数组
			for (var s in arr){
				//判断数组中是否包含username
				if(arr[s].indexOf("username=") != -1){
					//包含我们就进行截取到=后面的值，不包含=，下标+1
				username = arr[s].substring(arr[s].lastIndexOf("=") +1);
				}
				//判断数组中是否包含password
				if(arr[s].indexOf("password=") != -1){
					//包含我们就进行截取到=后面的值，不包含=，下标+1
				password = arr[s].substring(arr[s].lastIndexOf("=") +1);
				}
			}
			
			//点了记住我，我们在将获取到的值设置到登录表单中,使用元素选择器
			$("input[name='username']").val(username);
			$("input[name='password']").val(password);
			//设置记住我为勾上单选和复选框用prop,其他用attr
			$("input[name='remember']").prop("checked",true);
		}else{
			//没有点了记住我，我们在将清空表单中的值,使用元素选择器
			$("input[name='username']").val("");
			$("input[name='password']").val("");
			//设置记住我为勾上单选和复选框用prop,其他用attr
			$("input[name='remember']").prop("checked",false);
		}
	});
	</script>
</body>
</html>
