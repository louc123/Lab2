<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>Author and work</title>
  </head>
  
  <body>
  <center><h1>图书列表</h1></center>
  
  <center>
  <table border="1px" bordercolor="#000000" cellspacing="0px" style="border-collapse:collapse">
  <tr>
	  <th style="color:#FF6600;">ISBN</th>
	  <th style="color:#FF6600;">AuthorID</th>
	  <th style="color:#FF6600;">Title</th> 
	  <th style="color:#FF6600;">Publisher</th>
	  <th style="color:#FF6600;">PublishDate</th>
	  <th style="color:#FF6600;">Price</th>
	  <th style="color:#FF6600;">Operation</th>
  <tr>
  <s:iterator value="list">
  <tr>
  	<td align="center"><s:property value="isbn"/></td>
  	<td align="center"><s:property value="authorID"/></td>
  	<td align="center"><a href='<s:url action="Message"><s:param name="isbn" value="isbn" /></s:url>'><s:property value="title"/></a></td>
  	<td align="center"><s:property value="publisher"/></td>
  	<td align="center"><s:property value="publishDate"/></td>
  	<td align="center"><s:property value="price"/></td>
  	 <td align="center"><a href='<s:url action="Remove"><s:param name="isbn" value="isbn" /></s:url>'>删除</a>
  	 <a href='<s:url value="edit.jsp"><s:param name="isbn" value="isbn" />
  	 								<s:param name="authorID" value="authorID" />
  									<s:param name="publisher" value="publisher" />
  									<s:param name="publishDate" value="publishDate" />
  									<s:param name="price" value="price" /></s:url>'>编辑</a></td>
  	<tr>
  </s:iterator></table>
 <br/>
  <a href="addbook.jsp">添加图书</a>
  <a href="index.jsp">图书查询</a> </center>
  </body>
</html>
