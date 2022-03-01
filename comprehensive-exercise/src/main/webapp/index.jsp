<%@ page import="com.yj.web.exercise.entity.User" %>
<%@ page import="com.yj.web.exercise.entity.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yj.web.exercise.entity.User" %>
<%@ page import="com.yj.web.exercise.entity.Brand" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Tables - SB Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <link href="css/styles.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
            crossorigin="anonymous"></script>
</head>
<%
    User user = (User) request.getSession().getAttribute("user");
    List<Brand> brands = (List<Brand>) request.getAttribute("brands");
%>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-light bg-gradient">

    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
<%--        <div class="input-group">--%>
<%--&lt;%&ndash;            <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..."&ndash;%&gt;--%>
<%--&lt;%&ndash;                   aria-describedby="btnNavbarSearch"/>&ndash;%&gt;--%>
<%--            <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>--%>
<%--        </div>--%>
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <div style="color: white;font-size: 22px"><%=user.getUsername()%>
        </div>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
               aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="#!">Settings</a></li>
                <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                <li>
                    <hr class="dropdown-divider"/>
                </li>
                <li><a class="dropdown-item" href="/logout">Logout</a></li>
            </ul>
        </li>
    </ul>
</nav>
<div id="layoutSidenav">


    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">表格</h1>
<%--                <ol class="breadcrumb mb-4">--%>
<%--                    <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>--%>
<%--                    <li class="breadcrumb-item active">Tables</li>--%>
<%--                </ol>--%>

                <a class=" btn btn-info mb-1" href="add.jsp">新增</a>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        数据展示
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>品牌名称</th>
                                <th>企业名称</th>
                                <th>排序</th>
                                <th>品牌介绍</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>序号</th>
                                <th>品牌名称</th>
                                <th>企业名称</th>
                                <th>排序</th>
                                <th>品牌介绍</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <%
                                for (Brand brand : brands) {
                            %>
                            <tr>
                                <td><%=brand.getId()%>
                                </td>
                                <td width="100"><%=brand.getBrandName()%>
                                </td>
                                <td width="100"><%=brand.getCompanyName()%>
                                </td>
                                <td><%=brand.getOrdered()%>
                                </td>
                                <td width="600"><%=brand.getDescription()%>
                                </td>
                                <td>
                                    <%
                                        if (brand.getStatus() == 0) {
                                    %>
                                    禁用
                                    <%
                                    } else {
                                    %>
                                    启用
                                    <%
                                        }
                                    %>
                                </td>
                                <td width="120">
                                    <a class="btn btn-outline-primary" style="font-size: 10px;"
                                       href="${pageContext.request.contextPath}/selectById?id=<%=brand.getId()%>">修改</a>
                                    <a class="btn btn-outline-secondary" style="font-size: 10px"
                                       href="${pageContext.request.contextPath}/delete?id=<%=brand.getId()%>">删除</a>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Your Website 2021</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>
</body>
</html>
