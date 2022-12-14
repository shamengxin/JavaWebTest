<%@ page import="java.util.List" %>
<%@ page import="com.shamengxin.oa.bean.Dept" %>
<%@page contentType="text/html; charset=UTF-8"%>

<%--毙掉session对象，写上这个，内置对象就不能用了。--%>
<%--<%@page session="false" %>--%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门列表页面</title>
		<script type='text/javascript'>
			function del(dno){
				if(window.confirm('亲，删了不可恢复哦！')){
					document.location.href='<%=request.getContextPath()%>/dept/delete?deptno='+dno;
				}
			}
		</script>
	</head>
	<body>

	<%--显示一个登录名--%>
	<h3>欢迎<%=session.getAttribute("username")%></h3>
	<a href="<%=request.getContextPath()%>/user/exit">[退出系统]</a>

		<h1 align="center">部门列表</h1>
		<hr>
		<table border="1px" align="center" width="50%">
			<tr>
				<th>序号</th>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>

			<%
				//从request域当中取出集合
				List<Dept> deptList=(List<Dept>)request.getAttribute("deptList");
				//循环遍历
				int i=0;
				for(Dept dept:deptList){
					//在后台输出
					//System.out.println(dept.getDname());
					//把部门名字输出到浏览器
					//out.write(dept.getDname());
			%>

			<tr>
				<td><%=++i%></td>
				<td><%=dept.getDeptno()%></td>
				<td><%=dept.getDname()%></td>
				<td>
					<a href="javascript:void(0)" onclick="del(<%=dept.getDeptno()%>)" >删除</a>
					<a href="<%=request.getContextPath()%>/dept/detail?f=edit&deptno=<%=dept.getDeptno()%>">修改</a>
					<a href="<%=request.getContextPath()%>/dept/detail?f=detail&deptno=<%=dept.getDeptno()%>">详情</a>
				</td>
			</tr>

			<%
				}
			%>
		</table>
		
		<hr>
		<a href="<%=request.getContextPath()%>/old/add.jsp.jsp">新增部门</a>
	</body>
</html>