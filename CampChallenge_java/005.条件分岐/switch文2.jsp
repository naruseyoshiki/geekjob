<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<%
char a ='B';    

switch(a){
    case 'A':
      out.print("英語");
      break;
    
    case 'あ':
      out.print("日本語");
      break;

}
%>