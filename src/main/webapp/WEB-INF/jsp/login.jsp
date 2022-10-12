<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <c:import url="/WEB-INF/jsp/parts/links.jsp"/>
    <link rel="stylesheet" href="static/signin.css"/>
</head>
<body>
<main class="form-signin w-100 m-auto">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <%--        <img class="mb-3 mx-auto d-block" src="images/person-protection.svg" alt="" width="72" height="72">--%>
        <img class="mb-3 mx-auto d-block" src="images/person-protection.svg" alt="" width="100" height="100">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput" placeholder="Username" required
                   minlength="1" maxlength="20" pattern="[A-Za-z]+">
            <label for="floatingInput">Username</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password" required
                   minlength="1" maxlength="8" pattern="[A-Za-z0-9]+">
            <label for="floatingPassword">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
    </form>
</main>

<a href="${pageContext.request.contextPath}/menu">Menu</a>
<c:import url="/WEB-INF/jsp/parts/scripts.jsp"/>
</body>

</html>