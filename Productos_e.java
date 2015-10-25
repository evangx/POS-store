import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import javax.swing.*;
import java.sql.*;
import RhmTools.XFrame;
public class Productos_e extends XFrame implements ActionListener{
JComboBox l;
Choice c;
Button b;

public void paint(Graphics g){
g.setColor(Color.red);
g.setFont(new Font("Arial", Font.BOLD, 25));
g.drawString("Eliminar Productos", 60, 30);
}

public Productos_e(){
setSize(400, 400);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-200, 50);
setBackground(Color.gray);
c = new Choice();
c.add("");
c.add("Eliminar todos los Productos");
c.add("Eliminar solo un Producto");
setLayout(null);
c.setBounds(120, 60, 190, 21);
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
else if (c.getSelectedItem()=="Eliminar todos los Productos"){
int r=-1;
r=javax.swing.JOptionPane.showConfirmDialog(null,"�Realmente desea borrar la tabla?\n Una vez hecho esto no podran recuperarse los datos", "Borrado...",javax.swing.JOptionPane.YES_NO_OPTION);
if (r==javax.swing.JOptionPane.YES_OPTION){
if(makeConnection()){
try{
Statement st= cn.createStatement();
javax.swing.JOptionPane.showMessageDialog(null, st.executeUpdate("truncate table productos") + " registros se han eliminado", "Eliminacion completa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
}

catch(SQLException mmm){
javax.swing.JOptionPane.showMessageDialog(null, "Primero Elimine todas las referencias que hagan referencia a estos productos\nEstado:"+mmm.getSQLState()+"\nError:"+mmm.getErrorCode(),"Eliminacion completa", javax.swing.JOptionPane.INFORMATION_MESSAGE);

}
catch(Exception err){
System.out.println(err.getMessage());
}
}
}
}
else if(c.getSelectedItem()=="Eliminar solo un Producto"){
Productos_e_e a= new Productos_e_e(this);
}
}
}

public static void main (String [] args){
Productos_e p = new Productos_e();
}
}