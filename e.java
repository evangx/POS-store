import java.awt.*;
import java.sql.*;
public class e{
 
public static Connection es(){
try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=tienda;", "user","password");
return cn;
}
catch(Exception e){
System.out.println(e.getMessage());
return null;
}
}


public static void main (String args[]){
e F = new e();
}
}