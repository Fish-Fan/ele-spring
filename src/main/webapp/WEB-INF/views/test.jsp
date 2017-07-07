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
<form action="">
    <span>foodName: </span><input type="text" name="foodName" id="foodName">
    <br>
    <span>price: </span><input type="text" name="price" id="price">
    <br>
    <span>count: </span><input type="text" name="count" id="count">

    <button id="submit" type="button">提交</button>
</form>
<script src="http://cdn.bootcss.com/jquery/1.9.1/jquery.min.js"></script>
<script>
    $(function () {
        $('#submit').click(function () {
            $.ajax({
                url: "/api/order/pay",
                data: '{"foodName":"小红","price":12,"count": 10}', //要用双引号!!
                contentType: "application/json;charset=utf-8", // 因为上面是JSON数据

                type: "POST",
                headers: {
//                Accept: "application/xml",
                    Accept: "application/json",
                },
                success: function(data, textStatus){
                    console.log(data);
                    alert(data);
                },
                error: function (data, textStatus, errorThrown) {
                    console.log(data);
                },
            });
        });
    });
</script>
</body>
</html>