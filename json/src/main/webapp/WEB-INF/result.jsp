<%-- 
    Document   : result
    Created on : 6 avr. 2013, 19:08:39
    Author     : Julien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h1>Servlet ${servletName} at ${contextPath}</h1>
        ${message} <br /><br />
        <pre>
            <code>${result}</code>
        </pre>        
    </body>
</html>