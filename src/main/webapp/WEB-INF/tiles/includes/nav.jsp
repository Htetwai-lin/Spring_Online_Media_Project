<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container bg-dark">

    <nav class="navbar navbar-expand-lg navbar-light text-white">
        <a class="navbar-brand" href="/">
        <img alt="" src="/assets/img/images.png" width="30" height="30" />
          <span class="text-white ml-3">Online Media</span>
        </a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       Categories
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:forEach var="cat" items="${cats}">
                            <a class="dropdown-item" href="/cat/${cat.id}">${cat.name}</a>
                        </c:forEach>
                    </div>
                </li>
                <c:if test="${pageContext.request.userPrincipal.authenticated}">
                <li class="nav-item active">
                    <a class="nav-link text-white" href="/user/home">User Panel</a>
                </li>
                </c:if>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Member
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                        <c:if test="${!pageContext.request.userPrincipal.authenticated}">
                            <a class="dropdown-item" href="/login">login</a>
                            <a class="dropdown-item" href="/register">Register</a>
                        </c:if>
                        <c:url var="logoutUrl" value="/logout"></c:url>
                        <c:if test="${pageContext.request.userPrincipal.authenticated}">
                            <form action="${logoutUrl}" method="post">
                                <input type="submit" value="logout" class="btn btn-default ml-2">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            </form>
                        </c:if>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown3" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Menu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/contact">Content</a>
                        <a class="dropdown-item" href="/admin/home">Admin</a>
                        <a class="dropdown-item" href="/author/home">Author</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</div>