<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tage
  Date: 8/31/16
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
name:<s:property value="scenery.name"></s:property> <br/>
city:<s:property value="scenery.city"></s:property> <br/>
country:<s:property value="scenery.coun"></s:property> <br/>
province:<s:property value="scenery.prov"></s:property> <br/>
city:<s:property value="scenery.city"></s:property> <br/>
price:<s:property value="scenery.price"></s:property> <br/>
introduction:<s:property value="scenery.introduction"></s:property><br/>
level:<s:property value="scenery.level.name"></s:property><br/>
type:<s:property value="scenery.type.name"></s:property><br/>


<a href="<s:url namespace="/admin/scenery" action="update_input"></s:url>?sceneryId=<s:property value="scenery.id"></s:property>">update</a>
<a href="<s:url namespace="/admin/scenery" action="delete"></s:url>?sceneryId=<s:property value="scenery.id"></s:property>">delete</a>


</body>
</html>
