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

        <h1>${project.name}</h1>
        <sec:authorize access="hasRole('SUPERADMIN')">
            <form:form action="${pageContext.request.contextPath}/admin/projects/changeStatus/${project.id}/3" method="post" class="inlineForm">
                <input type="submit" class="btn btn-default" value="Suspend" <c:if test="${project.status.name != 'In progress'}">disabled="disabled"</c:if> />
            </form:form>
            <form:form action="${pageContext.request.contextPath}/admin/projects/changeStatus/${project.id}/2" method="post" class="inlineForm">
                <input type="submit" class="btn btn-default" value="Continue" <c:if test="${project.status.name eq 'In progress' or project.status.name eq 'Not started'}">disabled="disabled"</c:if> />
            </form:form>
            <form:form action="${pageContext.request.contextPath}/admin/projects/changeStatus/${project.id}/4" method="post" class="inlineForm">
                <input type="submit" class="btn btn-default" value="Complete" <c:if test="${project.status.name eq 'Completed'}">disabled="disabled"</c:if> />
            </form:form>
            </br>
        </sec:authorize>

        <table class="table table-striped">
            <thead>
            <tr>
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
                <tr>
                    <td>${project.name}</td>
                    <td>${project.description}</td>
                    <td>${project.psd}</td>
                    <td>${project.ped}</td>
                    <td>${project.asd}</td>
                    <td>${project.aed}</td>
                    <td>${project.status.name}</td>
                </tr>
            </tbody>
        </table>

        <sec:authorize access="hasRole('SUPERADMIN')">
            <a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/admin/projects/createMember/${project.id}">Add Member</a><br><br>
        </sec:authorize>
        <h4>Project members:</h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Position</th>
                <th>Project Role</th>
                <sec:authorize access="hasRole('SUPERADMIN')">
                    <form:form action="${pageContext.request.contextPath}/admin/projects/deleteMember/${project.id}/${member.id}" method="post">
                        <th>Delete Member</th>
                    </form:form>
                </sec:authorize>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${project.members}" var="member">
                <tr>
                    <td>${member.employee.firstname}</td>
                    <td>${member.employee.lastname}</td>
                    <td>${member.employee.position.name}</td>
                    <td>${member.role.name}</td>
                    <sec:authorize access="hasRole('SUPERADMIN')">
                        <form:form action="${pageContext.request.contextPath}/admin/projects/deleteMember/${project.id}/${member.id}" method="post">
                            <td><input type="submit" class="btn btn-danger btn-xs" value="Delete" /></td>
                        </form:form>
                    </sec:authorize>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>