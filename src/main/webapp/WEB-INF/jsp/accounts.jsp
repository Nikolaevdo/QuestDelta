<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <label class="bold" for="counts">Number of accounts per list</label>
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
                    <th>Password</th>
                    <th>Role</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Ivan</td>
                    <td>123</td>
                    <td>User</td>
                    <td>
                        <a href="#">Edit</a>
                        <a href="#">Delete</a>
                    </td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>321</td>
                    <td>Admin</td>
                    <td>
                        <a href="#">Edit</a>
                        <a href="#">Delete</a>
                    </td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Arsh</td>
                    <td>Qwerty123</td>
                    <td>Editor</td>
                    <td>
                        <a href="#">Edit</a>
                        <a href="#">Delete</a>
                    </td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Guest#266</td>
                    <td></td>
                    <td>Guest</td>
                    <td>
                        <a href="#">Edit</a>
                        <a href="#">Delete</a>
                    </td>
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