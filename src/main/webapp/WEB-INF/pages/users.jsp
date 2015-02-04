<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <title>${title}</title>
    <link href="<c:url value="/resources/css/vendor/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/vendor/jumbotron-narrow.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="jumbotron">
        <p class="lead">Employees:</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Login</th>
                <th>PositionID</th>
                <th>Position</th>
                <th>SiteroleID</th>
                <th>Siterole</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${usersList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.login}</td>
                    <td>${user.position.id}</td>
                    <td>${user.position.name}</td>
                    <td>${user.userRole.id}</td>
                    <td>${user.userRole.name}</td>
                    <td><a href="<c:url value='${pageContext.request.contextPath}/users/deleteUser/${user.id}'/>">Delete User</a></li></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>