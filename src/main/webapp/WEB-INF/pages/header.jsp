<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Simple Tracker</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a >Dashboard</a></li>
        <li><a href="${contextPath}/home/projects">Projects</a></li>
        <li><a href="${contextPath}/home/issues">Issues</a></li>
        <sec:authorize access="hasRole('SUPERADMIN')">
          <li><a href="${contextPath}/admin/users">Users</a></li>
          <li><a href="${contextPath}/admin/users/createUser">Create User</a></li>
        </sec:authorize>
        <li><a href="${contextPath}/home/tasks/createIssue">Create Issue</a></li>
        <li>Hello, <b>${pageContext.request.userPrincipal.name}</b>!</li>
        <li>
          <a class="btn btn-lg btn-success" role="button" href="${contextPath}/logout">
            Log Out
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>