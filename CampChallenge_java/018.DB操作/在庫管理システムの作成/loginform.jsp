<%-- 
    Document   : loginform
    Created on : 2018/04/09, 18:59:22
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>ユーザーログイン(userkanriへ)</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <form action="./sinanilogin" method="post">
                <label>ユーザー名(name)</label><br>
            <input type="text" name="N"><br>
            <label>パスワード(pass)</label><br>
            <input type="password" name="P"><br>
            <input type="submit" name="sousin" value="送信"><!--sinaniloginに送信-->
            <input type="reset" name="kesu" value="リセット">
            </form>
        </div>
    </body>
</html>
