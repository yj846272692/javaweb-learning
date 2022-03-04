<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "登录页面" %></h1>
<br/>

<h3>
  <%
    String username = (String) request.getSession().getAttribute("username");
  %>
</h3>
<h2>
  <%=username + ",欢迎您"%>
</h2>
</body>
</html>