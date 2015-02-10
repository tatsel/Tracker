<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <title>Issues</title>
    <link href="<c:url value="/resources/css/vendor/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/vendor/jumbotron-narrow.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="jumbotron">

        <p class="lead">Issues:</p>
        <a href="${pageContext.request.contextPath}/home/issues/createIssue">Create Issue</a>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Project Name</th>
                <th>Task Description</th>
                <th>PSD</th>
                <th>PED</th>
                <th>ASD</th>
                <th>AED</th>
                <th>Status</th>
                <th>Assignee</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${assignmentsList}" var="assignment">
                <tr>
                    <td>${assignment.task.project.name}</td>
                    <td>${assignment.task.description}</td>
                    <td>${assignment.task.psd}</td>
                    <td>${assignment.task.ped}</td>
                    <td>${assignment.task.asd}</td>
                    <td>${assignment.task.aed}</td>
                    <td>${assignment.task.status.name}</td>
                    <td>${assignment.member.employee.login}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>