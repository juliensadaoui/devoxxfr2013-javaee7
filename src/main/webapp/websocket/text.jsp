<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/websocket/websocket.js"></script>
        <script language="javascript" type="text/javascript">
            var uri = "ws://" + document.location.host + "<%=request.getContextPath()%>/websocket-hello";
            connectToServer(uri);
        </script>
    </head>
    <body>
        <div style="text-align: center;">
         <form action=""> 
         <input onclick="send_text()" value="Press me" type="button"> 
         <input id="textField" name="message" value="Hello WebSocket!" type="text"><br>
         </form>
        </div>
        <div id="output"></div>

    </body>
</html>
