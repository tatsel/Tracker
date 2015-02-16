<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container-fluid">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="well">
        <h1>Issue: ${assignment.task.summary}</h1>
        <h3>Project: <a href="<c:url value='${pageContext.request.contextPath}/home/projects/projectdetails/${assignment.task.project.id}'/>">${assignment.task.project.name}</a></h3>
        <c:if test="${assignment.member.employee.login eq pageContext.request.userPrincipal.name}">
            <form:form method="POST" action="${pageContext.request.contextPath}/home/issues/deleteIssue/${assignment.task.id}">
                <input type="submit" class="btn btn-danger btn-sm" value="Delete Issue" /><br>
            </form:form>

            <form:form action="${pageContext.request.contextPath}/home/issues/changeStatus/${assignment.id}/3" method="post" class="inlineForm">
                <input type="submit" class="btn btn-default" value="Suspend" <c:if test="${assignment.task.status.name != 'In progress'}">disabled="disabled"</c:if> />
            </form:form>
            <form:form action="${pageContext.request.contextPath}/home/issues/changeStatus/${assignment.id}/2" method="post" class="inlineForm">
                <input type="submit" class="btn btn-default" <c:if test="${assignment.task.status.name eq 'In progress'}">disabled="disabled"</c:if>
                        <c:choose>
                            <c:when test="${assignment.task.status.name eq 'Not started'}">
                                value="Start progress"
                            </c:when>
                            <c:otherwise>
                                value="Continue"
                            </c:otherwise>
                        </c:choose>
                />
            </form:form>
            <form:form action="${pageContext.request.contextPath}/home/issues/changeStatus/${assignment.id}/4" method="post" class="inlineForm">
                <input type="submit" class="btn btn-default" value="Complete" <c:if test="${assignment.task.status.name eq 'Completed'}">disabled="disabled"</c:if> />
            </form:form>
            </br>
            </br>

            <label>Assign to:</label>
            <form:form action="${pageContext.request.contextPath}/home/issues/changeAssignee/${assignment.id}" method="post" modelAttribute="assignee">
                <div class="form-group">
                    <form:select path="memberId" class="form-control">
                        <c:forEach items="${members}" var="member">
                            <c:choose>
                                <c:when test="${assignment.member.role.name eq 'Tester'}">
                                    <c:if test="${member.role.name eq 'Developer'}">
                                        <form:option value="${member.id}" label="${member.employee.login}" class="form-control"/>
                                    </c:if>
                                </c:when>
                                <c:when test="${assignment.member.role.name eq 'Developer'}">
                                    <c:if test="${member.role.name eq 'Tester'}">
                                        <form:option value="${member.id}" label="${member.employee.login}" class="form-control"/>
                                    </c:if>
                                </c:when>
                                <c:otherwise>
                                    <form:option value="${member.id}" label="${member.employee.login}, ${member.role.name}" class="form-control"/>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                </div>

                <input type="submit" class="btn btn-primary btn-sm" value="Assign" />
            </form:form>

            </br></br>
            <label>Add new attachment</label>
            <form:form method="post" action="${pageContext.request.contextPath}/home/issues/issuedetails/upload/${assignment.id}" modelAttribute="attachment" enctype="multipart/form-data">
                <div class="form-group">
                    <form:label path="content">Document:</form:label>
                    <input name="file" id="file" type="file" class="btn btn-info">
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <form:textarea path="description" class="form-control"/>
                </div>
                <input value="Add Document" type="submit" class="btn btn-sm btn-primary">
            </form:form>
        </c:if>
        <br>
        <label>Attachments:</label>
        <c:if test="${!empty attachments}">
            <table class="table-bordered issueTable">
                <tbody>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Download</th>
                        <c:if test="${assignment.member.employee.login eq pageContext.request.userPrincipal.name}">
                            <th>Delete</th>
                        </c:if>
                    </tr>
                <c:forEach items="${attachments}" var="attachment">
                    <tr>
                        <td>${attachment.name}</td>
                        <td>${attachment.description}</td>
                        <td>
                            <form:form method="POST" action="${pageContext.request.contextPath}/home/issues/issuedetails/download/${attachment.id}">
                                <input type="submit" class="btn btn-primary btn-xs" value="Download" /><br>
                            </form:form>
                        </td>
                        <c:if test="${assignment.member.employee.login eq pageContext.request.userPrincipal.name}">
                            <td>
                                <form:form method="POST" action="${pageContext.request.contextPath}/home/issues/issuedetails/delete/${assignment.id}/${attachment.id}">
                                    <input type="submit" class="btn btn-danger btn-xs" value="Delete" /><br>
                                </form:form>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody></table>
        </c:if>

        <label>Status:</label>
        <label>${assignment.task.status.name}</label></br></br>


        <label>Assignee:</label>
        <label>${assignment.member.employee.login}</label></br></br>

        <table class="issueTable">
            <thead>
                <tr>
                    <th>PSD</th>
                    <th>PED</th>
                    <th>ASD</th>
                    <th>AED</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${assignment.task.psd}   </td>
                    <td>${assignment.task.ped}   </td>
                    <td>${assignment.task.asd}   </td>
                    <td>${assignment.task.aed}   </td>
                </tr>
            </tbody>
        </table>
        <br><br>

        <label>Task Activities:</label></br>
        <c:forEach items="${activities}" var="activity">
            <p>
                    ${activity.member.employee.login} ${activity.comment} on ${activity.date}
            </p>
        </c:forEach>

    </div>
    <jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>