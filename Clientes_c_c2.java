import RhmTools.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.*;
import java.util.*;
public class Clientes_c_c2 extends XFrame implements ActionListener{
public Frame anterior;
Statement st;
ResultSet rs;
Button reg;
public void actionPerformed(ActionEvent e){
if(e.getSource()==reg){
setVisible(false);
anterior.setVisible(true);
}
}

public Clientes_c_c2(Frame f){
setVisible(false);
setSize(500, 500);
setUndecorated(true);
setVisible(true);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-250, 50);
setLayout(new FlowLayout());
anterior=f;
anterior.setVisible(false);
if(makeConnection()){
try{
st=cn.createStatement();
rs=st.executeQuery("select * from clientes");
Vector re= new Vector();
while(rs.next()){
Vector aux = new Vector ();
aux.addElement(rs.getString(1));
aux.addElement(rs.getString(2));
aux.addElement(rs.getString(3));
aux.addElement(rs.getString(4));
re.add(aux);
}
Vector no= new Vector();
no.add("Clave");
no.add("Nombre");
no.add("Adeudo");
no.add("Direccion");

javax.swing.JTable r= new javax.swing.JTable(re, no);
r.setShowHorizontalLines( true );
r.setRowSelectionAllowed( true );
r.setColumnSelectionAllowed( true);
javax.swing.JScrollPane xl = new javax.swing.JScrollPane( r );
reg=new Button("Cerrar");
reg.addActionListener(this);
add(reg);


add(xl);
}
catch(SQLException e){
System.out.println(e.getSQLState()+" "+ e.getMessage());
}
catch(Exception ef){
System.out.println(ef.getMessage());
}
}
else{
javax.swing.JOptionPane.showMessageDialog(null,"Error al crear la conexion a la base de datos, reinicie el componente, o contacte con el administrador", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
}
}
}