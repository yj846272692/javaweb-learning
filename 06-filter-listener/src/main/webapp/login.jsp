
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

<h2>登录页面</h2>
<%
    HttpSession session1 = request.getSession();
    session1.setAttribute("username","YangJing");
%>
<h3>
    <%=request.getAttribute("msg")%>
</h3>
</body>
</html>
