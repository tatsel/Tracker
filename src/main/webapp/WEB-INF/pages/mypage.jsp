<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="jumbotron">

        <p>Your login: <b>${employee.login}</b></p>
        <p>Your position: <b>${employee.position.name}</b></p>
        <p>You're member of <b><a href="${pageContext.request.contextPath}/home/projects/my">these projects</a></b></p>
        <p>You have <b><a href="${pageContext.request.contextPath}/home/issues/my">issues</a></b> assigned to you.</p>

    </div>
    <jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>