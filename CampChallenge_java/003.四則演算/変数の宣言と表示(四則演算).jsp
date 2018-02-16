<%
final int n = 10000;
int a =100;

int r = n + a;
int u = r - a;
int s = u * a;
int e = n + a - r * u; 

int naruse = n+a+r+u+s+e;
        
out.print(++naruse);

%>