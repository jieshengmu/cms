<%@ page pageEncoding="UTF-8"%>
<!-- 侧边栏 -->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
	<aside class="app-sidebar">
	<div class="app-sidebar__user">
		<img class="app-sidebar__user-avatar" width="48px" height="48px"
			src="/static/system/images/g4.gif" alt="User Image">
		<div>
			<p class="app-sidebar__user-name">${user_in_session.nickName}</p>
		</div>
	</div>
	<ul class="app-menu">
		<li><a class="app-menu__item" href="/system/article/index">
				<i class="app-menu__icon fa fa-dashboard"></i> <span
				class="app-menu__label">文章管理</span>
		</a></li>
		<li><a class="app-menu__item" href="/system/slide/index">
				<i class="app-menu__icon fa fa-dashboard"></i> <span
				class="app-menu__label">轮播管理</span>
		</a></li>
		<li><a class="app-menu__item" href="/system/faq/index">
				<i class="app-menu__icon fa fa-dashboard"></i> <span
				class="app-menu__label">常见问题</span>
		</a></li>
		<li><a class="app-menu__item" href="/system/feedBacks/index">
				<i class="app-menu__icon fa fa-dashboard"></i> <span
				class="app-menu__label">好评如潮</span>
		</a></li>
	</ul>
	</aside>