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
        <p class="lead">Enter issue data here:</p>
        <c:if test="${noProjects}">
            Sorry, you're not a team leader or project manager yet
        </c:if>
        <c:if test="${!noProjects}">
            <form:form action="${pageContext.request.contextPath}/home/issues/addIssue" method="post" modelAttribute="issueForm">
                <div class="form-group">
                    <label for="project">Project:</label>
                    <form:select path="project" class="form-control">
                        <c:forEach items="${projects}" var="project">
                            <form:option value="${project.id}" label="${project.name}" class="form-control"/>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="summary">Summary:</label>
                    <form:input path="summary" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Assignee:</label>
                    <label class="form-control">${pageContext.request.userPrincipal.name}</label>
                </div>
                <div class="form-group" id="datepicker-container">
                    <label for="psd">PSD:</label>
                    <form:input path="psd" class="form-control"/>
                </div>
                <div class="form-group" id="datepicker-container">
                    <label for="ped">PED:</label>
                    <form:input path="ped" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <form:input path="description" class="form-control"/>
                </div>
                <%--<div class="form-group">
                    <label for="status">Status:</label>
                    <form:select path="status" class="form-control">
                        <c:forEach items="${statusList}" var="status">
                            <form:option value="${status.name}" label="${status.name}" class="form-control"/>
                        </c:forEach>
                    </form:select>
                </div>--%>

                <button name="submit" type="submit" class="btn btn-success">Add Issue</button>

            </form:form>
        </c:if>

    </div>
<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>
