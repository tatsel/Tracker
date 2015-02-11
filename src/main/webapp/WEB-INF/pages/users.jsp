<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="jumbotron">
        <p class="lead">Employees:</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Login</th>
                <th>Position</th>
                <th>Siterole</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${usersList}" var="user">
                <tr>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.login}</td>
                    <td>${user.position.name}</td>
                    <td>${user.userRole.name}</td>
                    <td><a href="<c:url value='${pageContext.request.contextPath}/admin/users/deleteUser/${user.id}'/>">Delete User</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>