<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/static/signing.css"/>
</head>
<body>


<main class="form-register w-100 m-auto">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/signup" method="post">

        <fieldset>
            <img class="mb-3 mx-auto d-block" src="${pageContext.request.contextPath}/images/cat.png" alt="logo"
                 width="100" height="100">
            <legend class="text-center">Register</legend>

            <div class="form-group">
                <label class="col control-label" for="input_username"><strong>Username</strong></label>
                <div class="col d-flex flex-column mb-2">
                    <input id="input_username" name="login" type="text" placeholder="username"
                           class="form-control input-md" required
                           minlength="1" maxlength="20" pattern="[A-Za-z0-9]+">
                    <span class="form-text text-center"><small>Latin letters or digits</small></span>
                </div>
            </div>

            <div class="form-group">
                <label class="col control-label" for="input_password"><strong>Password</strong></label>
                <div class="col d-flex flex-column mb-2">
                    <input id="input_password" name="password" type="password" placeholder="********"
                           class="form-control input-md" required
                           minlength="1" maxlength="8" pattern="[A-Za-z0-9]+">
                    <span class="form-text text-center"><small>Latin letters or digits</small></span>
                </div>
            </div>

            <div class="form-group">
                <label class="col control-label" for="select_roles"><strong>Role</strong></label>
                <div class="col">
                    <select id="select_roles" name="role" class="form-control">
                        <option value="1">Option one</option>
                        <option value="2">Option two</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col control-label" for="singlebutton"></label>
                <div class="col d-flex">
                    <button id="singlebutton" name="singlebutton" class="btn btn-primary w-50 mx-auto">Submit</button>
                </div>
            </div>
            <c:if test="${not empty requestScope.error}">
                <div class="form-floating text-danger my-3 p-2">
                    <p class="text-center m-0">${requestScope.error}</p>
                </div>
            </c:if>
        </fieldset>
    </form>
</main>

<c:import url="/WEB-INF/jsp/parts/footer.jsp"/>
<c:import url="/WEB-INF/jsp/parts/scripts.jsp"/>
</body>

</html>