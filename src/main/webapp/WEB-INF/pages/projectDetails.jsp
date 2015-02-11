<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="well">
        <sec:authorize access="hasRole('SUPERADMIN')">
            <a href="${pageContext.request.contextPath}/admin/projects/createMember/${project.id}">Add Members</a>
        </sec:authorize>
        <p class="lead">Projects:</p>
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
                <th>Members</th>
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
                    <td>
                        <c:forEach items="${project.members}" var="member">
                            ${member.employee.login}<br/>
                            ${member.role.name}<br/>
                            <sec:authorize access="hasRole('SUPERADMIN')">
                                <a href="${pageContext.request.contextPath}/admin/projects/deleteMember/${project.id}/${member.id}">Delete</a><br/>
                            </sec:authorize>
                        </c:forEach>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>