<div id="navcontainer">
<ul id="navlist">
    <li class="home"><a href="home.htm">Home</a></li>
    <security:authorize ifAnyGranted="ROLE_ADMIN"><li><a href="admin.htm">Admin</a></li></security:authorize>
    <li><a href="j_spring_security_logout">Logout</a></li>
    <li><a href="acldemo.htm">ACL Demo</a></li>
     <li><a href="methoddemo.htm">Method Demo</a></li>
    
</ul>
</div>