<%-- 
    Document   : sesson2
    Created on : 2018/03/29, 13:37:01
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力fの作成と実装(セッション)</title>
    </head>
    <body>
        <form action="sesson2" method="get">
        <h3>名前</h3><br><input type="text" name="name" ><br>
        <h3>性別</h3><br>
        男<input type="radio" name="sei" value="男"><br>
        女<input type="radio" name="sei" value="女"><br>
        <h3>趣味</h3><br><textarea name="syumi"></textarea><br>
        <input type="submit" name="sosin" value="送信">
        <input type="reset" name="kesu" value="リセット">
        </form>
    </body>
</html>
