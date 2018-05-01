<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="java.text.SimpleDateFormat" %>
<%
    JumsHelper jh = JumsHelper.getInstance();

    //〇詳細情報をDTOに代入
    UserDataDTO udd = (UserDataDTO) request.getAttribute("resultDatail");

    //〇DTOのBirthdayから各変数に代入、SimpleDateFormat型で表示
    String year = new SimpleDateFormat("yyyy").format(udd.getBirthday());
    String month = new SimpleDateFormat("MM").format(udd.getBirthday());
    String day = new SimpleDateFormat("dd").format(udd.getBirthday());

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
        <!--〇各表示部分にDTOから各値を取得した情報を格納-->
        <form action="UpdateResult" method="POST">
            名前:
            <input type="text" name="name" value="<%= udd.getName()%>">
            <br><br>

            生年月日:　
            <select name="year">
                <option value="<%=year%>"><%=year%></option>
                <% for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>" ><%=i%></option>
                <% }%>
            </select>年
            <select name="month">
                <option value="<%=month%>"><%=month%></option>
                <% for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>" ><%=i%></option>
                <% }%>
            </select>月
            <select name="day">
                <option value="<%=day%>"><%=day%></option>
                <% for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            </select>日
            <br><br>

            種別:
            <br>
            <% for (int i = 1; i <= 3; i++) {%>
            <input type="radio" name="type" value="<%=i%>"<% if (i == udd.getType()) {
                    out.print("checked");
                }%>><%=jh.exTypenum(i)%><br>
            <% }%>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%=udd.getTell()%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udd.getComment()%></textarea><br><br>

            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>
        <!--〇詳細画面に戻るボタンの作成、DTOのUserIDを呼ぶ(クエリストリング)-->
        <a href="ResultDetail?id=<%=udd.getUserID()%>">詳細画面に戻る</a><br>
        <%=jh.home()%>
    </body>
</html>
