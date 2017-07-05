<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN" method="post">
    <p>
        <span>title: </span>
        <input type="text" name="title">
    </p>

    <p>
        <span>thumb_media_id: </span>
        <input type="text" name="thumb_media_id">
    </p>

    <p>
        <span>author: </span>
        <input type="text" name="author">
    </p>

    <p>
        <span>digest: </span>
        <input type="text" name="digest">
    </p>

    <p>
        <span>show_cover_pic: </span><br>
        <span>false</span><input type="radio" name="show_cover_pic" value="false">
        <span>true</span><input type="radio" name="show_cover_pic" value="true">
    </p>

    <p>
        <span>content:</span>
        <input type="text" name="content">
    </p>


</form>
</body>
</html>