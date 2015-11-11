import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import javax.swing.*;
import java.sql.*;
import RhmTools.XFrame;
public class Categorias_e extends XFrame implements ActionListener{
JComboBox l;
Choice c;
Button b;

public void paint(Graphics g){
g.setColor(Color.red);
g.setFont(new Font("Arial", Font.BOLD, 25));
g.drawString("Eliminar Categorias", 60, 30);
}

public Categorias_e(){
setSize(400, 400);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-200, 50);
setBackground(Color.gray);
c = new Choice();
c.add("");
c.add("Eliminar todas las categorias");
c.add("Eliminar solo una categoria");
setLayout(null);
c.setBounds(115, 60, 193, 21);
add(c);
b= new Button("enviar");
b.setBounds(175,100, 50, 23);
b.addActionListener(this);
add(b);
setUndecorated(true);
}

public void actionPerformed(ActionEvent e){
if(e.getSource()==b){
if(c.getSelectedItem()==""){
javax.swing.JOptionPane.showMessageDialog(null,"Seleccione una opcion","Error!!!",javax.swing.JOptionPane.ERROR_MESSAGE);
}
else if (c.getSelectedItem()=="Eliminar todas las categorias"){

int r=javax.swing.JOptionPane.showConfirmDialog(null,"¿Realmente desea borrar la tabla?\n Una vez hecho esto no podran recuperarse los datos", "Borrado...",javax.swing.JOptionPane.YES_NO_OPTION);
if (r==javax.swing.JOptionPane.YES_OPTION){
if(makeConnection()){
try{
Statement st= cn.createStatement();
javax.swing.JOptionPane.showMessageDialog(null, st.executeUpdate("truncate table categorias") + " registros se han eliminado", "Eliminacion completa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
}
catch(SQLException mmm){
javax.swing.JOptionPane.showMessageDialog(null, "Primero Elimine todas las referencias que hagan referencia a estas categorias\nEstado:"+mmm.getSQLState()+"\nError:"+mmm.getErrorCode(),"Eliminacion completa", javax.swing.JOptionPane.INFORMATION_MESSAGE);

}
catch(Exception err){
System.out.println(err.getMessage());
}
}
}
}
else if(c.getSelectedItem()=="Eliminar solo una categoria"){
Categorias_e_e a= new Categorias_e_e(this);
}
}
}

public static void main (String [] args){
Categorias_e p = new Categorias_e();
}
}