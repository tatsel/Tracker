<%--<%@page session="false"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
  <title>
    Simple Tracker
  </title>

  <link href="<c:url value="/resources/css/vendor/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/vendor/jumbotron-narrow.css" />" rel="stylesheet">
</head>

<body>
<div class="container">
  <jsp:include page="header.jsp"></jsp:include>
  <div class="jumbotron">
    <h1>${message}</h1>
    <p class="lead"> Now, you can logout, lol</p>
   <%-- <div id="head">
      Hello, <b>${pageContext.request.userPrincipal.name}; </b>
      </div>
    <sec:authorize access="hasRole('SUPERADMIN')">
      <div>
        This content will only be visible to users who have the "SUPERADMIN" authority.
      </div>
    </sec:authorize>
    <a class="btn btn-lg btn-success" role="button" href="${pageContext.request.contextPath}/logout">
      Log Out
    </a>--%>
  </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources//js/vendor/bootstrap.js"></script>
</body>
</html>