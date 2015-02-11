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
                      ${activity.member.employee.login} ${activity.comment} ${activity.assignment.task.description} ${activity.date}
              </p>
          </c:forEach>
      </div>
      <div class="col-md-4">
          <p class="lead">Assigned to me:</p>

          <c:forEach items="${assignments}" var="assignment">
              <c:choose>
                  <c:when test="${assignment.member.employee.login eq pageContext.request.userPrincipal.name}">
                      <p>
                           ${assignment.task.description}
                      </p>
                  </c:when>
                  <c:otherwise>

                  </c:otherwise>
              </c:choose>

          </c:forEach>
      </div>


  </div>
</div>

<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>