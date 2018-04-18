<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.UserDateBeans" %>
<%@page import="jums.JumsHelper" %>
<%

    HttpSession hs = request.getSession();

    hs.setAttribute("access", "yes");

    UserDateBeans USB = (UserDateBeans) session.getAttribute("usbDate");

    String name = (hs.getAttribute("name")).toString();
    String birthday = (String.valueOf(hs.getAttribute("year"))
            + (hs.getAttribute("month"))
            + (hs.getAttribute("day")));
    String type = (hs.getAttribute("type")).toString();
    String tell = (hs.getAttribute("tell")).toString();
    String comment = (hs.getAttribute("comment")).toString();
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if (USB.getcheak() == true) {%>

        <h1>登録確認</h1>
        <%=JumsHelper.getInstance().backform(name, birthday, type, tell, comment)%>
        上記の内容で登録します。よろしいですか？

        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>

        <% } else {%>
        <h1>入力が不完全です</h1>
        <%=JumsHelper.getInstance().backform(name, birthday, type, tell, comment)%>
        <% }%>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
