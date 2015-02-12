<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="well">

        <h1>${project.name}</h1>
        <sec:authorize access="hasRole('SUPERADMIN')">
            <a role="button" class="btn btn-default" href="${pageContext.request.contextPath}/admin/projects/changeStatus/${project.id}/3"
               <c:if test="${project.status.name != 'In progress'}">disabled="disabled"</c:if>>
                Suspend
            </a>
            <a role="button" class="btn btn-default" href="${pageContext.request.contextPath}/admin/projects/changeStatus/${project.id}/2"
               <c:if test="${project.status.name != 'Suspended'}">disabled="disabled"</c:if>>
                Continue
            </a>
            <a role="button" class="btn btn-default" href="${pageContext.request.contextPath}/admin/projects/changeStatus/${project.id}/4"
               <c:if test="${project.status.name eq 'Completed'}">disabled="disabled"</c:if>>
                Complete
            </a></br></br>
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
                <th>Delete Member</th>
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
                        <td><a class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/admin/projects/deleteMember/${project.id}/${member.id}">Delete</a></td>
                    </sec:authorize>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>