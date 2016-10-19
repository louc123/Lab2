<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Book List</title>
    <style type="text/css">@import url(css/main.css);</style>
    <style>.errorMessage{color:red;}</style>
</head>
<body>    
<center>
    <h2>图书管理</h2>
    
    
    <s:form action="Search">
    	<s:textfield name="authorname" label="作者名："/>
    	<s:submit value="查找" />
    </s:form>
    
    <a href="<s:url action="List" />">图书列表</a>
	<a href="addbook.jsp">添加图书</a>
	</center>
</body>
</html>