<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
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
<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>