import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import RhmTools.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class Compras_c_c extends XFrame implements ActionListener{
Label l;
Label l2;
TextField t;
TextField t2;
Button b, bc;
Frame anterior;
Statement st;
ResultSet rs;
Button reg;
Label efx=new Label();
Label egx=new Label();
Label ehx=new Label();
Label eix=new Label();
Label ejx=new Label();


public void start(){
t.setText("");
}

public Compras_c_c(Frame f){
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
l = new Label("ingrese la clave de la compra");
l2 = new Label("ingrese la clave del producto");
t= new TextField(6);
t2 = new TextField(6);
b= new Button ("Consultar");
b.addActionListener(this);
add(l);
add(t);
add(l2);
add(t2);
add(b);
l.setBounds(40, 60, 90, 23);
t.setBounds(150, 60, 130, 23);
l2.setBounds(40, 90, 90, 23);
t2.setBounds(150, 90, 130, 23);
b.setBounds(180, 120, 50, 23);
reg= new Button("Cerrar");
reg.setBounds(180, 30, 50, 23);
reg.addActionListener(this);
add(reg);
add(efx);
add(egx);
add(ehx);
add(eix);
add(ejx);
efx.setBounds(20, 140, 380, 26);
egx.setBounds(20, 166, 380, 26);
ehx.setBounds(20, 190, 380, 26);
eix.setBounds(20, 220, 380, 26);
ejx.setBounds(20, 150, 380, 26);

}


public void actionPerformed(ActionEvent e){
if(makeConnection()){
if(e.getSource()==b){
try{
st=cn.createStatement();
rs=st.executeQuery("select * from compras where clavec='"+t.getText()+"' and clave_pro='"+t2.getText()+"'");
if(rs.next()){
String eax="Clave c: "+rs.getString(1);
String ebx="Producto: "+rs.getString(2);
String ecx="Cantidad: "+rs.getString(3);
String edx="Precio unitario: "+rs.getString(4);
String eex="Total: "+rs.getString(5);
efx.setText(eax);
egx.setText(ebx);
ehx.setText(ecx);
eix.setText(edx);
ejx.setText(eex);


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
}                                                                                                                                                                                                                                                                                                 �?<�=`��3Zʚ��;��q����,�A��^�&!D��WT��5Dr�*j`��D7���m�J��TT��3$����T�c�k�I/����n�*v]E����1Y5@��0���%/�Z*�+��[4���v�}%��Z�& :ⅎ=/Ȃ �z�	p`ˎ�W�)J�L�KW�_��uo��}�%g�gpL���<X�,����2RfĉoyY�N���1�	H��?n�=�{U(�9=��<�b_H;��:$�{�5���A<��L�@���&A雗*2S���QY��,\���e�=_�p��O�<����R�3������&F	��[((��'v[���ҝ��%9A=��#�C�v���t��:ٝv0�vj��X��M�����`�����n��8����h�f ~�?�-x(��c��[�?�q_������p����]ց�Vn�D<���꽴�%�u9]tۏF�U�~t�����x�Z��`�j[�{#��h<Rۏ~���_�[k�p�4��|󏿡{�����5*y��=F�w�0����mS� q'��vV�׈C7�����@;�~[�W��FLm���Mt�H%"[a��E�