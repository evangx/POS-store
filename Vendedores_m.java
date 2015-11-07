import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import RhmTools.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class Vendedores_m extends XFrame implements ActionListener{
Label l;
TextField t;
Button b, bc;
Frame anterior;
Statement st;
ResultSet rs;
Button reg;
String cl;
Button chp;
Choice ch;
TextField tx;
Label lx;
Button bx;
Button bx1;
Button bx2;
Label pr;
String eax;
String ebx;
String ecx;
String edx;
Label efx;
Label egx;
Label ehx;
Label eix;
public void qui(){
if (tx!=null){
remove(tx);
}
if (lx!=null){
remove(lx);
}
if (bx!=null){
remove(bx);
}
if (bx1!=null){
remove(bx1);
}
if (bx2!=null){
remove(bx2);
}
if (ch!=null){
remove(ch);
}
if (chp!=null){
remove(chp);
}
if (pr!=null){
remove(pr);
}
if (eix!=null){
remove(eix);
}
if (efx!=null){
remove(efx);
}
if (egx!=null){
remove(egx);
}
if (ehx!=null){
remove(ehx);
}
start();
}

public void start(){
t.setText("");
}

public Vendedores_m(){
ex();
}


public void ex(){

setSize(200,200);
setLayout(null);

setVisible(false);
setUndecorated(true);

setSize(400, 450);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-200, 50);
setBackground(Color.gray);
l = new Label("ingrese la clave del vendedor");
t= new TextField(6);
b= new Button ("Modificar");
b.addActionListener(this);
add(l);
add(t);
add(b);
l.setBounds(40, 90, 90, 23);
t.setBounds(150, 90, 130, 23);
b.setBounds(170, 120, 70, 23);
reg= new Button("Reiniciar");
reg.setBounds(180, 30, 50, 23);
reg.addActionListener(this);
add(reg);
}


public void actionPerformed(ActionEvent e){
if(makeConnection()){
if(e.getSource()==b){
try{
st=cn.createStatement();
rs=st.executeQuery("select * from vendedores where clavev='"+t.getText()+"'");
if(rs.next()){
eax="Clave: "+rs.getString(1);
cl=rs.getString(1);
ebx="Nombre: "+rs.getString(2);
ecx="Apeido P.: "+rs.getString(3);
edx="Apeido M.: "+rs.getString(4);
efx=new Label(eax);
egx=new Label(ebx);
ehx=new Label(ecx);
eix=new Label(edx);
add(efx);
add(egx);
add(ehx);
add(eix);
efx.setBounds(20, 140, 380, 26);
egx.setBounds(20, 166, 380, 26);
ehx.setBounds(20, 190, 380, 26);
eix.setBounds(20, 214, 380, 26);
pr = new Label("�Que elemento desea modificar?");
pr.setBounds(80, 250, 240, 24);
ch = new Choice();
ch.add("");
ch.add("Nombre");
ch.add("Apeido P");
ch.add("Apeido M");
ch.setBounds(150,	275, 100, 24);
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
javax.swing.JOptionPane.showMessageDialog(null,"No se ha encontrado ningun vendedor con esa clave", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
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
qui();
}
if(chp!=null){
if(e.getSource()==chp){
if(ch.getSelectedItem()==""){
javax.swing.JOptionPane.showMessageDialog(null,"Seleccione una opcion","Error!!!",javax.swing.JOptionPane.ERROR_MESSAGE);
}
else if(ch.getSelectedItem()=="Nombre"){
lx=new Label("Nuevo Nombre");
lx.setBounds(150, 335, 100, 25);
add(lx);
tx= new TextField();
tx.setBounds(150, 360, 100, 25);
add(tx);
bx=new Button ("Modificar");
bx.setBounds(160, 390, 80,24);
bx.addActionListener(this);
add(bx);
}
else if(ch.getSelectedItem()=="Apeido P"){
lx=new Label("Nuevo Apeido");
lx.setBounds(145, 335, 110, 25);
add(lx);
tx= new TextField();
tx.setBounds(150, 360, 100, 25);
add(tx);
bx1=new Button ("Modificar");
bx1.setBounds(160, 390, 80,24);
bx1.addActionListener(this);
add(bx1);
}
else if(ch.getSelectedItem()=="Apeido M"){
lx=new Label("Nuevo Apeido");
lx.setBounds(145, 335, 110, 25);
add(lx);
tx= new TextField();
tx.setBounds(150, 360, 100, 25);
add(tx);
bx2=new Button ("Modificar");
bx2.setBounds(160, 390, 80,24);
bx2.addActionListener(this);
add(bx2);
}
}
}
if(bx!=null){
if(e.getSource()==bx){
if(!tx.getText().equals("")){
if(makeConnection()){
try{
Statement stm=cn.createStatement();
javax.swing.JOptionPane.showMessageDialog(null, "Se han Modificado "+stm.executeUpdate("Update vendedores set nomv='"+tx.getText()+"' where clavev='"+cl+"'")+ " registros", "Modificacion", javax.swing.JOptionPane.INFORMATION_MESSAGE);
qui();
}
catch(Exception exz){
System.out.println(exz.getMessage());
}
}
}
else{
javax.swing.JOptionPane.showMessageDialog(null, "Dato a modificar no valido", "Error",javax.swing.JOptionPane.ERROR_MESSAGE);
qui();
}
}
}
if(bx1!=null){
if(e.getSource()==bx1){
if(!tx.getText().equals("")){
if(makeConnection()){
try{
Statement stm=cn.createStatement();
javax.swing.JOptionPane.showMessageDialog(null, "Se han Modificado "+stm.executeUpdate("Update vendedores set nomvap='"+tx.getText()+"' where clavev='"+cl+"'")+ " registros", "Modificacion", javax.swing.JOptionPane.INFORMATION_MESSAGE);
qui();
}
catch(Exception exz){
System.out.println(exz.getMessage());
}
}
}
else{
javax.swing.JOptionPane.showMessageDialog(null, "Dato a modificar no valido", "Error",javax.swing.JOptionPane.ERROR_MESSAGE);
qui();
}

}
}
if(bx2!=null){
if(e.getSource()==bx2){
if(!tx.getText().equals("")){
if(makeConnection()){
try{
Statement stm=cn.createStatement();
javax.swing.JOptionPane.showMessageDialog(null, "Se han Modificado "+stm.executeUpdate("Update vendedores set nomvam='"+tx.getText()+"' where clavev='"+cl+"'")+ " registros", "Modificacion", javax.swing.JOptionPane.INFORMATION_MESSAGE);
qui();
}
catch(Exception exz){
System.out.println(exz.getMessage());
}
}
}
else{
javax.swing.JOptionPane.showMessageDialog(null, "Dato a modificar no valido", "Error",javax.swing.JOptionPane.ERROR_MESSAGE);
qui();
}
}
}
}

public static void main(String [] args){
Vendedores_m ax = new Vendedores_m();
}
}
