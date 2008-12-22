<div id="navcontainer">
<ul id="navlist">
    <li class="home"><a href="home.htm">Home</a></li>
    <security:authorize ifAnyGranted="ROLE_ADMIN"><li><a href="admin.htm">Admin</a></li></security:authorize>
    <li><a href="logout.htm">Logout</a></li>
    <li><a href="acldemo.htm">ACL Demo</a></li>
    
</ul>
</div>