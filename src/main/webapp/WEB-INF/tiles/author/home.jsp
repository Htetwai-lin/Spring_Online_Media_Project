<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">

    <div class="container " >
        <table class="table table-bordered">
            <thead class="bg-dark text-white">
            <tr>
                <th scope="col">id</th>
                <th scope="col">Author</th>
                <th scope="col">Category</th>
                <th scope="col">Title</th>
                <th scope="col">Image</th>
                <th scope="col">Content</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="posts" items="${postList}">
                <tr>
                    <td>${posts.id}</td>
                    <td>${posts.user.username}</td>
                    <td>${posts.category.name}</td>
                    <td>${posts.title}</td>
                    <td>
                        <img src="/assets/img/${posts.image}" alt="" width="50" height="50"/>
                    </td>
                    <td>${posts.content}</td>
                    <td>
                        <a href="/author/post/edit/${posts.id}" class="btn btn-warning btn-sm"> <i class="fa fa-edit"></i></a>
                        <a href="/author/post/delete/${posts.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
    </div>
</div>
