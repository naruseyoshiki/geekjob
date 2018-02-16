<%@ page contentType="text/html; charset=UTF-8"%>
<%
int s =1000;
   s +=15;
   
   out.print("こんにちは！"); 
   
   String n = "私は";
   String text= "成瀬良輝です。";
   String text2= "プログラミングを学習中";
   
   n += text+text2;

   out.print(n);
   out.print("の社会人です。");

out.print(s);

%>        
  