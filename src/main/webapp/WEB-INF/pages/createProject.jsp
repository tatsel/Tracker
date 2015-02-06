<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>${title}</title>
    <link href="<c:url value="/resources/css/vendor/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/vendor/jumbotron-narrow.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
    <jsp:include page="header.jsp" />
    <div class="jumbotron">
        <p class="lead">Enter project data here:</p>
        <form:form action="${pageContext.request.contextPath}/admin/projects/addProject" method="post" modelAttribute="projectForm">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input path="name" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <form:input path="description" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="psd">PSD:</label>
                <form:input path="psd" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="ped">PED:</label>
                <form:input path="ped" class="form-control"/>
            </div>
            <%--<div class="form-group">
                <label for="status">Status:</label>
                <form:select path="status" class="form-control">
                    <c:forEach items="${statusList}" var="status">
                        <form:option value="${status.name}" label="${status.name}" class="form-control"/>
                    </c:forEach>
                </form:select>
            </div>--%>

            <button name="submit" type="submit" class="btn btn-success">Add Project</button>

        </form:form>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/vendor/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</body>
</html>
