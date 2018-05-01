<%@page import="jums.UserDataDTO"
        import="jums.JumsHelper"%>
<%
    //〇JumsHelperをインスタンス生成
    JumsHelper jh = JumsHelper.getInstance();

    //〇セッションを取得
    HttpSession hs = request.getSession();

    //〇空でなければ検索結果画面へ戻るボタンのURLに代入
    String Sname = "";
    String Syear = "";
    String Stype = "";
    if (!hs.getAttribute("Sname").equals("")) {
        Sname = (String) hs.getAttribute("Sname");
    }
    if (!hs.getAttribute("Syear").equals("")) {
        Syear = (String) hs.getAttribute("Syear");
    }
    if (hs.getAttribute("Stype") != null) {
        Stype = (String) hs.getAttribute("Stype");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
        <h1>削除確認</h1>
        削除しました。<br>

        <!--//〇検索結果画面へ戻るボタンの作成
        フォームに値が入っていればURLに代入-->
        <form method="GET">
            <a href="SearchResult?name=<%if (Sname.equals("")) {%><%=Sname%><%}%>
               =year<%if (Syear.equals("")) {%><%=Syear%><%}%>
               <%if (Stype.equals("")) {
                       out.print("&=Stype");%><%=Stype%>}">検索結果画面に戻る</a><br>
        </form>
        <%=jh.home()%>
        <!--セッションを削除する-->
        <%=hs.invalidate()%>
    </body>
</html>
