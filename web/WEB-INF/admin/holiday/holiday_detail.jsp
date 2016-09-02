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
theme:<s:property value="holiday.theme"></s:property> <br/>
destination:<s:property value="holiday.destination"></s:property> <br/>
explanation:<s:property value="holiday.explanation"></s:property> <br/>
childPrice:<s:property value="holiday.childPrice"></s:property> <br/>
days:<s:property value="holiday.days"></s:property> <br/>
retailPrice:<s:property value="holiday.retailPrice"></s:property> <br/>
studentPrice:<s:property value="holiday.studentPrice"></s:property><br/>
traffic:<s:property value="holiday.traffic"></s:property><br/>
timestamp:<s:property value="holiday.timestamp"></s:property><br/>

<s:iterator value="holiday.sceneries">
    <s:property value="name"></s:property>
</s:iterator>


<a href="<s:url namespace="/admin/holiday" action="update_input"></s:url>?holidayId=<s:property value="holiday.id"></s:property>">update</a>


</body>
</html>
