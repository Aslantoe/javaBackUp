<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'showOrderForm.jsp' starting page</title>
    
  </head>
  
  <body>
  	<c:if test="${empty sessionScope.user }">
  	<form action="shop?action=loginCheck2" method="post">
  		用户名:<input type="text" name="name"/>
  		密码:<input type="text" name="pwd"/>
  		<input type="submit" value="提交" />
  	</form>
  </c:if>
  
  <c:if test="${not empty sessionScope.user }">
  	<h2> 请${sessionScope.user.uname }填写订单信息:</h2>
     	<form action="" method="post">
   			姓名:<input type="text" name="name" /><br>
   			电话:<input type="text" name="tel" /><br>
   			地址:<input type="text" name="address" /><br>
   			您需要支付:${sessionScope.totalPrice }元。  <br>
   		<input type="submit" value="付款">	
   	    </form>
  	
  	
  	
  </c:if>  
  
  				
  </body>
</html>
