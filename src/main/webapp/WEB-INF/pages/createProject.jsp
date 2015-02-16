<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp" />
    <div class="jumbotron">
        <p class="lead">Enter project data here:</p>
        <form:form action="${pageContext.request.contextPath}/admin/projects/addProject" method="post" modelAttribute="projectForm">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input path="name" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <form:input path="description" class="form-control"/>
            </div>
            <div class="form-group" id="datepicker-container">
                <label for="psd">PSD:</label>
                <form:input path="psd" class="form-control"/>
            </div>
            <div class="form-group" id="datepicker-container">
                <label for="ped">PED:</label>
                <form:input path="ped" class="form-control"/>
            </div>

            <button name="submit" type="submit" class="btn btn-success">Add Project</button>

        </form:form>
    </div>
<jsp:include page="includes/foot.jsp"></jsp:include>

</body>
</html>
