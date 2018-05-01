<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    //〇セッションを取得
    HttpSession hs = request.getSession();
    
    //〇DTO変数に検索結果IDを含むオブジェクトを代入
    UserDataDTO udd = (UserDataDTO) request.getAttribute("resultDatail");
    
    //〇空でなければ検索結果画面へ戻るボタンのURLに代入
    String Sname ="";
    String Syear ="";
    String Stype ="";
    if(!hs.getAttribute("Sname").equals("")){
        Sname = hs.getAttribute("Sname").toString();
    }
    if(!hs.getAttribute("Syear").equals("")){
        Syear = hs.getAttribute("Syear").toString();
    }
    if(hs.getAttribute("Stype")!=null){
        Stype = hs.getAttribute("Stype").toString();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        
        <h1>詳細情報</h1>
        ID:<%= udd.getUserID()%><br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
        
        <form action="Update" method="POST">
            <input type="submit" name="update" value="変更"style="width:100px">
        </form>
        <form action="Delete" method="POST">
            <input type="submit" name="delete" value="削除"style="width:100px">
        </form>
        
        <!--〇検索結果画面へ戻るボタンの作成
        フォームの値があればURLを代入-->
        <form method="GET">
            <a href="SearchResult?name=<%if (!Sname.equals("")) {%><%=Sname%><%}%>
               &year=<%if (!Syear.equals("")) {%><%=Syear%><%}%>
               <%if (!Stype.equals("")) {
                       out.print("&=type");%><%=Stype%>}%>">検索結果画面へ戻る</a><br>
            <%=jh.home()%>
        </form>
        
    </body>
</html>
