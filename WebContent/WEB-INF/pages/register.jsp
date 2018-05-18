<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
<script type="text/javascript">
    function validate(){
    	if(document.getElementById("username").value==""){
    		alert("username can't be null");
    		document.getElementById("username").focus();
    		return false;
    	}else if(document.getElementById("password").value==""){
    		alert("password can't be null.");
    		document.getElementById("name").focus();
    		return false;
    	}
        reutrn true;
    }
</script>
</head>
<body>
    <div id="content">
        <div id="form">
            <h1>register</h1>
            <form action="register.action" method="post" id="myform" onsubmit="return validate()">
                username: <input type="text" id="username" name="username"/><br>
                password: <input type="text" id="password" name="password"/><br>
                <input type="submit" value="submit" />
                <a href="toLogin.action">To login</a>
            </form>
            <!-- show error msg. -->
            <c:if test="${errorMsg!=null}">
                <font color="red">${errorMsg}</font>
            </c:if>
        </div>
    </div>
</body>
</html>