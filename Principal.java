import java.awt.*;
import java.awt.event.*;
class Principal extends Frame implements ActionListener{
Label l1, l2;
TextField t1, t2;
Button b;
Panel p;
public Principal(){
setLayout(new BorderLayout());
p=new Panel();
p.setLayout(new GridLayout(2,2));
l1 = new Label("Usuario");
l2 = new Label("Password");
t1 = new TextField();
t2 = new TextField();
b= new Button("Enviar");
p.add(l1);
p.add(t1);
p.add(l2);
p.add(t2);
t2.setEchoChar('*');
b.addActionListener(this);
addWindowListener(new cerrar1());
add("Center",p);
add("South", b);
setSize(300, 150);
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-150, (Toolkit.getDefaultToolkit().getScreenSize().height/2)-75);
setVisible(true);
}
public void actionPerformed(ActionEvent e){
if(e.getSource()==b){
if(t1.getText().equals("Admin") && t2.getText().equals("Admin")){
new Principal_bd(true);
}
}
}

public static void main (String [] args){
new Principal();
}
}