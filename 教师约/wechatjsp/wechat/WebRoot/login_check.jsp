<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 导入java.sql.ResultSet类 --%>	
<%@ page import="java.sql.ResultSet"%>
<%-- 创建ConnDB类的对象 --%>	
<jsp:useBean id="conn" scope="page" class="com.tools.ConnDB" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username = request.getParameter("username");//获取账户
	String checkCode = request.getParameter("checkCode");//获取验证码
	ResultSet rs = conn.executeQuery("select * from user_ where username='"+ username + "'");
	
	if (rs.next()) {//如果找到相应的账号
				String PWD = request.getParameter("PWD");//获取密码
				if (PWD.equals(rs.getString("userpassword"))) {//如果输入的密码和获取的密码一致
					response.sendRedirect("index.jsp");//跳转到成功首页
				} else {
					out.println(
			"<script language='javascript'>alert('您输入的用户名或密码错误，请与管理员联系!');"
					        +"window.location.href='login.jsp';</script>");
				}
			} 
	else {
		out.println(
			"<script language='javascript'>alert('您输入的用户名或密码错误，或您的账户"+
	         "已经被冻结，请与管理员联系!');window.location.href='login.jsp';</script>");
			}
			
			

%>
</body>
</html>