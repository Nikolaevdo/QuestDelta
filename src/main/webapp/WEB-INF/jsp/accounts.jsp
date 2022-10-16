<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ua.com.javarush.quest.nikolaev.questdelta.entity.Role" %>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="static/style.css"/>
</head>

<body>
<c:import url="/WEB-INF/jsp/parts/header.jsp"/>
<div class="container mt-3">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title text-center">Accounts list</h4>

            <div class="form-group d-flex my-2">
                <label class="bold me-2 text-muted" for="counts">Accounts per list</label>
                <select id="counts" class="selector">
                    <option value="3" selected>3</option>
                    <option value="5">5</option>
                    <option value="20">20</option>
                    <option value="100">100</option>
                </select>
            </div>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Id</th>
                    <c:if test="${Role.ADMIN eq sessionScope.user.role}">
                        <th>Edit</th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Ivan</td>
                    <td>User</td>
                    <td>32</td>
                    <c:if test="${Role.ADMIN eq sessionScope.user.role}">
                        <td>
                            <a href="#">Edit</a>
                            <a href="#">Delete</a>
                        </td>
                    </c:if>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Admin</td>
                    <td>33</td>
                    <c:if test="${Role.ADMIN eq sessionScope.user.role}"><td>
                        <a href="#">Edit</a>
                        <a href="#">Delete</a>
                    </td></c:if>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Michle</td>
                    <td>Editor</td>
                    <td>42</td>
                    <c:if test="${Role.ADMIN eq sessionScope.user.role}">
                        <td>
                            <a href="#">Edit</a>
                            <a href="#">Delete</a>
                        </td>
                    </c:if>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Guest#266</td>
                    <td></td>
                    <td>Guest</td>
                    <c:if test="${Role.ADMIN eq sessionScope.user.role}">
                        <td>
                            <a href="#">Edit</a>
                            <a href="#">Delete</a>
                        </td>
                    </c:if>
                </tr>
                </tbody>
            </table>
            <nav aria-label="Page navigation example" style="">
                <ul class="pagination">
                    <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<c:import url="/WEB-INF/jsp/parts/footer.jsp"/>
<c:import url="/WEB-INF/jsp/parts/scripts.jsp"/>
</body>
</html>