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
    <h2>请输入图书信息：</h2>

    <s:form action="Edit">
    	<s:hidden name="isbn" value="%{#parameters.isbn}"/>
		<s:textfield name="book.authorID" label="AuthorID*" value="%{#parameters.authorID}" /><br/>
		<s:textfield name="book.publisher" label="Publisher" value="%{#parameters.publisher}"/><br/>
		<s:textfield name="book.publishDate" label="PublishDate(yyyy-mm-dd)" value="%{#parameters.publishDate}"/><br/>
		<s:textfield name="book.price" label="Price*" value="%{#parameters.price}"/><br/>
		<s:submit value="提交"/>
	</s:form>
	</center>
</body>
</html>