<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<thead>
		<th>角色名称</th>
		<th>操作</th>
	</thead>
	<c:forEach items="${rolelist }" var="role">
		<tr>
		<td><a href="RoleServlet?method=editUI&roleid=${role.roleid }&type=see">${role.rolename }</a></td>
		<td><a href="RoleServlet?method=delete&roleid=${role.roleid }">删除</a>|<a href="RoleServlet?method=editUI&roleid=${role.roleid }&type=edit">修改</a></td>
	</tr>
	</c:forEach>
	
 </table>
 <a href="RoleServlet?method=editUI&type=add">新增角色</a>
</body>
</html>