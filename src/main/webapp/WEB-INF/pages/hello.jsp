<%@page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>
        Simple Tracker
    </title>

    <link href="<c:url value="/resources/css/vendor/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/vendor/jumbotron-narrow.css" />" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="jumbotron">
        <h1>${message}</h1>
        <p class="lead"> Please, login to proceed</p>
        <a class="btn btn-lg btn-success" role="button" href="/home">
            Log In
        </a>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources//js/vendor/bootstrap.js"></script>
</body>
</html>