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
    
out.print(request.getParameter("textname"));//ボックスのname属性から情報を表示

//name属性から情報を文字列変数に代入
String sei = request.getParameter("sei");

//文字列を数値に入れ替え、代入
int s = Integer.parseInt(sei);

//各選択した情報に沿って表示
switch(s){
    case 1:{
        out.print("<br>男<br>");
        break;
    }    
    case 2:{
        out.print("<br>女<br>");
        break;
    }
}
out.print(request.getParameter("syumi"));

%>
    </body>
</html>
