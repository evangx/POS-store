import java.awt.*;
import java.awt.event.*;
import java.applet.Applet.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import RhmTools.*;
public class Deta_Prove_r extends XFrame implements ActionListener{
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


public void actionPerformed(ActionEvent e){
if(e.getSource()==b){
if(makeConnection()){
if(!t1.getText().equals("") & !t2.getText().equals("") & !t4.getText().equals("")){
String a=t1.getText();
String b=t2.getText();
//String c=t3.getText();
String d=t4.getText();
try{
st=cn.createStatement();
String sql="insert into detalle_proveedores values('";
sql+=a;
sql+="', '";
sql+=b+"', '"+d;
sql+="')";
int eaz=st.executeUpdate(sql);
javax.swing.JOptionPane.showMessageDialog(null,"Se han creado "+eaz+" registros en la base de datos","informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE);

}
catch(SQLException exz){
javax.swing.JOptionPane.showMessageDialog(null,"Ha ocurrido un error, favor de checar que la clave del proveedor al que se desea agregar el telefono existe\n el id del telefono debe ser completamente numerico  \n si el problema persiste contacte con el administrador \nError: "+exz.getSQLState()+"", "Error",javax.swing.JOptionPane.ERROR_MESSAGE);
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


public Deta_Prove_r(){
setBackground(Color.gray);
setLayout(null);
setSize(400,400);
l1 = new Label("Clave: ");
t1 = new TextField(6);
l2 = new Label("Id del telefono");
t2 = new TextField(20);
//l3 = new Label("Telefono");
//t3 = new TextField(20);
l4 = new Label ("Telefono");
t4 = new TextField(6);
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
t1.setBounds(114, 75, 170, 23);
t2.setBounds(114, 103, 170, 23);
//t3.setBounds(114, 131, 270, 23);
t4.setBounds(134, 159, 109, 23);
b.setBounds(167, 215, 65, 23);
b.addActionListener(this);
setUndecorated(true);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-200, 50);

}

public void paint(Graphics g){
g.setColor(Color.red);
g.setFont(new Font("Arial", Font.BOLD, 25));
g.drawString("Registrar nuevo Telefono", 30, 30);
g.drawString("a un proveedor", 30, 60);
}

public static void main(String [] args){
Deta_Prove_r p = new Deta_Prove_r();

}
}