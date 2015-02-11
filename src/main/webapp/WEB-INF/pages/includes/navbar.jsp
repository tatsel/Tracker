<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${contextPath}/home">Simple Tracker</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li><a href="${contextPath}/home">Dashboard</a></li>
        <li class="dropdown">
            <a class="dropdown-toggle" aria-expanded="false" role="button" data-toggle="dropdown" href="#">
                Projects
                <span class="caret"/>
            </a>
            <ul class="dropdown-menu" role="menu">
                <li>
                    <a href="${contextPath}/home/projects">All Projects</a>
                </li>
                <li>
                    <a href="${contextPath}/home/projects/my">My Projects</a>
                </li>
                <sec:authorize access="hasRole('SUPERADMIN')">
                    <li class="divider"></li>
                    <li><a href="${contextPath}/admin/projects/createProject">Create Project</a></li>
                </sec:authorize>
            </ul>
        </li>
          <li class="dropdown">
              <a class="dropdown-toggle" aria-expanded="false" data-toggle="dropdown" role="button" href="#">
                  Issues
                  <span class="caret"/>
              </a>
              <ul class="dropdown-menu">
                  <li>
                      <a href="${contextPath}/home/issues">All Issues</a>
                  </li>
                  <li>
                      <a href="${contextPath}/home/issues/my">My Issues</a>
                  </li>
                  <li class="divider"></li>
                  <li><a href="${contextPath}/home/issues/createIssue">Create Issue</a></li>
              </ul>
          </li>

          <li><a href="${contextPath}/home/search">Search</a></li>

        <sec:authorize access="hasRole('SUPERADMIN')">
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" aria-expanded="false" data-toggle="dropdown" role="button" href="#">
                    Users
                    <span class="caret"/>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="${contextPath}/admin/users">All Users</a>
                    </li>
                    <li>
                        <a href="${contextPath}/admin/users/createUsers">Create User</a>
                    </li>
                </ul>
            </li>
        </sec:authorize>
      </ul>
          <ul class="nav navbar-nav navbar-right">
              <li>
                  <a class="navbar-brand" href="${contextPath}/home/mypage">
                      Hello, <b>${pageContext.request.userPrincipal.name}</b>!
                  </a>
              </li>
              <li>
                  <a href="${contextPath}/logout">
                      <button class="btn btn-primary btn-xs">
                          Log Out
                      </button>
                  </a>
              </li>
          </ul>
    </div>
  </div>
</nav>