<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="well">
        <button class="btn btn-primary">Export</button></br></br>
        <button class="btn btn-default">Start progress</button>
        <button class="btn btn-default">Suspend</button>
        <button class="btn btn-default">Complete</button></br></br>
        <label>Status:</label>
        <label>${status}</label></br></br>
        <label>Assign to:</label>
        <select>
            <c:forEach items="${members}" var="member">
                <option>${member.employee.login}</option>
            </c:forEach>
        </select>
        <button class="btn btn-default">Assign</button></br></br>

        <label>Assignee:</label>
        <label>${assignee}</label></br></br>

        <label>Activity:</label></br>
        <c:forEach items="${activities}" var="activity">
            <option>${activity.comment}</option>
        </c:forEach>




    </div>
    <jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>