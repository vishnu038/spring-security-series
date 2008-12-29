<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<html>

<head>
<title>Home: Spring Security Web Application</title>

</head>

<body>
<%@ include file="/WEB-INF/jsp/userinfobar.jsp"%>
<%@ include file="/WEB-INF/jsp/navigation.jsp" %>


home page: only logged in users should see this page.

</body>

</html>