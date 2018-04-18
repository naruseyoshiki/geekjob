<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDateBeans" %>
<%
    HttpSession hs = request.getSession();

    UserDateBeans UDB = new UserDateBeans();

    String name = request.getAttribute("name").toString();
    String birthday = request.getAttribute("birthday").toString();
    String type = request.getAttribute("type").toString();
    String tell = request.getAttribute("tell").toString();
    String comment = request.getAttribute("comment").toString();
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        <%=JumsHelper.getInstance().backform(name, birthday, type, tell, comment)%>
        以上の内容で登録しました。<br>
        <br>
        <%=JumsHelper.getInstance().home()%>
        <!--登録が終わったのでセッションのクリア、破棄-->
        <%=hs.invalidate()%>
    </body>
</html>
