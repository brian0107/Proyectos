package Formularios;

import Funciones.FondoImagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class frmPrincipal extends JFrame implements ActionListener {
    private int Width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private int Height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private JDesktopPane escritorio = new JDesktopPane();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFormulario = new JMenu("Formularios");
    private JMenu menuSalir = new JMenu("Salir");
    private JMenuItem ItemEstudiantes = new JMenuItem("Estudiantes");
    private JMenuItem ItemEmpleados = new JMenuItem("Empleados");
    private JMenuItem ItemSalir = new JMenuItem("Salir del sismtema");
    private JInternalFrame internalframe = new JInternalFrame();
    private JLabel labelUser = new JLabel("Usuario");
    private JLabel labelPass= new JLabel("Contraseña");
    private JLabel labelImagen= new JLabel();
    private  JTextField txtUser = new JTextField();
    private  JPasswordField txtPass= new JPasswordField();
    private JPanel panelinterno = new JPanel();
    private JButton btnAceptar = new JButton("Aceptar");
    private JButton btnCancelar = new JButton("Cancelar");
    frmEstudiantes estu = new frmEstudiantes();
    frmEmpleados emp = new frmEmpleados();



    public frmPrincipal(){
        this.setTitle("Principal");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//MAXIMIZAR LA PANTALLA
        this.setSize(650,650);
        initComponents();
    }
    private void initComponents(){// Metodo para llamar todos los componentes
        // Descripcion pendiente
        escritorio.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        escritorio.setBorder(new FondoImagen("../Imagenes/imagFondo.jpg"));


        //***************************************************************************
        //Agregamos los Menus al menuBar
        menuBar.add(menuFormulario);
        menuBar.add(menuSalir);
        //****************************************************************************
        //Agregamos los items a sus menus
        menuFormulario.add(ItemEstudiantes);
        menuFormulario.add(ItemEmpleados);
        menuSalir.add(ItemSalir);


        //****************************************************************************
        //Agregamos el DesktopPane y el menuBar al JFRAME
        this.add(escritorio);
        this.add(menuBar,BorderLayout.NORTH);
        //****************************************************************************
        // Atributos del internalFrame y su panel
        internalframe.setBounds((this.Width/2)-(400/2),(this.Height/2)-(400/2),400,250);
        internalframe.setClosable(true);
        internalframe.setVisible(true);
        panelinterno.setLayout(null);

        //****************************************************************************
        //Panel interno Elementos
        labelUser.setBounds(170, 0, 100, 50);
        txtUser.setBounds(170, 40, 180, 22);
        labelPass.setBounds(170, 60, 100, 50);
        txtPass.setBounds(170, 100, 180, 22);
        labelImagen.setBounds(10, 21, 150,150);
        btnAceptar.setBounds(170, 140, 80, 30);
        btnCancelar.setBounds(270, 140, 85, 30);
        //****************************************************************************
        //Asignamos la imagen a la etiqueta imagen
        ImageIcon gmail = new ImageIcon(getClass().getResource("../Imagenes/gmail.jpg"));
        gmail = new ImageIcon(gmail.getImage().getScaledInstance(labelImagen.getWidth(),labelImagen.getHeight(), Image.SCALE_DEFAULT));
        labelImagen.setIcon(gmail);
        //Agregamos los elementos al panel
        panelinterno.add(labelImagen);
        panelinterno.add(labelUser);
        panelinterno.add(labelPass);
        panelinterno.add(txtUser);
        panelinterno.add(txtPass);
        panelinterno.add(btnAceptar);
        panelinterno.add(btnCancelar);
        //Agregamos el panelinterno al JinternalFrame y Agregamos el internalFrame al escritorio.
        internalframe.add(panelinterno);
        escritorio.add(internalframe);
        //****************************************************************************
        // Decimos que los eventos se ejecuten y ocultamos el menuBar
        menuFormulario.setEnabled(false);
        menuSalir.setEnabled(false);
        btnAceptar.addActionListener(this);
        btnCancelar.addActionListener(this);
        ItemSalir.addActionListener(this);
        ItemEstudiantes.addActionListener(this);
        ItemEmpleados.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnAceptar)){
            if (txtUser.getText().equals("brian") && txtPass.getText().equals("hola123")){
                JOptionPane.showMessageDialog(this, "BIENVENIDO BRIAN");
                internalframe.dispose();
                menuFormulario.setEnabled(true);
                menuSalir.setEnabled(true);


            }else{
                JOptionPane.showMessageDialog(this, "DATOS INCORRECTOS");
                txtUser.setText("");
                txtPass.setText("");
            }

        }
        if(e.getSource().equals(ItemSalir) || (e.getSource().equals(btnCancelar))){
            System.exit(0);
        }
        if(e.getSource().equals(ItemEstudiantes)){
            estu.setVisible(true);
        }
        if(e.getSource().equals(ItemEmpleados)){
            emp.setVisible(true);
        }
    }
}
