<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:iterator var="menu" value="menuList">
	<s:if test="#menu.id == 1"><li class="active"></s:if><s:else><li></s:else>
	<s:if test="#menu.url != '' && #menu.url != null">
			<a class="J_menuItem"
				href='<s:property value="#menu.url"/>?menuId=<s:property value="#menu.id"/>'>
				<s:property value="#menu.icon_img" escape="false" /> <span
				class="nav-label"><s:property value="#menu.resource_name" />
			</span> </a>
		</s:if> <s:else>
			<a href="#"> <s:property value="#menu.icon_img" escape="false" />
				<span class="nav-label"><s:property
						value="#menu.resource_name" />
			</span> <span class="fa arrow"></span> </a>
		</s:else> <s:if test="#menu.childrenList != null">
			<ul class="nav nav-second-level">
				<s:iterator var="child" value="#menu.childrenList">
					<li><s:property value="#child.icon_img" escape="false" /> <a
						class="J_menuItem"
						href='<s:property value="#child.url"/>?menuId=<s:property value="#child.id"/>'><s:property
								value="#child.resource_name" />
					</a></li>
				</s:iterator>
			</ul>
		</s:if></li>
</s:iterator>