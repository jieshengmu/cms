document
.querySelector('#table-demo-ajaxPageCode')
.GM(
		{
			gridManagerName : 'demo-ajaxPageCode', //gridManager的名称
			ajaxData : '/system/article/list', //请求路径 -自动发送的ajax请求
			ajaxType : 'POST',//请求方法
			supportAjaxPage : true, //是否支持分页
			supportDrag: false,   //是否支持拖拽
			sortUpText: 'up',
			isCombSorting:true,
			currentPageKey : "localPage", //当前页
			pageSizeKey : "pageSize", //每页显示的条数
			sizeData : [ 5, 10, 15, 20 ], //分页的选项
			pageSize : 5, //默认每页显示多少条
			height : '100%', //显示全部高度 
			columnData : [ //列的数据 -- 返回的json数据对应
				{
					key : 'title',
					text : '文章标题',
					align : 'center',
					sorting: 'DESC'
				},
				{
					key : 'type',
					text : '文章类型',
					align : 'center',
					sorting: 'DESC',
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
					sorting: 'ASC'
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
					text : '操作&emsp;<a href="javascript:;" style="color:green" class="addButton">添加</a>',
					align : 'center',
					template : function(cell, row, index,
							key) {
						//将json格式对象转化为json字符串
						var jsonObj =  JSON.stringify(row);
						return "<a href='javascript:;' style='color:orange' data-obj='"+jsonObj+"'>修改</a>&emsp;"
						+ '<a href="javascript:;" style="color:red" data-id="'+cell+'">删除</a>';
					}
				} ]
		});

$(function() {//jQuery入口函数
	/* 高级查询 */
	//给查询按钮绑定一个点击事件
	$("#queryButton").on("click", function() {

		//使用插件：jquery.jdirk.js  ,注意：该插件是jQuery扩展插件，所以引入的时候必须在jQuery.js下面
		//使用serializeObject();方法自动获取高级查询表单中的数据，并转化为json格式的数据，传入到GirdManager的setQuery(GirdManager名,json格式的数据)方法中
		var jsonForm = $('#queryForm').serializeObject();
		//使用GridManager的方法：GridManager.setQuery('demo-baseCode',json格式数据)
		GridManager.setQuery('demo-ajaxPageCode', jsonForm);
	});

	/* 删除 */
	//因为删除按钮是动态获取的，所以需要使用委托事件  a[data-id] 标签元素选择器
	$("body").on("click", "a[data-id]", function() {
		//通过在data-id上绑定数据，使用当前按钮的data方法获取id
		var id = $(this).data("id");
		//弹出模态框
		$("#delModal").modal("show");
		//取消模态框确定按钮的所有绑定事件,如果没有取消，我们在点击删除弹出模态框，在点击取消，多点几次取消
		//确定按钮就会绑定多次事件，造成错误
		$("#delModalButton").off();
		//点击确认按钮
		$("#delModalButton").on("click",function(){
			//发送ajax请求到后台
			$.ajax({
				type : "POST",
				url : "/system/article/del",
				data : "id=" + id,
				success : function(msg) {
					//根据返回对象的信息进行判断
					if (msg.success) {
						//关闭模态框
						$("#delModal").modal("hide");	
						//刷新列表
						GridManager.refreshGrid('demo-ajaxPageCode');
					}else{
						alert(msg.msg);
					}
				}
			});

		});

	});

	/* 添加 */
	$("body").on("click",".addButton",function(){
		//自动重置模态框内容
		$("#saveForm").get(0).reset();
		//手动重置隐藏域id
		$("#saveForm #id").val("");
		
		//手动清空富文本
		var ue = UE.getEditor('container'); //获取富文本
		ue.ready(function() { 
			ue.setContent(""); 
		}); 
		
		
		
		//打开添加的模态框
		$("#saveModal").modal("show");

	});

	/* 修改 */
	$("body").on("click","a[data-obj]",function(){
		//重置模态框内容
		$("#saveForm").get(0).reset();
		//通过在data-obj上绑定数据，使用当前按钮的data方法获取obj  获取回显的数据  json格式的数据
		var jsonObj = $(this).data("obj");
		
		//操作：回显富文本的内容
		var ue = UE.getEditor('container'); //获取富文本
		ue.ready(function() { 
			ue.setContent(jsonObj.content); 
		}); 

		
		
		
		// 回显 显示到模态框   setForm() 是form-load.js插件的方法
		//$("标签x").setform(json数据); 给标签x内文本框自动赋值json数据
		$("#saveForm").setForm(jsonObj);
		//打开添加的模态框
		$("#saveModal").modal("show");

	});


	/* 添加和更新模态框点击确定时绑定事件请求后台 */
	$("#saveButton").on("click",function(){
		// clearForm()、ajaxSubmit()都是jquery-form.js插件的方法 
		//ajaxSubmit 发送saveForm表单中的action="/system/article/save" method="post" 请求
		$("#saveForm").ajaxSubmit({
			success : function(msg) {
				//根据返回对象的信息进行判断
				if (msg.success) {
					//关闭模态框
					$("#saveModal").modal("hide");	
					//刷新列表
					GridManager.refreshGrid('demo-ajaxPageCode');
				}else{
					//关闭模态框
					$("#saveModal").modal("hide");	
					alert(msg.msg);
				}
			}
		});
	});




});