<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showCart.jsp' starting page</title>
	<style type="text/css">
	a{text-decoration:none;}
	</style>
	
  </head>
  
  <body>
   	 <h3>购物车清单</h3>
   	 <form action="shop?action=addToOrderForm" method="post">
   	 	<table >
   	 		<tr>
   	 		  <td></td>
   	 		  <td>封面</td>
   	 		  <td>书名</td>
   	 		  <td>数量</td>
   	 		  <td>单价</td>
   	 		  <td>总计</td>
   	 		  <td>操作</td> 
   	 		</tr>
   	 		
   	 	<c:set value="0" var="sum"/>
   	 	<c:forEach items="${requestScope.cList }" var="c">
   	 		<tr>
   	 		  <td> <input type="checkbox" > </td>
   	 		  <td> <img src="${c.bimgurl}" width="50px" > </td>
   	 		  <td>${c.btitle }</td>
   	 		  <td><a href="shop?action=cutCart&bid=${c.bid }&cid=${c.cid }" >-</a> &nbsp; ${c.bcount } &nbsp; <a href="shop?action=plusCart&bid=${c.bid }">+</a> </td>
   	 		  <td>${c.bprice }</td>
   	 		  <td>${(c.bprice)*(c.bcount)}</td>
   	 	  	  <td>
   	 	  	  	<a href="shop?action=delCartById&cid=${c.cid }">删除</a>
   	 	  	  </td>
   	 		</tr>
   	 		
   	 	<c:set value="${sum + (c.bprice)*(c.bcount) }" var="sum"/>	
   	 	</c:forEach>
   	 		<tr>
   	 			<td colspan="6" align="right"> <input type="hidden"  name="totalPrice" value="${sum }">  ${sum }  </td>
   	 		</tr>
   	 		
   	 	</table>
   	 	<input type="submit" value="结算" >
   	 </form>
   	 	
   	 <a href="index.jsp">返回继续购买</a>
  </body>
</html>
