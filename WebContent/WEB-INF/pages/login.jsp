<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script type="text/javascript">
  function validate(){
	  if(document.myform.username.value==""){
		  alert("username can't be null");
		  document.myform.username.focus();
		  return false;
	  }else{
		  if(document.myform.paaword.value==""){
			  alert("password can't be null");
			  document.myform.password.focus();
			  return false;
		  }
	  }
	  return true;
  }
</script>
</head>
<body>
    <div id="content">
        <div id="form">
            <h1>user login</h1><br>
            <form action="login.action" method="post" id="myform" onsubmit="return validate()">
                user name: <input type="text" id="username" name="username"/><br>
                password: <input type="text" id="password" name="password"/><br>
                <input type="submit" value="login"/>
                <a href="registerPage.action">register</a>
            </form>
            
            <!-- show error -->
            <c:if test="${errorMsg!=null}">
                <font color="red">${errorMsg}</font>
            </c:if>
            <!-- show prompt -->
            <c:if test="${noticeMsg!=null}">
                <font color="red">${noticeMsg}</font>
            </c:if>
        </div>
    </div>
</body>
</html>