import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
class Principal_bd extends Frame implements ActionListener{
Button b1;
Button b2;
Button b3;
Button b4;
Button b5;
Button b6;
Button b7;
Button b8;
Frame actual = new Frame();
Label l1, l2;
TextField t1, t2;
Button b;
Panel p;
Frame f = new Frame ("Identificacion");
int c=0;
ImageIcon im1=new ImageIcon("imagenes/logo.PNG");

MenuItem sm8;
MenuItem m1_1;
MenuItem m1_2;
MenuItem m1_3;
MenuItem m1_4;
MenuItem m2_1;
MenuItem m2_2;
MenuItem m2_3;
MenuItem m2_4;
MenuItem m3_1;
MenuItem m3_2;
MenuItem m3_3;
MenuItem m3_4;
MenuItem m4_1;
MenuItem m4_2;
MenuItem m4_3;
MenuItem m4_4;
MenuItem m5_1;
MenuItem m5_2;
MenuItem m5_3;
MenuItem m5_4;
MenuItem m6_1;
MenuItem m6_2;
MenuItem m6_3;
MenuItem m6_4;
MenuItem m7_1;
MenuItem m7_2;
MenuItem m7_3;
MenuItem m7_4;
MenuItem m1_1_1;
MenuItem m1_1_2;
MenuItem m1_1_3;
MenuItem m1_1_4;
MenuItem m6_6_1;
MenuItem m6_6_2;
MenuItem m6_6_3;
MenuItem m6_6_4;
MenuItem m2_2_1;
MenuItem m2_2_2;
MenuItem m2_2_3;
MenuItem m2_2_4;
MenuItem m5_5_1;
MenuItem m5_5_2;
MenuItem m5_5_3;
MenuItem m5_5_4;

Categorias_c cc = new Categorias_c();
Categorias_e ce = new Categorias_e();
Categorias_m cm = new Categorias_m();
Categorias_r cr = new Categorias_r();
Clientes_c clc= new Clientes_c();
Clientes_e cle= new Clientes_e();
Clientes_m clm= new Clientes_m();
Clientes_r clr= new Clientes_r();
Compras_r cor = new Compras_r();
Compras_m com = new Compras_m();
Compras_c coc= new Compras_c();
Productos_c pc = new Productos_c();
Productos_e pe = new Productos_e();
Productos_m p_m = new Productos_m();
Productos_r p_r = new Productos_r();
Proveedores_c prc = new Proveedores_c();
Proveedores_e pre = new Proveedores_e();
Proveedores_m prm = new Proveedores_m();
Proveedores_r prr = new Proveedores_r();
Vendedores_c vc = new Vendedores_c();
Vendedores_e ve = new Vendedores_e();
Vendedores_m vm = new Vendedores_m();
Vendedores_r vr = new Vendedores_r();
Ventas_r ver = new Ventas_r();
Ventas_m vem = new Ventas_m();
Ventas_c vec = new Ventas_c();
Deta_Cli_c deta_c_c=new Deta_Cli_c();
Deta_Cli_e deta_c_e=new Deta_Cli_e();
Deta_Cli_m deta_c_m=new Deta_Cli_m();
Deta_Cli_r deta_c_r=new Deta_Cli_r();
Deta_Com_r deta_co_r = new Deta_Com_r();
deta_Compras_c deta_co_c = new deta_Compras_c();
deta_Compras_m deta_co_m = new deta_Compras_m();
Deta_Prove_c deta_pro_c= new Deta_Prove_c();
Deta_Prove_e deta_pro_e= new Deta_Prove_e();
Deta_Prove_m deta_pro_m= new Deta_Prove_m();
Deta_Prove_r deta_pro_r= new Deta_Prove_r();
deta_Ventas_c  deta_ve_c= new deta_Ventas_c();
deta_Ventas_m  deta_ve_m= new deta_Ventas_m();
Deta_Ventas_r  deta_ve_r= new Deta_Ventas_r();
JPanel pr = new JPanel();




public Principal_bd(){
f.setLayout(new BorderLayout());
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
f.addWindowListener(new cerrar1());
f.add("Center",p);
f.add("South", b);
f.setSize(300, 150);
f.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-150, (Toolkit.getDefaultToolkit().getScreenSize().height/2)-75);
f.setVisible(true);
}


public Principal_bd(boolean P){
pr.setOpaque(true);
MenuBar mb_ = new MenuBar();
setMenuBar(mb_);
Menu m = new Menu("Sistema");
sm8 = new MenuItem("Salir");
m.add(sm8);
sm8.addActionListener(this);
mb_.add(m);
Menu mb = new Menu("Administrar");
mb_.add(mb);
Menu m1 = new Menu("Clientes");
Menu Sm1 = new Menu("Telefonos");
m1.add(Sm1);
m1_1_1=new MenuItem("Registrar");
m1_1_2=new MenuItem("Consulrar");
m1_1_3=new MenuItem("Eliminar");
m1_1_4=new MenuItem("Modificar");
mb.add(m1);
m1_1=new MenuItem("Registrar");
m1_2=new MenuItem("Consulrar");
m1_3=new MenuItem("Eliminar");
m1_4=new MenuItem("Modificar");
m1.add(m1_1);
m1.add(m1_2);
m1.add(m1_3);
m1.add(m1_4);
Sm1.add(m1_1_1);
Sm1.add(m1_1_2);
Sm1.add(m1_1_3);
Sm1.add(m1_1_4);
Menu m2 = new Menu("Ventas");
Menu Sm2 = new Menu("Agregar Producto");
m2.add(Sm2);
m2_2_1=new MenuItem("Registrar");
m2_2_2=new MenuItem("Consulrar");
m2_2_3=new MenuItem("Eliminar");
m2_2_4=new MenuItem("Modificar");
mb.add(m2);
m2_1=new MenuItem("Registrar");
m2_2=new MenuItem("Consulrar");
m2_3=new MenuItem("Eliminar");
m2_4=new MenuItem("Modificar");
m2.add(m2_1);
m2.add(m2_2);
m2.add(m2_3);
m2.add(m2_4);
Sm2.add(m2_2_1);
Sm2.add(m2_2_2);
Sm2.add(m2_2_3);
Sm2.add(m2_2_4);
Menu m3 = new Menu("Productos");
mb.add(m3);
m3_1=new MenuItem("Registrar");
m3_2=new MenuItem("Consulrar");
m3_3=new MenuItem("Eliminar");
m3_4=new MenuItem("Modificar");
m3.add(m3_1);
m3.add(m3_2);
m3.add(m3_3);
m3.add(m3_4);
Menu m4 = new Menu("Vendedores");
mb.add(m4);
m4_1=new MenuItem("Registrar");
m4_2=new MenuItem("Consulrar");
m4_3=new MenuItem("Eliminar");
m4_4=new MenuItem("Modificar");
m4.add(m4_1);
m4.add(m4_2);
m4.add(m4_3);
m4.add(m4_4);
Menu m5 = new Menu("Compras");
Menu Sm5 = new Menu("Agregar Producto");
mb.add(m5);
m5.add(Sm5);
m5_1=new MenuItem("Registrar");
m5_2=new MenuItem("Consulrar");
m5_3=new MenuItem("Eliminar");
m5_4=new MenuItem("Modificar");
m5_5_1=new MenuItem("Registrar");
m5_5_2=new MenuItem("Consulrar");
m5_5_3=new MenuItem("Eliminar");
m5_5_4=new MenuItem("Modificar");
m5.add(m5_1);
m5.add(m5_2);
m5.add(m5_3);
m5.add(m5_4);
Sm5.add(m5_5_1);
Sm5.add(m5_5_2);
Sm5.add(m5_5_3);
Sm5.add(m5_5_4);
Menu m6 = new Menu("Provedores");
Menu Sm6 = new Menu("Telefono");
m6.add(Sm6);
m6_6_1=new MenuItem("Registrar");
m6_6_2=new MenuItem("Consulrar");
m6_6_3=new MenuItem("Eliminar");
m6_6_4=new MenuItem("Modificar");
mb.add(m6);
m6_1=new MenuItem("Registrar");
m6_2=new MenuItem("Consulrar");
m6_3=new MenuItem("Eliminar");
m6_4=new MenuItem("Modificar");
m6.add(m6_1);
m6.add(m6_2);
m6.add(m6_3);
m6.add(m6_4);
Sm6.add(m6_6_1);
Sm6.add(m6_6_2);
Sm6.add(m6_6_3);
Sm6.add(m6_6_4);
Menu m7 = new Menu("Categorias");
mb.add(m7);
m7_1=new MenuItem("Registrar");
m7_2=new MenuItem("Consulrar");
m7_3=new MenuItem("Eliminar");
m7_4=new MenuItem("Modificar");
m7.add(m7_1);
m7.add(m7_2);
m7.add(m7_3);
m7.add(m7_4);

cc.setVisible(false);
ce.setVisible(false);
cm.setVisible(false);
cr.setVisible(false);
clc.setVisible(false);
cle.setVisible(false);
clm.setVisible(false);
clr.setVisible(false);
cor.setVisible(false);
com.setVisible(false);
coc.setVisible(false);
pc.setVisible(false);
pe.setVisible(false);
p_m.setVisible(false);
p_r.setVisible(false);
prc.setVisible(false);
pre.setVisible(false);
prm.setVisible(false);
prr.setVisible(false);
vc.setVisible(false);
ve.setVisible(false);
vm.setVisible(false);
vr.setVisible(false);
ver.setVisible(false);
vem.setVisible(false);
vec.setVisible(false);
deta_c_c.setVisible(false);
deta_c_e.setVisible(false);
deta_c_m.setVisible(false);
deta_c_r.setVisible(false);
deta_co_r.setVisible(false);
deta_co_c.setVisible(false);
deta_co_m.setVisible(false);
deta_pro_c.setVisible(false);
deta_pro_e.setVisible(false);
deta_pro_m.setVisible(false);
deta_pro_r.setVisible(false);
deta_ve_c.setVisible(false);
deta_ve_m.setVisible(false);
deta_ve_r.setVisible(false);


setUndecorated(true);
setSize(Toolkit.getDefaultToolkit().getScreenSize());
setBackground(Color.black);

m1_1.addActionListener(this);
m1_2.addActionListener(this);
m1_3.addActionListener(this);
m1_4.addActionListener(this);
m2_1.addActionListener(this);
m2_2.addActionListener(this);
m2_3.addActionListener(this);
m2_4.addActionListener(this);
m3_1.addActionListener(this);
m3_2.addActionListener(this);
m3_3.addActionListener(this);
m3_4.addActionListener(this);
m4_1.addActionListener(this);
m4_2.addActionListener(this);
m4_3.addActionListener(this);
m4_4.addActionListener(this);
m5_1.addActionListener(this);
m5_2.addActionListener(this);
m5_3.addActionListener(this);
m5_4.addActionListener(this);
m6_1.addActionListener(this);
m6_2.addActionListener(this);
m6_3.addActionListener(this);
m6_4.addActionListener(this);
m7_1.addActionListener(this);
m7_2.addActionListener(this);
m7_3.addActionListener(this);
m7_4.addActionListener(this);
m1_1_1.addActionListener(this);
m1_1_2.addActionListener(this);
m1_1_3.addActionListener(this);
m1_1_4.addActionListener(this);
m2_2_1.addActionListener(this);
m2_2_2.addActionListener(this);
m2_2_3.addActionListener(this);
m2_2_4.addActionListener(this);
m5_5_1.addActionListener(this);
m5_5_2.addActionListener(this);
m5_5_3.addActionListener(this);
m5_5_4.addActionListener(this);
m6_6_1.addActionListener(this);
m6_6_2.addActionListener(this);
m6_6_3.addActionListener(this);
m6_6_4.addActionListener(this);

setVisible(true);
}

public void paint(Graphics g){
//im1.paintIcon(this,g,300,300);
g.drawImage(im1.getImage(),((this.getWidth()/2)-(im1.getIconWidth()/2)),((this.getHeight()/2)-(im1.getIconHeight()/2))+100,this);
}

public void actionPerformed (ActionEvent e){
if(e.getSource()==b){
if(t1.getText().equals("Admin") && t2.getText().equals("Admin")){
l1=null;
l2=null;
t1=null;
t2=null;
b=null;
p=null;
f.setVisible(false);
f=null;
new Principal_bd(true);
}
else{
c++;
javax.swing.JOptionPane.showMessageDialog(null,"Contraseņa o Nombre de usuarios incorrectos \n "+ c + " de 3 intentos","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
if(c==3){
System.exit(0);
}
}
}
if (e.getSource()==sm8){
System.exit(0);;
}
if(e.getSource()==m1_1){
validate();
}
if(e.getSource()==m1_1){
actual.setVisible(false);
actual=clr;
clr.setVisible(true);
clr.start();
validate();
}
if(e.getSource()==m1_2){
actual.setVisible(false);
actual=clc;
clc.setVisible(true);
validate();
}
if(e.getSource()==m1_3){
actual.setVisible(false);
actual=cle;
cle.setVisible(true);

validate();
}
if(e.getSource()==m1_4){
actual.setVisible(false);
actual=clm;
clm.setVisible(true);
clm.start();
validate();
}
if(e.getSource()==m2_1){
actual.setVisible(false);
actual=deta_ve_r;
deta_ve_r.setVisible(true);
deta_ve_r.start();
validate();
}
if(e.getSource()==m2_2){
actual.setVisible(false);
actual=deta_ve_c;
deta_ve_c.setVisible(true);

validate();
}
if(e.getSource()==m2_4){
actual.setVisible(false);
actual=deta_ve_m;
deta_ve_m.setVisible(true);
deta_ve_m.start();
validate();
}
if(e.getSource()==m3_1){
actual.setVisible(false);
actual=p_r;
p_r.setVisible(true);
p_r.start();
validate();
}
if(e.getSource()==m3_2){
actual.setVisible(false);
actual=pc;
pc.setVisible(true);

validate();
}
if(e.getSource()==m3_3){
actual.setVisible(false);
actual=pe;
pe.setVisible(true);

validate();
}
if(e.getSource()==m3_4){
actual.setVisible(false);
actual=p_m;
p_m.setVisible(true);

validate();
}
if(e.getSource()==m4_1){
actual.setVisible(false);
actual=vr;
vr.setVisible(true);
vr.start();
validate();
}
if(e.getSource()==m4_2){
actual.setVisible(false);
actual=vc;
vc.setVisible(true);

validate();
}
if(e.getSource()==m4_3){
actual.setVisible(false);
actual=ve;
ve.setVisible(true);

validate();
}
if(e.getSource()==m4_4){
actual.setVisible(false);
actual=vm;
vm.setVisible(true);
vm.start();
validate();
}
if(e.getSource()==m5_1){
actual.setVisible(false);
actual=deta_co_r;
deta_co_r.setVisible(true);
deta_co_r.start();
validate();
}
if(e.getSource()==m5_2){
actual.setVisible(false);
actual=deta_co_c;
deta_co_c.setVisible(true);

validate();
}

if(e.getSource()==m5_4){
actual.setVisible(false);
actual=deta_co_m;
deta_co_m.setVisible(true);
deta_co_m.start();
validate();
}
if(e.getSource()==m6_1){
actual.setVisible(false);
actual=prr;
prr.setVisible(true);
prr.start();
validate();
}
if(e.getSource()==m6_2){
actual.setVisible(false);
actual=prc;
prc.setVisible(true);

validate();
}
if(e.getSource()==m6_3){
actual.setVisible(false);
actual=pre;
pre.setVisible(true);

validate();
}
if(e.getSource()==m6_4){
actual.setVisible(false);
actual=prm;
prm.setVisible(true);
prm.start();
validate();
}
if(e.getSource()==m7_1){
actual.setVisible(false);
actual=cr;
cr.setVisible(true);
cr.start();
validate();
}
if(e.getSource()==m7_2){
actual.setVisible(false);
actual=cm;
cc.setVisible(true);
validate();
}
if(e.getSource()==m7_3){
actual.setVisible(false);
actual=ce;
ce.setVisible(true);

validate();
}
if(e.getSource()==m7_4){
actual.setVisible(false);
actual=cm;
cm.setVisible(true);
cm.start();
validate();
}
if(e.getSource()==m1_1_1){
actual.setVisible(false);
actual=deta_c_r;
deta_c_r.setVisible(true);

validate();
}
if(e.getSource()==m1_1_2){
actual.setVisible(false);
actual=deta_c_c;
deta_c_c.setVisible(true);

validate();
}
if(e.getSource()==m1_1_3){
actual.setVisible(false);
actual=deta_c_e;
deta_c_e.setVisible(true);

validate();
}
if(e.getSource()==m1_1_4){
actual.setVisible(false);
actual=deta_c_m;
deta_c_m.setVisible(true);
deta_c_m.start();
validate();
}
if(e.getSource()==m6_6_1){
actual.setVisible(false);
actual=deta_pro_r;
deta_pro_r.setVisible(true);

validate();
}
if(e.getSource()==m6_6_2){
actual.setVisible(false);
actual=deta_pro_c;
deta_pro_c.setVisible(true);

validate();
}
if(e.getSource()==m6_6_3){
actual.setVisible(false);
actual=deta_pro_e;
deta_pro_e.setVisible(true);

validate();
}
if(e.getSource()==m6_6_4){
actual.setVisible(false);
actual=deta_pro_m;
deta_pro_m.setVisible(true);
deta_pro_m.start();
validate();
}
if(e.getSource()==m2_2_1){
actual.setVisible(false);
actual=ver;
ver.setVisible(true);
ver.start();
validate();
}
if(e.getSource()==m2_2_2){
actual.setVisible(false);
actual=vec;
vec.setVisible(true);

validate();
}
if(e.getSource()==m2_2_4){
actual.setVisible(false);
actual=vem;
vem.setVisible(true);
vem.start();
validate();
}
if(e.getSource()==m5_5_1){
actual.setVisible(false);
actual=cor;
cor.setVisible(true);
cor.start();
validate();
}
if(e.getSource()==m5_5_2){
actual.setVisible(false);
actual=coc;
coc.setVisible(true);

validate();
}
if(e.getSource()==m5_5_4){
actual.setVisible(false);
actual=com;
com.setVisible(true);
com.start();
validate();
}
repaint();
}



public static void main (String [] args){
Principal_bd p = new Principal_bd();
}
}
