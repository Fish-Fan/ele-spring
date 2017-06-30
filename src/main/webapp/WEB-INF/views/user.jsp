<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <p>ID: ${user.id}</p>
    <p>姓名: ${user.username}</p>
    <p>密码: ${user.password}</p>
    <p>邮箱: ${user.email}</p>
    <p>头像: ${user.avatar}</p>
    <p>手机: ${user.phoneNum}</p>
    <p>微信: ${user.weixin}</p>
</body>
</html>