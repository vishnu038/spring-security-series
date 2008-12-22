<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
<title>ACL Demo: Spring Security Web Application</title>
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


<p>The table ACL_SID essentially lists all the users in our systems. 
In Spring Security, a security id (SID) is assigned to each user or role. 

This SID can be then used in an access control list (ACL) to specify which actions the user with that SID can perform on the desired objects. 

In fact, the SID may correspond to an user, a device or a system which can perform an action in the application, 
or it may correspond to a granted authority such as a role. 

The distinction between these two possibilities is made by the value in the principal column of the ACL_SID table: true indicates 
that the sid is a user, false means that the sid is a granted authority. 

Note that this table is not concerned with user names, passwords, or other user-related information, as it uses merely the id-s of the users.</p>
<h3>ACL_SID</h3>
<table border="1">
 <tr>
 <td>Id: for relations with other tables.</td>
 <td>Principal: is this SID mapped to a user(true) or a authority(false)?</td>
 <td>Sid: The sid of this user or role.</td>
 </tr>
<c:forEach var="aclSid" items="${model.aclSids}">
  <tr>
  <td>
      <c:out value="${aclSid.id}"/>
  </td>
  <td>
      <c:out value="${aclSid.principal}"/>
  </td>
  <td>
      <c:out value="${aclSid.sid}"/>
  </td>
  </tr>
</c:forEach>
</table>

<p>Each class from the system whose objects we wish to secure must be registered in the ACL_CLASS table and uniquely identified by Spring Security by an id.</p>
<h3>ACL_CLASS</h3>
<table border="1">
<tr>
 <td>Id: for relations with other tables.</td>
 <td>Class: the fully qualified name of the domain/business object that can be secured.</td>
 </tr>
<c:forEach var="aclClass" items="${model.aclClasses}">
  <tr>
  <td>
      <c:out value="${aclClass.id}"/>
  </td>
  <td>
      <c:out value="${aclClass.fullyQualifiedClassName}"/>
  </td>
  </tr>
</c:forEach>
</table>

<p>Every secured object in the system is uniquely identified and registered in a single row of the table ACL_OBJECT_IDENTITY. 
Such row specifies for each object its class id (object_id_class), 
and its id in the table where objects of this type are stored (object_id_identity). 

Each object must have an owner, and the owners SID is stored in the owner_sid column. 
If the object was inherited, the fields parent_object and entries_inheriting are used to give the due details.</p>
<h3>ACL_OBJECT_IDENTITY</h3>
<table border="1">
<tr>
 <td>Id: for relations with other tables.</td>
 <td>Object_id_class: the id (on ACL_CLASS) that describes what type of object this is.</td>
 <td>Object_id_identity: the id of the instance of the acl_class described. e.g. Product[id=1]</td>
 <td>owner_sid: the sid of the acl_sid entity that owns or created this instance.</td>
 <td>parent_object: </td>
 <td>entries_inheriting: </td>
 </tr>
<c:forEach var="aclObjectIdentity" items="${model.aclObjectIdentities}">
  <tr>
  <td>
      <c:out value="${aclObjectIdentity.id}"/>
  </td>
  <td>
      <c:out value="${aclObjectIdentity.objectIdClass}"/>
  </td>
    <td>
      <c:out value="${aclObjectIdentity.objectIdIdentity}"/>
  </td>
    <td>
      <c:out value="${aclObjectIdentity.ownerSid}"/>
  </td>
    <td>
      <c:out value="${aclObjectIdentity.parentObject}"/>
  </td>
    <td>
      <c:out value="${aclObjectIdentity.entriesInheriting}"/>
  </td>
  </tr>
</c:forEach>
</table>

<p>This table is used to specify what actions can be performed on each of the (ACL_OBJECT_IDENTITY) objects by the specified sid entities(ACL_SID).</p>
<h3>ACL_ENTRY</h3>
<table border="1">
<tr>
 <td>Id: for relations with other tables.</td>
 <td>acl_object_identity: the id item on the acl_object_identity table</td>
 <td>ace_order: ACE (access control entity), the order in which it is run.</td>
 <td>sid: sid that this entry applies to.</td>
 <td>mask: bit mask for permission (1=BasePermission.READ, 16=BasePermission.ADMINISTRATION)</td>
 <td>granted: permissions are granted if true, blocked if false</td>
 <td>audit_success: do we audit on success?</td>
 <td>audit_failure: do we audit on failure?</td>
 </tr>
<c:forEach var="aclEntry" items="${model.aclEntries}">
  <tr>
  <td>
      <c:out value="${aclEntry.id}"/>
  </td>
  <td>
      <c:out value="${aclEntry.aclObjectIdentity}"/>
  </td>
    <td>
      <c:out value="${aclEntry.aceOrder}"/>
  </td>
    <td>
      <c:out value="${aclEntry.sid}"/>
  </td>
    <td>
      <c:out value="${aclEntry.mask}"/>
  </td>
    <td>
      <c:out value="${aclEntry.granting}"/>
  </td>
   <td>
      <c:out value="${aclEntry.auditSuccess}"/>
  </td>
   <td>
      <c:out value="${aclEntry.auditFailure}"/>
  </td>
  </tr>
</c:forEach>
</table>

</body>

</html>