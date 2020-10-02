<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5 ">
    <div class="col-md-6 offset-md-3">
        <%--@elvariable id="category" type="com"--%>
        <form:form method="post" modelAttribute="category" action="/admin/cat/edit">
            <div class="form-group">
                <label for="name">Edit Category Name</label>
                <input type="text" class="form-control" id="name" name="name" path="name" value="${category.name}" />
                <input type="hidden" path = "id" name="id" value="${category.id}">
            </div>
            <button type="submit" class="btn btn-primary btn-sm ">Update</button>
        </form:form>
    </div>
</div>