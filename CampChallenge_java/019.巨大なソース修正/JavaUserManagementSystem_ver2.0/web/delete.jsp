<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    //〇セッションを取得、検索結果IDを取得して格納
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultDatail");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？
    名前:<%= udd.getName()%><br>
    生年月日:<%= udd.getBirthday()%><br>
    種別:<%= jh.exTypenum(udd.getType())%><br>
    電話番号:<%= udd.getTell()%><br>
    自己紹介:<%= udd.getComment()%><br>
    登録日時:<%= udd.getNewDate()%><br>
    
    <!--削除する場合はIDで削除実行へ送信-->
    <!--削除しない場合はResultDetail.javaへ戻る-->
    <form action="DeleteResult?id=<%=udd.getUserID()%>" method="POST">
      <input type="submit" name="YES" value="はい"style="width:100px">
    </form><br>
    <form action="ResultDetail" method="POST">
      <input type="submit" name="NO" value="いいえ"style="width:100px">
    </form>
    </body>
</html>
