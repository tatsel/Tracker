<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

<div class="container">
  <div class="jumbotron">
      <sec:authorize var="loggedIn" access="isAuthenticated()" />
      <c:choose>
          <c:when test="${loggedIn}">
              <c:redirect url="${pageContext.request.contextPath}/home" />
          </c:when>
          <c:otherwise>
              <h2>Please, enter your login and password</h2>
              <form action="${pageContext.request.contextPath}/login" method="post">
                  <div class="form-group">
                      <label>Username:</label>
                      <input type="text" name="username" class="form-control" required/>
                  </div>
                  <div class="form-group">
                      <label>Password:</label>
                      <input type="password" name="password" class="form-control" required/>
                  </div>

                  <button name="submit" type="submit" class="btn btn-success">Submit</button>

              </form>
          </c:otherwise>
      </c:choose>

  </div>
</div>
<jsp:include page="includes/foot.jsp"></jsp:include>
</body>
</html>