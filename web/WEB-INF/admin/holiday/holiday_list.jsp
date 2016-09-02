<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tage
  Date: 4/4/16
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">

    <title></title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

<div>

    <s:property value="#session.error_message"></s:property>
    <s:set var="error_message" value="" scope="session"/>


</div>

<table border="2">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>route</th>
        <th>detail</th>
    </tr>
    <s:iterator value="allHolidays">
        <tr>
            <td>
                <s:property value="id"></s:property>
            </td>
            <td>
                <s:property value="theme"></s:property>
            </td>
            <td>
                <s:iterator value="sceneries">
                    <s:property value="name"></s:property>
                </s:iterator>
            <td>
                <a href="<s:url namespace="/admin/holiday" action="detail"></s:url>?holidayId=<s:property value="id"></s:property>">detail</a>
            </td>
        </tr>
    </s:iterator>

</table>

<s:debug></s:debug>
</body>
</html>
