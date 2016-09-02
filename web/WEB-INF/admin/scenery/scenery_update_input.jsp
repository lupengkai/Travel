<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tage
  Date: 9/1/16
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="<s:url action="update" namespace="/admin/scenery"></s:url>" method="post">

    <input type="hidden" name="id" value="<s:property value="sceneryInfo.id"></s:property> ">
    姓名 <input type="text" name="name" value="<s:property value="sceneryInfo.name"></s:property>"><br/>
    地址 <input type="text" name="coun" value="<s:property value="sceneryInfo.coun"></s:property>"> 国 <input type="text"
                                                                                                           name="prov"
                                                                                                           value="<s:property value="sceneryInfo.prov"></s:property>">
    省 <input type="text" name="city" value="<s:property value="sceneryInfo.city"></s:property>"> 市 <br/>


    等级

    <s:select list="sceneryLevels" name="levelId" theme="simple"
              listKey="id" listValue="name"
              value="sceneryInfo.levelId"

    >
    </s:select>
    <br/>

    类型

    <s:select list="sceneryTypes" name="typeId" theme="simple"
              listKey="id" listValue="name"
              value="sceneryInfo.typeId"
    >

    </s:select>

    <br/>
    门票 <input type="text" name="price" value="<s:property value="sceneryInfo.price"></s:property>"><br/>
    介绍 <input type="text" name="introduction" value="<s:property value="sceneryInfo.introduction"/>"> <br/>

    上传照片 <input type="text" name="photo" value="<s:property value="sceneryInfo.photo"/>">

    <input type="submit" value="update">
</form>
</body>
</html>