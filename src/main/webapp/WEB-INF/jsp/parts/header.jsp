<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="${pageContext.request.contextPath}/menu"
               class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <img class="bi me-2" width="40" height="40" src="images/cat.png" alt="cat-logo"/>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="${pageContext.request.contextPath}/menu" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/accounts" class="nav-link px-2 text-white">Editor</a></li>
                <li><a href="/game" class="nav-link px-2 text-white">Game</a></li>
                <li><a href="/about" class="nav-link px-2 text-white">About</a></li>
            </ul>

            <div class="text-end">
                <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-light me-2">Login</a>
                <a href="${pageContext.request.contextPath}/signup" class="btn btn-primary">Sign-up</a>
            </div>
        </div>
    </div>
</header>
