<%--<%@page session="false"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>
<div class="container-fluid">
  <jsp:include page="includes/navbar.jsp"></jsp:include>
  <div class="row">
      <div class="col-md-8">
          <p class="lead">Activities:</p>

          <c:forEach items="${activities}" var="activity">
              <p>
                  ${activity.member.employee.login} ${activity.comment} (Task: <a href="<c:url value='${pageContext.request.contextPath}/home/issues/issuedetails/${activity.assignment.id}'/>">${activity.assignment.task.summary}</a> Assignee: ${activity.assignment.member.employee.login}) on ${activity.date}
              </p>
          </c:forEach>
      </div>
      <div class="col-md-4">
          <p class="lead">Assigned to me:</p>

          <table class="table table-striped">
              <thead>
                  <tr>
                      <th>Project</th>
                      <th>Task Summary</th>
                  </tr>
              </thead>
              <tbody>
                  <c:forEach items="${employee.members}" var="member">
                      <c:forEach items="${member.assignments}" var="assignment">
                          <tr>
                              <td>
                                  <a href="<c:url value='${pageContext.request.contextPath}/home/projects/projectdetails/${assignment.task.project.id}'/>">${assignment.task.project.name}</a>
                              </td>
                              <td>
                                  <a href="<c:url value='${pageContext.request.contextPath}/home/issues/issuedetails/${assignment.id}'/>">${assignment.task.summary}</a>
                              </td>
                          </tr>
                      </c:forEach>
                  </c:forEach>
              </tbody>
          </table>

      </div>


  </div>
</div>

<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>