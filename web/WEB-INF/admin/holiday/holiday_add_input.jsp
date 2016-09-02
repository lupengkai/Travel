<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tage
  Date: 9/1/16
  Time: 8:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div>
    <s:property value="#session.error_message"></s:property>
    <s:set var="error_message" value="" scope="session"/>


</div>

<div>
    <%-- <s:property value="#session.holidayInfo.sceneries"></s:property>--%>

</div>
<a href="<s:url namespace="/admin/holiday/route" action="scenery_list"/>"></a>

<form action="<s:url action="scenery_list" namespace="/admin/holiday/route"/>" method="post">

    theme: <input type="text" name="h_theme" value="<s:property value="#session.holidayInfo.h_theme"/>"/> <br/>
    destination: <input type="text" name="destination" value="<s:property value="#session.holidayInfo.destination"/>"/>
    <br/>
    retailerPrice: <input type="text" name="retailPrice"
                          value="<s:property value="#session.holidayInfo.retailPrice"/>"/> <br/>
    childPrice: <input type="text" name="childPrice" value="<s:property value="#session.holidayInfo.childPrice"/>"/>
    <br/>
    studentPrice: <input type="text" name="studentPrice"
                         value="<s:property value="#session.holidayInfo.studentPrice"/>"/> <br/>
    startTime: <input type="text" name="timestamp" value="<s:property value="#session.holidayInfo.timestamp"/>"/> <br/>
    traffic: <input type="text" name="traffic" value="<s:property value="#session.holidayInfo.traffic"/>"/> <br/>
    days: <input type="text" name="days" value="<s:property value="#session.holidayInfo.days"/>"/> <br/>
    explanation: <input type="text" name="explanation"
                        value="<s:property value="#session.holidayInfo.explanation"/>"/><br/>

    <input type="submit" value="保存并选择路线"/> <br/>
</form>
<s:debug/>
</body>
</html>
