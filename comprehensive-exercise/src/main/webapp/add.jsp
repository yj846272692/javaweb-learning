<%@ page import="com.yj.web.exercise.entity.User" %>
<%@ page import="com.yj.web.exercise.entity.Brand" %><%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2022/3/1
  Time: 2:18 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加</title>
    <link href="css/style.css" rel="stylesheet">
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Login</title>
    <link href="css/styles.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
            crossorigin="anonymous"></script>
</head>
<body>
<%
    Brand brand = (Brand) request.getAttribute("brand");
%>
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">ADD</h3></div>
                            <div class="card-body">
                                <form action="${pageContext.request.contextPath}/add" method="post">
                                    <%--隐藏域，提交id--%>
<%--                                    <input type="hidden" name="id" value="<%=brand.getId()%>">--%>
                                    <table>
                                        <tr style="display:block; margin: 20px 0">
                                            <td>
                                                <label style="width: 200px" for="brandName">
                                                    品牌名称
                                                </label>
                                            </td>
                                            <td class="mt-3"><input type="text" name="brandName" value="" id="brandName"></td>
                                        </tr>

                                        <tr style="display:block; margin: 20px 0">
                                            <td>
                                                <label  style="width: 200px" for="companyName">
                                                    企业名称
                                                </label>
                                            </td>
                                            <td><input type="text" name="companyName" value="" id="companyName"></td>
                                        </tr>

                                        <tr style="display:block; margin: 20px 0">
                                            <td>
                                                <label  style="width: 200px" for="ordered">
                                                    排序
                                                </label>
                                            </td>
                                            <td><input type="text" name="ordered" value="" id="ordered"></td>
                                        </tr>

                                        <tr style="display:block; margin: 20px 0">
                                            <td>
                                                <label  style="width: 200px" for="description">
                                                    描述信息
                                                </label>
                                            </td>
                                            <td>
                        <textarea name="description" style="width: 250px" rows="10" cols="50" id="description">

                        </textarea>
                                            </td>
                                        </tr>

                                        <tr style="display:block; margin: 20px 0">
                                            <td  style="width: 200px" > 状态</td>
                                            <td>
                                                <input name="status" type="radio" id="ok" value="1" checked>
                                                <label   for="ok">
                                                    启用
                                                </label>
                                                <input name="status" type="radio" id="no" value="0">
                                                <label for="no">
                                                    禁用
                                                </label>
                                            </td>
                                        </tr>
                                    </table>

                                    <div style="padding-left: 150px;">
                                        <input class="btn btn-primary" type="submit" value="提交">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>