<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp" />
    <div class="well">
        <c:if test="${noEmployees}">
            <p>Sorry, there are no any employees to add</p>
            <a class="btn btn-primary btn-sm" role="button" href="${pageContext.request.contextPath}/home/projects/projectdetails/${project.id}">Back to project</a>

        </c:if>
        <c:if test="${!noEmployees}">
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
        </c:if>

<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>
