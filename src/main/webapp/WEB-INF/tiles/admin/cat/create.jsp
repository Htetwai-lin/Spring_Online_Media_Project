<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5 ">
    <div class="col-md-6 offset-md-3">
    <form:form method="post" modelAttribute="category" action="/admin/cat/create">
        <div class="form-group">
            <label for="name">Category Name</label>
            <input type="text" class="form-control" id="name" name="name" path="name" />
        </div>
        <button type="submit" class="btn btn-primary btn-sm ">Create</button>
    </form:form>
    </div>
</div>