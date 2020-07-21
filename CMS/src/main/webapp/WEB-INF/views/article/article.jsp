<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CMS系统欢迎您</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 引入头部静态资源 -->
<!-- Main CSS-->
<%@include file="/WEB-INF/views/common/topStatic.jsp" %>
</head>
<body class="app sidebar-mini">
	<!-- 导航条-->
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<!-- 侧边栏 -->
	<%@include file="/WEB-INF/views/common/leftMenu.jsp" %>

	<!-- 中间显示内容的 -->
	<main class="app-content"> <!-- 高级查询 -->
	<div class="row app-title">
		<div class="col-md-12">
			<!-- 表单 -->
			<form id="queryForm" class="form-inline">
				<div class="form-group">
					<label for="title">标题：</label> <input type="text"
						class="form-control" name="title" id="title">
				</div>
				<div class="form-group" style="margin-left: 20px">
					<label>文章类型：</label> <select name="typeId" class="form-control"
						id="typeId">
						<option value="">请选择</option>
						<!-- 获取后台传过来的文章类型 -->
						<%--使用foreach标签需要先导入jstl的标签库和依赖包standard
						在jsp中导入核心标签库--%>
						<c:forEach items="${types}" var="t">
							<option value="${t.id}">${t.name}</option>
						</c:forEach>

					</select>
				</div>
				<div class="form-group" style="margin-left: 20px">
					<label>是否启用：</label> <select name="enable" class="form-control"
						id="enable">
						<option value="">请选择</option>
						<option value="1">启用</option>
						<option value="0">禁用</option>
					</select>
				</div>
				<button type="button" id="queryButton" class="btn btn-success"
					style="margin-left: 20px">查询</button>
			</form>
		</div>
	</div>

	<!-- 列表展示 -->
	<div class="row app-title">
		<div class="col-md-12  table-responsive">
			<!-- table表格显示 -->
			<table id='table-demo-ajaxPageCode'></table>
		</div>
	</div>
	<!-- 删除时的确认模态框 -->
	<div class="modal fade" id="delModal">
		<div class="modal-dialog">
			<div class="modal-content message_align">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<h5 style="color: red">您确认要删除吗？</h5>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<a href="javascript:void(0);" id="delModalButton"
						class="btn btn-success">确定</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

	<!-- 添加或者修改的模态框 -->
	<div class="modal fade bs-example-modal-lg" id="saveModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content message_align">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="/system/article/save" method="post"
						class="form-horizontal" id="saveForm">
						<input type="hidden" name="id" id="id">
						<div class="form-group row">
							<label for="title" class="control-label col-md-2">文章标题</label>
							<div class="col-md-10">
								<input class="form-control" type="text" name="title">
							</div>
						</div>
						<div class="form-group row">
							<label for="typeId" class="control-label col-md-2">文章类型</label>
							<div class="col-md-10">
								<select name="typeId" class="form-control">
									<c:forEach items="${types}" var="t">
										<option value="${t.id}">${t.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="enable" class="control-label col-md-2">是否启用</label>
							<div class="col-md-10">
								<div class="form-check">
									<label class="form-check-label"> <input
										class="form-check-input" type="radio" checked="checked"
										id="enable" name="enable" value="1">启用
									</label>
								</div>
								<div class="form-check">
									<label class="form-check-label"> <input
										class="form-check-input" type="radio" name="enable" value="0">禁用
									</label>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="content" class="control-label col-md-2">文章内容</label>
							<div class="col-md-10">
								<!-- 加载编辑器的容器   富文本-->
								<script id="container" name="content" type="text/plain">
    							</script>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<a href='javascript:void(0);' id="saveButton"
						class="btn btn-success">确定</a>
				</div>
			</div>
		</div>
	</div>

	</main>
	<!-- 底部静态资源 -->
	<%@include file="/WEB-INF/views/common/bottomStatic.jsp" %>
	<!-- 引入操作js -->
	<script type="text/javascript" src="/static/system/js/article/article.js"> </script>
	<!-- 配置文件 -->
    <script type="text/javascript" src="/static/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="/static/ueditor/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container',{
        	initialFrameHeight: '200', /* 自定义富文本的高度 */
        	zIndex:'9999'/* 设置添加图片和表情包的弹框到最上层 */
        });
    </script>
	
</body>
</html>