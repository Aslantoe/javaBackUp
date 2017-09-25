<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showOneBook.jsp' starting page</title>
	
  </head>
  
  <body>
  	<form action="shop?action=addToCart" method="post">	
   	  <table>
   	  		<tr>
   	 		  <td>封面:</td>
   	 		   <td><img src="${requestScope.book.bimgurl }" width="100px" > <input type="hidden" name="bimgurl" value="${requestScope.book.bimgurl }" /> </td> 
   	 		</tr>	
   	 		<tr>
   	 		  <td>编号:</td>
   	 		  <td>${requestScope.book.bid }  <input type="hidden" name="bid" value="${requestScope.book.bid }" /> </td>
   	 		</tr>	
   	 		<tr>
   	 		  <td>书名:</td>
   	 		  <td>${requestScope.book.btitle } <input type="hidden" name="btitle" value="${requestScope.book.btitle }" /></td>
   	 		</tr>	
   	 		<tr>
   	 		  <td>作者:</td>
   	 		  <td>${requestScope.book.bauthor }</td>
   	 		</tr>	
   	 		<tr>
   	 		  <td>出版社:</td>
   	 		  <td>${requestScope.book.bpublisher }</td>
   	 		</tr>	
   	 		<tr>
   	 		  <td>价格:</td>
   	 		  <td>${requestScope.book.bprice }</td>
   	 		</tr>  	 				
   	 	</table>
   	 	<input type="submit" value="加入购物车"/>
   	 </form>
   	 	<a href="index.jsp">返回</a>
  </body>
</html>
