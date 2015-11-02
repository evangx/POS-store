import java.awt.*;
import java.awt.event.*;
import java.applet.Applet.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import RhmTools.*;
public class Proveedores_r extends XFrame implements ActionListener{
TextField t1;
TextField t2;
TextField t3;
TextField t4;
TextField t5;
Label l1;
Label l2;
Label l3;
Label l4;
Label l5;
Statement st;
int cc;
Button b;

public void start(){
t1.setText("");
t2.setText("");
if(makeConnection()){
try{
st=cn.createStatement();
String sql="select count(clavepr) as nombre from proveedores";
ResultSet rs=st.executeQuery(sql);
System.out.println();
while(rs.next()){
String a=rs.getInt(1)+"";
a=a.replace("SQLServerResultSet:","");
cc=Integer.parseInt(a)+1;
t4.setText("Pr-"+cc);
}
}
catch(Exception ez){
System.out.println(ez.getMessage());
}
}
else{}
}


public void actionPerformed(ActionEvent e){
if(e.getSource()==b){
if(makeConnection()){
if(!t1.getText().equals("") & !t2.getText().equals("") & !t4.getText().equals("")){
String a=t1.getText();
String b=t2.getText();
//String c=t3.getText();
String d=t4.getText();
try{
det dez= new det();
if(dez.name(t1.getText(),30) & dez.name(t2.getText(),30)){
st=cn.createStatement();
String sql="insert into proveedores values('";
sql+=d;
sql+="', '";
sql+=a+"', '"+b;
sql+="')";
int eaz=st.executeUpdate(sql);
javax.swing.JOptionPane.showMessageDialog(null,"Se han creado "+eaz+" registros en la base de datos","informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE);
start();
}
else{
javax.swing.JOptionPane.showMessageDialog(null,"Favor de revisar que los datos introducidos en el nombre y la direccion sean correctos\n a-z A-Z ' ' '.' ", "Error",javax.swing.JOptionPane.INFORMATION_MESSAGE);
}
}
catch(SQLException exz){
javax.swing.JOptionPane.showMessageDialog(null,"Ha ocurrido un error, favor de checar que la clave no ha sido ingresada ya con anterioridad  \n si el problema persiste contacte con el administrador \nError: "+exz.getSQLState()+"", "Error",javax.swing.JOptionPane.ERROR_MESSAGE);
}
catch(Exception ez){
System.out.println(ez.getMessage());
}

}
else{
javax.swing.JOptionPane.showMessageDialog(null,"Favor de llenar todos los datos correctamente", "Error!!!",javax.swing.JOptionPane.ERROR_MESSAGE);
}
}
else{
javax.swing.JOptionPane.showMessageDialog(null,"Un error ha ocurrido al intentar conectar con la base de datos, \n reinicie el componente o contacte con el administrador","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
}
}
try{
cn.close();
}
catch(Exception esa){
System.out.println(esa.getMessage());
}
}


public Proveedores_r(){
setBackground(Color.gray);
setLayout(null);
setSize(400,400);
l1 = new Label("Nombre    ");
t1 = new TextField(36);
l2 = new Label("Direccion");
t2 = new TextField(20);
//l3 = new Label("Telefono");
//t3 = new TextField(20);
l4 = new Label ("Clave del proveedor");
t4 = new TextField(5);
t4.setText("Pr-"+cc);
//t4.setEditable(false);
b = new Button("Registrar");
add(l1);
add(t1);
add(l2);
add(t2);
//add(l3);
//add(t3);
add(l4);
add(t4);
add(b);
l1.setBounds(24, 75, 71, 23);
l2.setBounds(24, 103, 90, 23);
//l3.setBounds(24, 131, 90, 23);
l4.setBounds(24, 159,111, 23);
t1.setBounds(114, 75, 270, 23);
t2.setBounds(114, 103, 270, 23);
//t3.setBounds(114, 131, 270, 23);
t4.setBounds(134, 159, 59, 23);
b.setBounds(167, 215, 65, 23);
b.addActionListener(this);
setUndecorated(true);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-200, 50);
start();
}

public void paint(Graphics g){
g.setColor(Color.red);
g.setFont(new Font("Arial", Font.BOLD, 25));
g.drawString("Registrar nuevo Proveedor", 60, 60);
}

public static void main(String [] args){
Proveedores_r p = new Proveedores_r();
}
}