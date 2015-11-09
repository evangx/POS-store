import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import javax.swing.*;
import java.sql.*;
import RhmTools.XFrame;
public class Categorias_c extends XFrame implements ActionListener{
JComboBox l;
Choice c;
Button b;

public void paint(Graphics g){
g.setColor(Color.red);
g.setFont(new Font("Arial", Font.BOLD, 25));
g.drawString("Consultar Categorias", 60, 30);
}

public Categorias_c(){
setSize(400, 400);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-200, 50);
setBackground(Color.gray);
c = new Choice();
c.add("");
c.add("Consulta general");
c.add("Consulta individual");
setLayout(null);
c.setBounds(145, 60, 133, 21);
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
else if (c.getSelectedItem()=="Consulta general"){
Categorias_c_c2 a= new Categorias_c_c2(this);
a.setVisible(true);
}
else if(c.getSelectedItem()=="Consulta individual"){
Categorias_c_c a= new Categorias_c_c(this);
a.setVisible(true);
}
}
}

public static void main (String [] args){
Categorias_c p = new Categorias_c();
}
}