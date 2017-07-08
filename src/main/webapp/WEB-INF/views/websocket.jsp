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

<h1 style="text-align: center;">Hello World WebSocket Client</h1>

    <br>

    <div style="text-align: center;">
        <form action="">
            <input onclick="send_message()" value="Send" type="button">
            <input id="textID" name="message" value="Hello WebSocket!" type="text"><br>
        </form>
    </div>
    <div id="output"></div>


<script>
    var wsUri = getRootUri() + "/websocket-hello/hello";

    function getRootUri() {
        return "ws://" + (document.location.hostname == "" ? "localhost" : document.location.hostname) + ":" +
            (document.location.port == "" ? "8080" : document.location.port);
    }

    function init() {
        output = document.getElementById("output");
    }

    function send_message() {

        websocket = new WebSocket(wsUri);
        websocket.onopen = function(evt) {
            onOpen(evt)
        };
        websocket.onmessage = function(evt) {
            onMessage(evt)
        };
        websocket.onerror = function(evt) {
            onError(evt)
        };

    }

    function onOpen(evt) {
        writeToScreen("Connected to Endpoint!");
        doSend(textID.value);

    }

    function onMessage(evt) {
        writeToScreen("Message Received: " + evt.data);
    }

    function onError(evt) {
        writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
    }

    function doSend(message) {
        writeToScreen("Message Sent: " + message);
        websocket.send(message);
    }

    function writeToScreen(message) {
        var pre = document.createElement("p");
        pre.style.wordWrap = "break-word";
        pre.innerHTML = message;

        output.appendChild(pre);
    }

    window.addEventListener("load", init, false);
</script>
</body>
</html>