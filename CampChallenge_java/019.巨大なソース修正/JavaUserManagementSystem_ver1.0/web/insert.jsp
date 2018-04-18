<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDateBeans" %>
<%
    HttpSession hs = request.getSession();
    UserDateBeans UDB = new UserDateBeans();

    String name = "";
    String year = "";
    String month = "";
    String day = "";
    String type = "";
    String tell = "";
    String comment = "";

    //
    String yesname = "";
    String yesyear = "";
    String yesmonth = "";
    String yesday = "";
    String yestype1 = "checked";
    String yestype2 = "";
    String yestype3 = "";
    String yestell = "";
    String yescomment = "";

    if (hs.getAttribute("access").equals(true)) {
        name = hs.getAttribute("name").toString();
        year = hs.getAttribute("year").toString();
        month = hs.getAttribute("month").toString();
        day = hs.getAttribute("day").toString();
        Integer truetype = Integer.parseInt(type);

        switch (truetype) {
            case 1:
                yestype1 = "checked";
                break;

            case 2:
                yestype2 = "checked";
                yestype1 = "";
                break;

            case 3:
                yestype3 = "checked";
                yestype1 = " ";
                break;
        }
        tell = hs.getAttribute("tell").toString();
        comment = hs.getAttribute("comment").toString();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
        <form action="insertconfirm" method="POST">
            名前:
            <input type="text" name="name" value="<%=UDB.Sclear(UDB.Accessed(name, yesname))%>">
            <br><br>

            生年月日:
            <select name="year">
                <option value="<%=UDB.Sclear(UDB.Accessed(year, yesyear))%>"selected><%=UDB.Sclear(UDB.Accessed(year, yesyear))%></option>
                <%                for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>"> <%=i%> </option>
                <% }%>
            </select>年
            <select name="month">
                <option value="<%=UDB.Sclear(UDB.Accessed(month, yesmonth))%>"selected><%=UDB.Sclear(UDB.Accessed(month, yesmonth))%></option>
                <%
                    for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% }%>
            </select>月
            <select name="day">
                <option value="<%=UDB.Sclear(UDB.Accessed(day, yesday))%>"selected><%=UDB.Sclear(UDB.Accessed(day, yesday))%></option>
                <%
                    for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% }%>
            </select>日
            <br><br>

            種別:
            <br>
            <input type="radio" name="type" value="1" <%=yestype1%>>エンジニア<br>
            <input type="radio" name="type" value="2"<%=yestype2%>>営業<br>
            <input type="radio" name="type" value="3"<%=yestype3%>>その他<br>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%=UDB.Sclear(UDB.Accessed(tell, yestell))%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard">
                <%=UDB.Sclear(UDB.Accessed(comment, yescomment))%></textarea>
            <br><br>

            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
        
    </body>
</html>
