<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans"%>
<%
    JumsHelper jh = JumsHelper.getInstance();

    //〇更新情報をリクエストディスパッチャーから取得
    UserDataBeans udb = (UserDataBeans) request.getAttribute("updateData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <!--〇変更結果に各値を格納-->
        <h1>変更結果</h1><br>
        名前:<%=udb.getName()%><br>
        生年月日:<%=udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日"%><br>
        種別:<%=udb.getType()%><br>
        電話番号:<%=udb.getTell()%><br>
        自己紹介:<%=udb.getComment()%><br>
        以上の内容で登録しました。<br>
    </body>
    <a href="ResultDetail?id=<%=udb.getuserID()%>">詳細画面に戻る</a><br>
    <%=jh.home()%>
</body>
</html>
