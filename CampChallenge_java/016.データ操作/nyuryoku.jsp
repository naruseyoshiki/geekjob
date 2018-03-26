<%-- 
    Document   : nyuryoku
    Created on : 2018/03/26, 14:01:37
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力データの取得と表示</title>
    </head>
    <body>
<%
    request.setCharacterEncoding("UTF-8");//受け取る情報の書式指定
    
out.print(request.getParameter("textname"));//各ボックスのname属性から情報を表示
out.print(request.getParameter("sei"));
out.print(request.getParameter("syumi"));

%>
    </body>
</html>
