<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Member</title>
    <link href="<c:url value="/resources/css/vendor/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/vendor/jumbotron-narrow.css" />" rel="stylesheet">
</head>
<body ng-app="myapp">

<div class="container" ng-controller="addUserController">
    <jsp:include page="header.jsp" />
    <div class="jumbotron">
        <p class="lead">Add member for project ${project.name}:</p>
        <form:form action="${pageContext.request.contextPath}/admin/projects/addMember/${project.id}" method="post" modelAttribute="memberForm">

            <div class="form-group">
                <label for="employeeId">Employee:</label>
                <form:select path="employeeId" class="form-control">
                    <c:forEach items="${employees}" var="employee">
                        <form:option value="${employee.id}" label="${employee.login}" class="form-control"/>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group">
                <label for="roleName">Siterole:</label>
                <form:select path="roleName" class="form-control">
                    <c:forEach items="${roles}" var="role">
                        <form:option value="${role.name}" label="${role.name}" class="form-control"/>
                    </c:forEach>
                </form:select>
            </div>

            <button name="submit" type="submit" class="btn btn-success">Add Member</button>

        </form:form>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/vendor/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</body>
</html>
