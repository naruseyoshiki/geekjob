<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="java.util.ArrayList"%>
<!--〇ArrayListをimport-->
<%
    JumsHelper jh = JumsHelper.getInstance();
    //〇DTOの各値をArrayListでインスタンス生成
    ArrayList<UserDataDTO> uddList = (ArrayList<UserDataDTO>) request.getAttribute("resultData");

    //〇セッション取得
    HttpSession hs = request.getSession();

    //〇セッションにDTOの各値を格納
    hs.setAttribute("resultData", uddList);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <%for (int i = 0; i <= uddList.size(); i++) {
                    UserDataDTO udd = uddList.get(i);%>
            <tr>
                <td><a href="ResultDetail?id=<%= udd.getUserID()%>"><%= udd.getName()%></a></td>
                <td><%= udd.getBirthday()%></td>
                <td><%= jh.exTypenum(udd.getType())%></td><%--〇exTypenumでtypeを日本語表示--%>
                <td><%= udd.getNewDate()%></td>
                <%}%>
            </tr>
            <br>
        </table>
    </body>
    <%=jh.home()%>
</html>
