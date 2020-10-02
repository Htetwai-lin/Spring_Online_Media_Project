<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
    <title><tiles:insertAttribute name="title"></tiles:insertAttribute> </title>
    <link rel="icon" href="/assets/img/coder1.jpg">
    <link rel="stylesheet" href="/assets/img/coder.jpg">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>

</head>
<body>
<tiles:insertAttribute name="nav"></tiles:insertAttribute>
<tiles:insertAttribute name="menu"></tiles:insertAttribute>
<tiles:insertAttribute name="content"></tiles:insertAttribute>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>