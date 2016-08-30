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


<form action="<s:url action="register_confirm"></s:url> " method="post">

    用户名: <input type="text" name="name"> <br/>
    密码:<input type="password" name="password1"><br/>
    重复密码:<input type="password" name="password2"><br/>
    联系电话:<input type="text" name="phone">
    性别:<input type="radio" name="sex" value="1">男 <input type="radio" name="sex" value="0">女<br/>
    出生日期:<input type="text" name="birth_year">年 <input type="text" name="birth_month">月 <input type="text"
                                                                                               name="birth_day">日<br/>
    居住地:<input type="text" name="location_coun"> <input type="text" name="location_prov">省 <input type="text"
                                                                                                  name="location_city">市<br/>

    证件类型:
    <select name="documentType">
        <s:iterator value="allDocumentTypes">
            <option value="<s:property value="id"/> "><s:property value="name"/></option>
        </s:iterator>
    </select><br/>
    证件号码:<input type="text" name="ID_number"> <br/>

    <input type="submit" value="注册">
</form>
<s:debug/>
</body>
</html>
