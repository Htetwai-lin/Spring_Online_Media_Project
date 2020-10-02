<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
<a href="/admin/cat/create" class="btn btn-primary btn-sm mb-4 mt-3 float-right">Create<i class="fa fa-plus"></i></a>
    <table class="table table-striped">
        <thead>
        <tr class="bg-dark text-white">
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cat" items="${cats}">
            <tr class="bg-white text-dark">
                <td>${cat.id}</td>
                <td>${cat.name}</td>
                <td>
                    <a href="/admin/cat/edit/${cat.id}" class="btn btn-warning btn-sm"> <i class="fa fa-edit"></i></a>
                    <a href="/admin/cat/delete/${cat.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i></a>
                </td>
            </tr>

        </c:forEach>

        </tbody>
    </table>
</div>