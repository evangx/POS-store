import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import RhmTools.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class Proveedores_c_c extends XFrame implements ActionListener{
Label l;
TextField t;
Button b, bc;
Frame anterior;
Statement st;
ResultSet rs;
Button reg;
Label efx=new Label();
Label egx=new Label();
Label ehx=new Label();
Label eix=new Label();


public void start(){
t.setText("");
}

public Proveedores_c_c(Frame f){
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
l = new Label("ingrese la clave del proveedor");
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
add(efx);
add(egx);
add(ehx);
efx.setBounds(20, 140, 380, 26);
egx.setBounds(20, 166, 380, 26);
ehx.setBounds(20, 190, 380, 26);

}


public void actionPerformed(ActionEvent e){
if(makeConnection()){
if(e.getSource()==b){
try{
st=cn.createStatement();
rs=st.executeQuery("select * from proveedores where clavepr='"+t.getText()+"'");
if(rs.next()){
String eax="Clave: "+rs.getString(1);
String ebx="Nombre: "+rs.getString(2);
String ecx="Direccion: "+rs.getString(3);
efx.setText(eax);
egx.setText(ebx);
ehx.setText(ecx);


repaint();
validate();
}
else{
javax.swing.JOptionPane.showMessageDialog(null,"No se ha encontrado ningun proveedor con esa clave", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
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