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
	<main class="app-content">
	 <!-- 高级查询 -->
	<div class="row app-title">
		<div class="col-md-12">
			<!-- 表单 -->
			<form id="queryForm" class="form-inline">
				<div class="form-group">
					<label for="title">常见问题：</label> <input type="text"
						class="form-control" name="title" id="title">
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
	<div class="modal fade " id="saveModal">
		<div class="modal-dialog ">
			<div class="modal-content message_align">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="/system/faq/save" method="post"
						class="form-horizontal"  id="saveForm">
						
						<input type="hidden" name="id" id="id">
						<div class="form-group row">
							<label class="control-label col-md-3">常见问题</label>
							<div class="col-md-9">
								<input class="form-control" type="text" name="title">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-md-3">问题描述</label>
							<div class="col-md-9">
								<!-- <input class="form-control" type="t" name="content"> -->
								<textarea rows="10px" cols="20px" class="form-control"  name="content"></textarea>
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-md-3">排序</label>
							<div class="col-md-9">
								<input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" class="form-control"  name="orderBy">
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
	<script type="text/javascript" src="/static/system/js/faq/faq.js"> </script>
    </script>
	
</body>
</html>