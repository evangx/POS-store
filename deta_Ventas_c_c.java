import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import RhmTools.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class deta_Ventas_c_c extends XFrame implements ActionListener{
Label l;
TextField t;
Button b, bc;
Frame anterior;
Statement st;
ResultSet rs;
Button reg;

public void start(){
t.setText("");
}

public deta_Ventas_c_c(Frame f){
anterior=f;
ex();
}


public void ex(){

setSize(200,200);
setLayout(null);
anterior.setVisible(false);
setVisible(false);
setUndecorated(true);
setVisible(true);
setSize(400, 400);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-200, 50);
setBackground(Color.gray);
bc=new Button("Cerrar");
bc.addActionListener(this);
l = new Label("ingrese la clave de la venta");
t= new TextField(6);
b= new Button ("Consultar");
b.addActionListener(this);
add(l);
add(t);
add(b);
l.setBounds(40, 90, 90, 23);
t.setBounds(150, 90, 130, 23);
b.setBounds(180, 120, 50, 23);
reg= new Button("Cerrar");
reg.setBounds(180, 30, 50, 23);
reg.addActionListener(this);
add(reg);
}


public void actionPerformed(ActionEvent e){
if(makeConnection()){
if(e.getSource()==b){
try{
st=cn.createStatement();
rs=st.executeQuery("select * from detalle_ventas where clave_ven='"+t.getText()+"'");
if(rs.next()){
String eax="Clave: "+rs.getString(1);
String ebx="Vendedor: "+rs.getString(2);
String ecx="Cliente: "+rs.getString(3);
String edx="Fecha: "+rs.getString(4);
String efax="Monto Final: "+rs.getFloat(5);
Label efx=new Label(eax);
Label egx=new Label(ebx);
Label ehx=new Label(ecx);
Label eix=new Label(edx);
Label ejx=new Label(efax);
add(efx);
add(egx);
add(ehx);
add(eix);
add(ejx);
efx.setBounds(20, 140, 380, 26);
egx.setBounds(20, 166, 380, 26);
ehx.setBounds(20, 190, 380, 26);
eix.setBounds(20, 214, 380, 26);
ejx.setBounds(20, 240, 380, 26);
repaint();
validate();
}
else{
javax.swing.JOptionPane.showMessageDialog(null,"No se ha encontrado ninguna compra con esa clave", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
start();
}
}
catch(Exception ez){
System.out.println(ez.getMessage());
}
}
}
else{
javax.swing.JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos, reinicie el componente, o contacte al administrador", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
}
if(e.getSource()==reg){
setVisible(false);
anterior.setVisible(true);
}
}
}