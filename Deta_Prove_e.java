import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import javax.swing.*;
import java.sql.*;
import RhmTools.XFrame;
public class Deta_Prove_e extends XFrame implements ActionListener{
JComboBox l;
Choice c;
Button b;

public void paint(Graphics g){
g.setColor(Color.red);
g.setFont(new Font("Arial", Font.BOLD, 25));
g.drawString("Eliminar Telefono ", 60, 25);
g.drawString("de proveedores ", 60, 45);
}

public Deta_Prove_e(){
setSize(400, 400);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-200, 50);
setBackground(Color.gray);
c = new Choice();
c.add("");
c.add("Eliminar todos los telefonos de los proveedores");
c.add("Eliminar solo un telefono");
setLayout(null);
c.setBounds(100, 60, 220, 21);
add(c);
b= new Button("enviar");
b.setBounds(180,100, 40, 23);
b.addActionListener(this);
add(b);
setUndecorated(true);
}

public void actionPerformed(ActionEvent e){
if(e.getSource()==b){
if(c.getSelectedItem()==""){
javax.swing.JOptionPane.showMessageDialog(null,"Seleccione una opcion","Error!!!",javax.swing.JOptionPane.ERROR_MESSAGE);
}
else if (c.getSelectedItem()=="Eliminar todos los telefonos de los proveedores"){
int r=-1;
r=javax.swing.JOptionPane.showConfirmDialog(null,"�Realmente desea borrar la tabla?\n Una vez hecho esto no podran recuperarse los datos", "Borrado...",javax.swing.JOptionPane.YES_NO_OPTION);
if (r==javax.swing.JOptionPane.YES_OPTION){
if(makeConnection()){
try{
Statement st= cn.createStatement();
javax.swing.JOptionPane.showMessageDialog(null, st.executeUpdate("truncate table detalle_proveedores") + " registros se han eliminado", "Eliminacion completa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
}

catch(SQLException mmm){
javax.swing.JOptionPane.showMessageDialog(null, "Primero Elimine todas las referencias que hagan referencia a estos provedores\nEstado:"+mmm.getSQLState()+"\nError:"+mmm.getErrorCode(),"Eliminacion completa", javax.swing.JOptionPane.INFORMATION_MESSAGE);

}
catch(Exception err){
System.out.println(err.getMessage());
}
}
}
}
else if(c.getSelectedItem()=="Eliminar solo un telefono"){
Deta_Prove_e_e a= new Deta_Prove_e_e(this);
}
}
}

public static void main (String [] args){
Deta_Prove_e p = new Deta_Prove_e();
}
}