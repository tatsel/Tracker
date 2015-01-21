<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
  <title>Login Page</title>
  <link href="<c:url value="/resources/css/vendor/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/vendor/jumbotron-narrow.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
  <div class="jumbotron">
    <h2>Please, enter your login and password</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" name="username" class="form-control" required/>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" name="password" class="form-control" required/>
      </div>

      <button name="submit" type="submit" class="btn btn-success">Submit</button>

    </form>
  </div>
</div>

</body>
</html>