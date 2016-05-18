<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pictureUpload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<span style="COLOR:#ff0000"><base target="_self"></span>  
        <title>书籍图片上传</title>  
    </head>  
   <body>  
        <h5>图片上传</h5><hr/>  
        <p style="color: red">${requestScope.errorMsg}</p>  
        <form id="form1" name="form1" action="BookServlet?type=bookUpload" method="post" enctype="multipart/form-data">  
            <div>注:图片大小最大不能超过3M!</div>  
            <div><input type="file" name="file_upload"/></div>  
            <div><input type="submit" value="上传"/></div>  
        </form>  
    </body>  
</html>
