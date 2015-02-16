<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="well">
        <p class="lead">You are a member in projects:</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Project Name</th>
                <th>Description</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${members}" var="member">
                <tr>
                    <td><a href="<c:url value='${pageContext.request.contextPath}/home/projects/projectdetails/${member.project.id}'/>">${member.project.name}</a></td>
                    <td>${member.project.description}</td>
                    <td>${member.project.status.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>