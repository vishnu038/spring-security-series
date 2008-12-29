<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
<title>Method Demo: Spring Security Web Application</title>
</head>

<body>

<%@ include file="/WEB-INF/jsp/userinfobar.jsp"%>
<%@ include file="/WEB-INF/jsp/navigation.jsp" %>

<h3>PROJECTS</h3>
<table border="0">
<c:forEach var="project" items="${model.projects}">
  <tr>
  <td>
      <c:out value="${project.id}"/>
  </td>
  <td>
      <c:out value="${project.name}"/>
  </td>
  <td>
      <c:out value="${project.description}"/>
  </td>
  </tr>
</c:forEach>
</table>

</body>

</html>