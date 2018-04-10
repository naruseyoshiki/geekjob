<%-- 
    Document   : sinaform
    Created on : 2018/04/09, 19:01:33
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品情報登録(sinakanriへ)</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <form action="./sinahyouzi" method="post">
            <label>商品名(product)</label><br>
            <input type="text" name="product" value="りんご"><br><br>
            <label>価格(price)</label><br>
            <input type="text" name="price" value="100">円<br><br>
            <label>期限(duedate)</label><br>
            <select name="duedate">
                    <option value="2018-10-01">10月1日</option>
                    <option value="2018-10-02">10月2日</option>
                    <option value="2018-10-03">10月3日</option>
                    <option value="2018-10-04">10月4日</option>
            </select><br><br>
            <input type="submit" name="sousin" value="登録"><!--sinahyouziに送信-->
            <input type="reset" name="kesu" value="リセット">
            </form><br>
            <a href="loginform.jsp">ログアウトする</a><!--ログインログアウト機能-->
        </div>