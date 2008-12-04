<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
<title>Login: Spring Security Web Application</title>
</head>

<body onload='document.loginForm.j_username.focus();'>

<form id="loginForm" name="loginForm" action="j_spring_security_check" method="post">
        <table>
          <tr><td>Username</td><td><input id="usernameField" type="text" name="j_username" /></td></tr>
          <tr><td>Password</td><td><input id="passwordField" type="password" name="j_password" /></td></tr>

          <tr><td colspan="2" align="right"><input type="submit" value="Login" /></td></tr>
        </table>
</form>

</body>

</html>