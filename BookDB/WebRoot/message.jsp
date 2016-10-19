<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>Author and work</title>
  </head>
  
  <body>
  <center>
  
  <table border="1px" bordercolor="#000000" cellspacing="0px" style="border-collapse:collapse">
  <tr><th colspan="2" width="200">Book's message:</th></tr>
  <tr><td align="center" style="color:#FF6600;">ISBN: </td> <td width="150" align="center"> <s:property value="book.isbn"/></td></tr>
  <tr><td align="center" style="color:#FF6600;">Title: </td> <td align="center">     <s:property value="book.title"/></td></tr>
  <tr><td align="center" style="color:#FF6600;">Publisher: </td> <td align="center"> <s:property value="book.publisher"/></td></tr>
  <tr><td align="center" style="color:#FF6600;">PublishDate:</td> <td align="center"><s:property value="book.publishDate"/></td></tr>
  <tr><td align="center" style="color:#FF6600;"> Price:    </td> <td align="center">  <s:property value="book.price"/></td></tr>
 </table>
 <br/>
 <table border="1px" bordercolor="#000000" cellspacing="0px" style="border-collapse:collapse">
  <tr><th colspan="2" width="200">Author's message:</th></tr>
  <tr><td align="center" style="color:#FF6600;">AuthorID:</td><td width="150" align="center">   <s:property value="author.authorID"/></td></tr>
  <tr><td align="center" style="color:#FF6600;"> Name:   </td><td align="center">     <s:property value="author.name"/></td></tr>
  <tr><td align="center" style="color:#FF6600;">Age:</td><td align="center"> <s:property value="author.age"/></td></tr>
  <tr><td align="center" style="color:#FF6600;">Country:</td><td align="center"> <s:property value="author.country"/></td></tr>
  </table>
  <br/>
  <a href="<s:url action="List" />">图书列表</a>
  <a href="index.jsp">查询</a>
  <a href='<s:url value="edit.jsp"><s:param name="isbn" value="book.isbn" />
  									<s:param name="authorID" value="book.authorID" />
  									<s:param name="publisher" value="book.publisher" />
  									<s:param name="publishDate" value="book.publishDate" />
  									<s:param name="price" value="book.price" /></s:url>'>编辑</a>
  </center>
  </body>
</html>
