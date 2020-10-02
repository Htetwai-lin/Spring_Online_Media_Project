<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">

    <div class="row" >
                <div class="card mb-5" >
                    <img src="/assets/img/${post.image}" alt="" class="card-img-top" width="50" height="100"/>
                    <div class="card-body">
                        <h5 class="card-title">${post.title}</h5>
                        <p class="card-text">${post.content}</p>
                        <a href="#" class="btn btn-primary float-right" >Detail</a>
                    </div>
                </div>
    </div>
</div>