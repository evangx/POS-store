import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import RhmTools.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class Deta_Prove_e_e extends XFrame implements ActionListener{
Label l;
Label l2;
TextField t2;
TextField t;
int a;
Button b, bc;
Frame anterior;
Statement st;
ResultSet rs;
Button reg;
String cl;
Button chp;
Choice ch;

public void sal(){
setVisible(false);
anterior.setVisible(true);
}

public void start(){
t.setText("");
}

public Deta_Prove_e_e(Frame f){
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
l = new Label("ingrese la clave del Proveedor");
t= new TextField(6);
l2 = new Label("ingrese el id del tel.");
t2= new TextField(6);
b= new Button ("eliminar");
b.addActionListener(this);
add(l);
add(t);
add(l2);
add(t2);
add(b);
l.setBounds(10, 65, 165, 23);
t.setBounds(190, 65, 100, 23);
l2.setBounds(40, 90, 125, 23);
t2.setBounds(180, 90, 100, 23);
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
try{
a=Integer.parseInt(t2.getText());
}
catch(Exception evc){
javax.swing.JOptionPane.showMessageDialog(null, " El id del telefono debe ser un dato entero", "error",javax.swing.JOptionPane.ERROR_MESSAGE);
}
rs=st.executeQuery("select * from detalle_proveedores where clavepr='"+t.getText()+"' and numtelpr="+a);
if(rs.next()){
String eax="Clave: "+rs.getString(1);
cl=rs.getString(1);
String ebx="Id del telefono: "+rs.getString(2);
String ecx="telefono: "+rs.getString(3);

Label efx=new Label(eax);
Label egx=new Label(ebx);
Label ehx=new Label(ecx);

add(efx);
add(egx);
add(ehx);

efx.setBounds(20, 140, 380, 26);
egx.setBounds(20, 166, 380, 26);
ehx.setBounds(20, 190, 380, 26);

Label pr = new Label("�realmente desea eliminar este Proveedor?");
pr.setBounds(80, 250, 245, 24);
ch = new Choice();
ch.add("");
ch.add("si");
ch.add("no");
ch.setBounds(170,	275, 60, 24);
chp=new Button("Enviar Decision");
chp.setBounds(150, 300, 100, 24);
chp.addActionListener(this);
add(pr);
add(ch);
add(chp);
repaint();
validate();
}
else{
javax.swing.JOptionPane.showMessageDialog(null,"No se ha encontrado ningun Proveedor con esa clave", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
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
if(e.getSource()==chp){
if(ch.getSelectedItem()==""){
javax.swing.JOptionPane.showMessageDialog(null,"Seleccione una opcion","Error!!!",javax.swing.JOptionPane.ERROR_MESSAGE);
}
else if(ch.getSelectedItem()=="si"){
if(makeConnection()){
try{
Statement ee=cn.createStatement();
ee.execute("delete from detalle_proveedores where clavepr='"+cl+"' and numtelpr="+a);
javax.swing.JOptionPane.showMessageDialog(null, "el tel. del proveedor con clave "+ cl+" "+ a +" se ha eliminado correctamente", "Eliminado",javax.swing.JOptionPane.INFORMATION_MESSAGE);
start();
sal();
}

catch(SQLException mmm){
javax.swing.JOptionPane.showMessageDialog(null, "Primero Elimine todas las referencias que hagan referencia a este provedores\nEstado:"+mmm.getSQLState()+"\nError:"+mmm.getErrorCode(),"Eliminacion completa", javax.swing.JOptionPane.INFORMATION_MESSAGE);

}
catch(Exception err){
System.out.println(err.getMessage());
}
}
}
else if(ch.getSelectedItem()=="no"){
sal();
}
}
}
}