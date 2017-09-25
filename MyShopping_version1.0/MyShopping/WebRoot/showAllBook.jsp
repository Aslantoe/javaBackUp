<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showAllBook.jsp' starting page</title>
	
  </head>
  
  <body>

   <h5 style="background-color: red;">${requestScope.msg }	 </h5>
   <c:if test="${empty sessionScope.user }">
  	<form action="shop?action=loginCheck" method="post">
  		用户名:<input type="text" name="name"/>
  		密码:<input type="text" name="pwd"/>
  		<input type="submit" value="提交" />
  	</form>
  </c:if>
  <c:if test="${not empty sessionScope.user }">
  	<h2> 欢迎${sessionScope.user.uname }来到藏书阁!</h2>
  </c:if>  
   	 
   	 	<table>
   	 		<tr>
   	 		  <td>书名</td>
   	 		  <td>作者</td>
   	 		</tr>
   	 	<c:forEach items="${requestScope.bList }" var="b">
   	 		<tr>
   	 		  <td> <a href="shop?action=getBookById&bid=${b.bid }" >${b.btitle }</a></td>
   	 		  <td>${b.bauthor }</td>
   	 		</tr>
   	 	</c:forEach>
   	 	</table>
   	 
  </body>
</html>
