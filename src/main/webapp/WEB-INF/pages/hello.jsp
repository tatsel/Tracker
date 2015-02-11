<%@page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>
<div class="container">
    <div class="jumbotron">
        <sec:authorize var="loggedIn" access="isAuthenticated()" />
        <c:choose>
            <c:when test="${loggedIn}">
                <c:redirect url="${pageContext.request.contextPath}/home"  />
            </c:when>
            <c:otherwise>
                <h1>Hello!</h1>
                <p class="lead"> Please, login to proceed to Simple Tracker</p>
                <a class="btn btn-lg btn-success" role="button" href="${pageContext.request.contextPath}/home">
                    Log In
                </a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>