<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="well">
        <p class="lead">Issues assigned to you:</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Task Summary</th>
                <th>Project Name</th>
                <th>Status</th>
                <th>Task Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${members}" var="member">
                <c:forEach items="${member.assignments}" var="assignment">
                    <tr>
                        <td><a href="<c:url value='${pageContext.request.contextPath}/home/issues/issuedetails/${assignment.id}'/>">${assignment.task.summary}</a></td>
                        <td><a href="<c:url value='${pageContext.request.contextPath}/home/projects/projectdetails/${assignment.task.project.id}'/>">${assignment.task.project.name}</a></td>
                        <td>${assignment.task.status.name}</td>
                        <td>${assignment.task.description}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>