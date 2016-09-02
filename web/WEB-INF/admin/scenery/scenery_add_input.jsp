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
<s:property value="#session.error_message"></s:property>
<s:set var="error_message" value="" scope="session"/>


</div>
<form action="<s:url action="add" namespace="/admin/scenery"></s:url>" method="post">


    姓名 <input type="text" name="name"><br/>
    地址 <input type="text" name="coun"> 国 <input type="text" name="prov"> 省 <input type="text" name="city"> 市 <br/>


    等级 <select name="levelId">
    <s:iterator value="sceneryLevels">
        <option value="<s:property value="id"/>"><s:property value="name"/></option>
    </s:iterator>
</select><br/>

    类型 <select name="typeId">
    <s:iterator value="sceneryTypes">
        <option value="<s:property value="id"/>"><s:property value="name"/></option>
    </s:iterator>
</select><br/>
    门票 <input type="text" name="price"> <br/>
    介绍 <input type="text" name="introduction"> <br/>

    上传照片 <input type="text" name="photo" value="todo">

    <input type="submit" value="创建">
</form>
</body>
</html>
