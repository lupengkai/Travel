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

<table>
    <tr>
        <th>Holiday</th>
        <th>Retailer</th>
        <th>Time</th>
        <th>Operation</th>
    </tr>
    <s:iterator value="orderItems">
        <tr>
            <td>
                <s:property value="holiday.theme"></s:property>
            </td>
            <td>
                <s:property value="retailer.name"></s:property>
            </td>
            <td>
                <s:property value="timestamp"></s:property>
            </td>
            <td>
                <a href="<s:url namespace="/order" action="delete"></s:url>?orderId=<s:property value="id"></s:property>">取消</a>
            </td>
        </tr>
    </s:iterator>

</table>

<s:debug></s:debug>
</body>
</html>
