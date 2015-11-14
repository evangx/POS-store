import java.awt.*;
import java.awt.event.*;
import java.applet.Applet.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import RhmTools.*;
public class Categorias_r extends XFrame implements ActionListener{
TextField t1;
TextField t2;
TextField t3;
Label l1;
Label l2;
Label l3;
Statement st;
int cc;
Button b;

public void start(){
t2.setText("");
t3.setText("");
if(makeConnection()){
try{
st=cn.createStatement();
String sql="select count(idcat) as cat from categorias";
ResultSet rs=st.executeQuery(sql);
System.out.println();
while(rs.next()){
String a=rs.getInt(1)+"";
a=a.replace("SQLServerResultSet:","");
cc=Integer.parseInt(a)+1;
t1.setText("Ca-"+cc);
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
if(!t1.getText().equals("") & !t2.getText().equals("") & !t3.getText().equals("")){
String a=t1.getText();
String b=t2.getText();
String c=t3.getText();

try{
det dez = new det();
if(dez.name(t2.getText(), 20) & dez.name(t3.getText(), 30)){
st=cn.createStatement();
String sql="insert into categorias values('";
sql+=a;
sql+="', '";
sql+=b+"', '"+c;
sql+="')";
int eaz=st.executeUpdate(sql);
javax.swing.JOptionPane.showMessageDialog(null,"Se han creado "+eaz+" registros en la base de datos","informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE);
start();
}
else{
javax.swing.JOptionPane.showMessageDialog(null, "Introdusca datos correctos para nombre y localizacion a-z A-Z .", "Error",javax.swing.JOptionPane.ERROR_MESSAGE);
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


public Categorias_r(){
setBackground(Color.gray);
setLayout(null);
setSize(400,400);
l1 = new Label("Clave de la categoria");
t1 = new TextField(8);
l2 = new Label("Nombre");
t2 = new TextField(20);
l3 = new Label("Localizacion");
t3 = new TextField(20);
t1.setText("Ca-"+cc);
//t1.setEditable(false);
b = new Button("Registrar");
add(l1);
add(t1);
add(l2);
add(t2);
add(l3);
add(t3);
add(b);
l1.setBounds(24, 75, 71, 23);
l2.setBounds(24, 103, 90, 23);
l3.setBounds(24, 131, 90, 23);
t1.setBounds(114, 75, 270, 23);
t2.setBounds(114, 103, 270, 23);
t3.setBounds(114, 131, 270, 23);
b.setBounds(167, 215, 65, 23);
b.addActionListener(this);
setUndecorated(true);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-200, 50);
start();
}

public void paint(Graphics g){
g.setColor(Color.red);
g.setFont(new Font("Arial", Font.BOLD, 25));
g.drawString("Registrar nueva Categoria", 60, 60);
}

public static void main(String [] args){
Categorias_r p = new Categorias_r();

}
}