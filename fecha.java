import java.util.Scanner;
import java.io.*;
public class fecha{
String ecx;
public String programa(){
try{
Process p=Runtime.getRuntime().exec ("cmd /c date\n");
InputStream is=p.getInputStream();
Scanner eax = new Scanner(is);
ecx=eax.nextLine();
ecx=ecx.substring(21, 31);
}
catch(Exception e){
}
return ecx;
}
}