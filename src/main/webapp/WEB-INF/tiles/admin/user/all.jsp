<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <a href="/admin/user/create" class="btn btn-primary btn-sm mb-4 mt-3 float-right">Create<i class="fa fa-plus"></i></a>
    <table class="table table-striped">
        <thead>
        <tr class="bg-dark text-white">
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr class="bg-white text-dark">
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>
                    <c:if test="${user.enabled}">
                        <a href="/admin/user/toggle/${user.id}" class="btn btn-danger btn-sm">Ban</a>
                    </c:if>

                    <c:if test="${!user.enabled}">
                        <a href="/admin/user/toggle/${user.id}" class="btn btn-dark btn-sm">Active</a>
                    </c:if>

                </td>
            </tr>

        </c:forEach>

        </tbody>
    </table>
</div>