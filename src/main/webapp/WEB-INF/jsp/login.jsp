<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/signing.css"/>
</head>
<body>


<main class="form-signin w-100 m-auto">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <img class="mb-3 mx-auto d-block" src="${pageContext.request.contextPath}/images/person-protection.svg" alt="" width="100" height="100">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput" name="login" placeholder="Username" required
                   minlength="1" maxlength="20" pattern="[A-Za-z0-9]+">
            <label for="floatingInput">Username</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password"
                   required
                   minlength="1" maxlength="8" pattern="[A-Za-z0-9]+">
            <label for="floatingPassword">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <c:if test="${not empty requestScope.error}">
            <div class="form-floating text-danger my-3 p-2">
                <p class="text-center m-0">${requestScope.error}</p>
            </div>
        </c:if>
    </form>

</main>

<c:import url="/WEB-INF/jsp/parts/footer.jsp"/>
<c:import url="/WEB-INF/jsp/parts/scripts.jsp"/>
</body>

</html>