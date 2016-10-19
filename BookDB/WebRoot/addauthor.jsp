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
    <h2>该作者不存在！请输入其信息</h2>
    <s:set name="flag" value="flag"/>
        <s:form action="Addauthor">
			<s:hidden name="flag" value="%{flag}"/>
       <s:if test="flag==true">
	       <s:hidden name="book.title" value="%{book.title}"/>
	       <s:hidden name="book.isbn" value="%{book.isbn}"/>
	       <s:hidden name="book.publisher" value="%{book.publisher}"/>
	       <s:hidden name="book.publishDate" value="%{book.publishDate}"/>
	       <s:hidden name="book.price" value="%{book.price}"/>
	       <s:hidden name="book.authorID" value="%{book.authorID}"/>

       </s:if>
       <s:else>
       		<s:hidden name="book.publisher" value="%{book.publisher}"/>
	       <s:hidden name="book.publishDate" value="%{book.publishDate}"/>
	       <s:hidden name="book.price" value="%{book.price}"/>
	       <s:hidden name="book.authorID" value="%{book.authorID}"/>
	       <s:hidden name="isbn" value="%{isbn}"/>
       </s:else>
    	<s:textfield name="authorid" label="AuthorID*"></s:textfield><br/>
    	<s:textfield name="author.name" label="Name*"/><br/>
    	<s:textfield name="author.age" label="Age"/><br/>
   
    	<s:textfield name="author.country" label="Country"/><br/>
    	<s:submit value="提交" />
    </s:form>
    </center>
    
</body>
</html>