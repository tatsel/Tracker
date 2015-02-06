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
<body ng-app="myapp">

<div class="container" ng-controller="addUserController">
  <jsp:include page="header.jsp" />
  <div class="jumbotron">
    <p class="lead">Enter user data here:</p>
    <form:form action="${pageContext.request.contextPath}/admin/users/addUser" method="post" modelAttribute="userForm">
        <div class="form-group">
            <label for="firstName">Firstname:</label>
            <form:input path="firstName" class="form-control" ng-model="firstname"/>
        </div>
      <div class="form-group">
        <label for="lastName">Lastname:</label>
        <form:input path="lastName" class="form-control" ng-model="lastname"/>
      </div>
      <div class="form-group">
        <label>Login:</label>
        <label path="login" class="form-control">
          {{firstname}}_{{lastname}}
        </label>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <form:input path="password" class="form-control"/>
      </div>
      <div class="form-group">
          <label for="passwordVerify">Password Verification:</label>
          <form:input path="passwordVerify" class="form-control"/>
      </div>
      <div class="form-group">
        <label for="position">Position:</label>
        <form:select path="position" class="form-control">
          <c:forEach items="${positionsList}" var="position">
            <form:option value="${position.name}" label="${position.name}" class="form-control"/>
          </c:forEach>
        </form:select>
      </div>
      <div class="form-group">
        <label for="userRole">Siterole:</label>
        <form:select path="userRole" class="form-control">
          <c:forEach items="${userRoleList}" var="role">
            <form:option value="${role.name}" label="${role.name}" class="form-control"/>
          </c:forEach>
        </form:select>
      </div>

      <button name="submit" type="submit" class="btn btn-success">Add User</button>

    </form:form>
  </div>

    <script src="${pageContext.request.contextPath}/resources/js/vendor/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</body>
</html>
