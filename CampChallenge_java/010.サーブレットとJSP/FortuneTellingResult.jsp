<%@page import="org.camp.servlet.ResultData" %>
<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<html>
    <head>
        <%
           ResultData data = (ResultData)request.getAttribute("DATA");
        %>    
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
          if(data != null){
              
            out.print("<h1>あなたの運勢は、"+data.getB()+" です!</h1>");
        }
        %>        
    </body>
</html>
