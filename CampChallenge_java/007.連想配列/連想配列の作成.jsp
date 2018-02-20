<%@ page import="java.util.*" %>
<%
HashMap<String, String> user1 =
            new HashMap<String, String>();
HashMap<String, String> user2 =
            new HashMap<String, String>();
HashMap<String, String> user3 =
            new HashMap<String, String>();
HashMap<String, String> user4 =
            new HashMap<String, String>();

user1.put("1","AAA");
user2.put("hello","world");
user3.put("soeda", "33");
user4.put("20", "20");

out.print(user1);
out.print(user2);
out.print(user3);
out.print(user4);
%>