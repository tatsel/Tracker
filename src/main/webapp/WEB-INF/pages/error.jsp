<%@page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>
<div class="container">
    <div class="jumbotron">

        <h1>Oops!</h1>
        <p class="lead">Something really bad happened...</p>
        <p>See exception info below or just go back and check your data</p>
        <label>Info about error:</label>
        <div>
            ${exception}
        </div>
    </div>
</div>
<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>