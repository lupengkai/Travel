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


<div>
    <s:property value="#session.route"></s:property>


</div>


<table>
    <th>
    <td>id</td>
    <td>name</td>
    <td>detail</td>
    <td>add</td>
    </th>
    <s:iterator value="allSceneries">
        <tr>
            <td>
                <s:property value="id"></s:property>
            </td>
            <td>
                <s:property value="name"></s:property>
            </td>
            <td>
                <a href="<s:url namespace="/admin/scenery" action="detail"></s:url>?sceneryId=<s:property value="id"></s:property>">detail</a>
            </td>

            <td>
                <a href="<s:url namespace="/admin/holiday/route" action="scenery_add"></s:url>?sceneryId=<s:property value="id"></s:property>">
                    add

                </a></td>
        </tr>
    </s:iterator>

</table>
<a href="<s:url namespace="/admin/holiday/route" action="confirm"></s:url>">确认</a>
<s:debug></s:debug>
</body>
</html>
