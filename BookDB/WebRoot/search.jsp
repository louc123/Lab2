<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>Author and work</title>
  </head>
  
  <body>
  Author name:<s:property value="authorname" /><br/>
  
  <table>
    <s:iterator value='books'>
    <td>
 	<a href='<s:url action="Message"><s:param name="isbn" value="isbn" /></s:url>'>
                                <s:property value="title"/>
                            </a>
    </td>
    </s:iterator>
    </table>
    <a href="<s:url action="List" />">图书列表</a>
    <a href="index.jsp">继续查询</a>
  </body>
</html>
