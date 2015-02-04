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
        <a href="${pageContext.request.contextPath}/projects/createProject">Create Project</a>
        <p class="lead">Projects:</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Project Name</th>
                <th>Description</th>
                <th>PSD</th>
                <th>PED</th>
                <th>ASD</th>
                <th>AED</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${projectsList}" var="project">
                <tr>
                    <td>${project.id}</td>
                    <td>${project.name}</td>
                    <td>${project.description}</td>
                    <td>${project.psd}</td>
                    <td>${project.ped}</td>
                    <td>${project.asd}</td>
                    <td>${project.aed}</td>
                    <td>${project.status.name}</td>
                    <td><a href="<c:url value='${pageContext.request.contextPath}/projectss/deleteProject/${project.id}'/>">Delete Project</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>