<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showAllBook.jsp' starting page</title>
	
  </head>
  
  <body>
   	 <h3>购物车清单</h3>
   	 	<table>
   	 		<tr>
   	 		  <td>封面</td>
   	 		  <td>书名</td>
   	 		  <td>数量</td>
   	 		  <td>单价</td>
   	 		  <td>总计</td>
   	 		</tr>
   	 	<c:forEach items="${requestScope.cList }" var="c">
   	 		<tr>
   	 		  <td> <img src="${c.bimgurl}" width="50px" > </td>
   	 		  <td>${c.btitle }</td>
   	 		  <td>${c.bcount }</td>
   	 		  
   	 		</tr>
   	 	</c:forEach>
   	 	</table>
   	 <a href="">返回</a>
  </body>
</html>
