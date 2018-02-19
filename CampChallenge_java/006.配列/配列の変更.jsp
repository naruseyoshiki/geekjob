<%@ page import="java.util.ArrayList" %>
<%
  ArrayList<String> a = new ArrayList<String>();
  
 a.add("10,");
 out.print(a.get(0));
 
 a.add("100,");
 out.print(a.get(1));
 
 a.add("soeda,");
 a.set(2,"33,");
 out.print(a.get(2));

 a.add("hayashi,");
 out.print(a.get(3));
 
 a.add("-20,");
 out.print(a.get(4));

 a.add("118,");
 out.print(a.get(5));

 a.add("END");
 out.print(a.get(6));






%>