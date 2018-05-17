<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
test.jsp<br>
<!-- action="findUser.action", not action="test/findUser.action" ?? -->
<form id="form" method="post" action="findUser.action">
    <input name="userName" type="text"/><br>
    <input name="submit" type="submit" value="submit"/>
</form>

<table id="table" width=300px border=1>
    <tr>
        <td>Number</td>
        <td>userId</td>
        <td>userName</td>
        <td>password</td>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>