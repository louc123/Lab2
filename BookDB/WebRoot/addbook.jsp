<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <style type="text/css">@import url(css/main.css);</style>
    <style>.errorMessage{color:red;}</style>
</head>
<body>   
<center>
    <h2>请填写图书信息：</h2>
    
    
    <s:form action="Add">
    	<s:textfield name="book.isbn" label="ISBN*"/><br/>
    	<s:textfield name="book.title" label="Title*"/><br/>
    	<s:textfield name="authorid" label="AuthorID*"/><br/>
    	<s:textfield name="book.publisher" label="Publisher"/><br/>
    	<s:textfield name="book.publishDate" label="PublishDate(yyyy-mm-dd)">  
    		<s:param name="value">  
        		<s:date name="book.publishDate" format="yyyy-MM-dd" />  
    		</s:param>  
		</s:textfield>
   
    	<s:textfield name="book.price" label="Price*"/><br/>
    	<s:submit value="提交" />
    </s:form>
    </center>


</body>
</html>