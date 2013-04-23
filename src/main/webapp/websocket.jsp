<%-- 
    Document   : websocket
    Created on : 12 avr. 2013, 10:00:39
    Author     : 912580
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javascript" type="text/javascript">
            var wsUri = "ws://localhost:8080/javaee7/websocket-hello";
            var websocket = new WebSocket(wsUri);
            websocket.onopen = function(evt) { onOpen(evt) };
            websocket.onmessage = function(evt) { onMessage(evt) };
            websocket.onerror = function(evt) { onError(evt) };

            function init() {
            output = document.getElementById("output");
            }

            function send_echo() {
            websocket.send(textID.value);
            writeToScreen("SENT: " + textID.value);
            }

            function onOpen(evt) {
            writeToScreen("CONNECTED");
            }

            function onMessage(evt) {
            writeToScreen("RECEIVED: " + evt.data);
            }

            function onError(evt) {
            writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
            }

            function writeToScreen(message) {
            var pre = document.createElement("p");
            pre.style.wordWrap = "break-word";
            pre.innerHTML = message;
            output.appendChild(pre);
            }

            window.addEventListener("load", init, false);
           </script>
    </head>
    <body>
        <div style="text-align: center;">
         <form action=""> 
         <input onclick="send_echo()" value="Press me" type="button"> 
         <input id="textID" name="message" value="Hello WebSocket!" type="text"><br>
         </form>
        </div>
        <div id="output"></div>


    </body>
</html>
