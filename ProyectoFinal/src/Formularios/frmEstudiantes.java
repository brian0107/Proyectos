package Formularios;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;

public class frmEstudiantes extends JFrame implements ActionListener {

    private String matricula;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String direccion;
    private String fechadenacimiento;
    private String fechadeingreso;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private JPanel panelestudiantes = new JPanel();
    private JLabel lblmatricula = new JLabel("Matricula :");
    private JLabel lblnombre = new JLabel("Nombre :");
    private JLabel lblapellidos = new JLabel("Apellidos :");
    private JLabel lbltelefono = new JLabel("Telefono :");
    private JLabel lbldireccion = new JLabel("Direccion :");
    private JLabel lblfechadenacimiento = new JLabel("Fecha de Nacimiento :");
    private JLabel lblfechadeingreso = new JLabel("Fecha de Ingreso :");

    private JTextField txtmatricula = new JTextField();
    private JTextField txtnombre = new JTextField();
    private JTextField txtapellidos = new JTextField();
    private JTextField txttelefono = new JTextField();
    private JTextArea txtdireccion = new JTextArea();
    private JTextField txtfechadenacimiento = new JTextField();
    private JTextField txtfechadeingreso = new JTextField();

    private JDateChooser dcfechadeingreso = new JDateChooser();
    private JDateChooser dcfechadenacimiento = new JDateChooser();

    private JButton btnagregar = new JButton("Agregar");
    private JButton btnmodificar = new JButton("Modificar");
    private JButton btneliminar = new JButton("Eliminar");
    private JButton btnbuscar = new JButton("BUSCAR");
    // Declaracion de Atributos
    static Connection conn = null;
    static Statement stm = null;
    static ResultSet rs = null;
    static String SQL;
    static String login ="root";
    static String pwd = "";
    static String url = "jdbc:mysql://localhost:3308/bdestudiantes";
    String fecha;

    public frmEstudiantes(){
        this.setTitle("Formulario Estudiantes");
        this.setSize(635,570);
        this.setLocationRelativeTo(this);
        initcomponents();

    }
    private void initcomponents(){
        //Atributos del panel
        panelestudiantes.setLayout(null);
        panelestudiantes.setBackground(Color.lightGray);
        // Elementos panel estudiantes
        lblmatricula.setBounds(50,0,100,50);
        lblnombre.setBounds(50, 40, 100, 50);
        lblapellidos.setBounds(50, 80, 100, 50);
        lbltelefono.setBounds(50,120,100,50);
        lbldireccion.setBounds(50,160,100,50);
        lblfechadenacimiento.setBounds(50,310,150,50);
        lblfechadeingreso.setBounds(50,350,150,50);

        txtmatricula.setBounds(130,15,100,22);
        txtnombre.setBounds(130, 55, 400, 22);
        txtapellidos.setBounds(130, 95, 400, 22);
        txttelefono.setBounds(130,135,250,22);
        txtdireccion.setBounds(130,175,240,120);
        txtfechadenacimiento.setBounds(180,325,190,22);
        txtfechadeingreso.setBounds(180,365,190,22);

        dcfechadeingreso.setBounds(380,365,190,22);
        dcfechadenacimiento.setBounds(380,325,190,22);

        //Ubicacion de los botones
        btnagregar.setBounds(50, 470, 80, 25);
        btnmodificar.setBounds(150, 470, 87, 25);
        btneliminar.setBounds(250, 470, 80, 25);
        btnbuscar.setBounds(350, 470, 85, 25);

        //Agregamos los elementos al panel y agregamos el panel al Jframe
        panelestudiantes.add(lblmatricula);
        panelestudiantes.add(lblnombre);
        panelestudiantes.add(lblapellidos);
        panelestudiantes.add(lbltelefono);
        panelestudiantes.add(lbldireccion);
        panelestudiantes.add(lblfechadenacimiento);
        panelestudiantes.add(lblfechadeingreso);
        panelestudiantes.add(txtmatricula);
        panelestudiantes.add(txtnombre);
        panelestudiantes.add(txtapellidos);
        panelestudiantes.add(txttelefono);
        panelestudiantes.add(txtdireccion);
        panelestudiantes.add(txtfechadenacimiento);
        panelestudiantes.add(txtfechadeingreso);
        panelestudiantes.add(btnagregar);
        panelestudiantes.add(btnmodificar);
        panelestudiantes.add(btneliminar);
        panelestudiantes.add(btnbuscar);
        panelestudiantes.add(dcfechadeingreso);
        panelestudiantes.add(dcfechadenacimiento);
        this.add(panelestudiantes);
        // Decimos que los eventos se ejecuten
        btnagregar.addActionListener(this);
        btnmodificar.addActionListener(this);
        btneliminar.addActionListener(this);
        btnbuscar.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnagregar)) {
            AgregarDatos();
        }
        if(e.getSource().equals(btnmodificar)){
            ModificarDatos();
        }
        if(e.getSource().equals(btneliminar)){
            SQL = "DELETE FROM estudiantes WHERE `matricula` = '" + txtmatricula.getText() + "'";
            procesarDatos(SQL,3);
            LimpiarCampos();
        }
        if(e.getSource().equals(btnbuscar)){
            try {
                if (txtmatricula.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Debes ingresar una matricula");
                }else{
                    Buscar(txtmatricula.getText(), Enlace(conn));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }



    // Creacion del metodo enlace
    public static Connection Enlace(Connection conn)throws SQLException{
        try
        {
            //Se crea un ejemplar del driver de JDBC para MySQL
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url,login,pwd);
            System.out.println("CONEXION CORRECTA");
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Error en la conexion"+ ex);
        }
        return conn;
    }
    // Creacion del metodo procesar datos
    private void procesarDatos(String strSQL, int operacion){
        try{
            conn = Enlace(conn);
            stm = conn.createStatement();
            stm.execute(strSQL);
            conn.close();
            switch (operacion){
                case 1: JOptionPane.showMessageDialog(null,"Inserccion exitosa");break;
                case 2: JOptionPane.showMessageDialog(null,"Actualizacion exitosa");break;
                case 3: JOptionPane.showMessageDialog(null,"Eliminacion exitosa");break;
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(this,"Ocurrio un error"+ex);
        }
    }
    private void AgregarDatos(){
        if (txtmatricula.getText().equals("")|| txtnombre.getText().equals("")||txtapellidos.getText().equals("")||txttelefono.getText().equals("")||txtdireccion.getText().equals("")){
            JOptionPane.showMessageDialog(null,"LLena todos los campos");
        }else if(dcfechadenacimiento.getDate()==null || dcfechadeingreso.getDate() == null) {
            JOptionPane.showMessageDialog(null, "LLena todos los campos");
        }else {
            matricula = txtmatricula.getText();
            nombre = txtnombre.getText();
            apellidos = txtapellidos.getText();
            telefono = Integer.parseInt(txttelefono.getText());
            direccion = txtdireccion.getText();
            fechadenacimiento = sdf.format(dcfechadenacimiento.getDate());
            fechadeingreso = sdf.format(dcfechadeingreso.getDate());
            LimpiarCampos();
            SQL = "INSERT INTO estudiantes (`matricula`, `nombre`, `apellidos`, `telefono`, `direccion`, `fecha de nacimiento`, `fecha de ingreso`) VALUES ('" +matricula+ "', '" +nombre+ "', '" +apellidos+ "', '"+telefono+ "', '" +direccion+ "', '"+fechadenacimiento+ "', '"+fechadeingreso+ "' )";
            procesarDatos(SQL, 1);
        }
    }
    private void ModificarDatos(){
        if (txtmatricula.getText().equals("")|| txtnombre.getText().equals("")||txtapellidos.getText().equals("")||txttelefono.getText().equals("")||txtdireccion.getText().equals("")){
            JOptionPane.showMessageDialog(null,"LLena todos los campos");
        }else if(dcfechadenacimiento.getDate()==null || dcfechadeingreso.getDate() == null) {
            JOptionPane.showMessageDialog(null, "LLena todos los campos");
        }else{
            matricula = txtmatricula.getText();
            nombre = txtnombre.getText();
            apellidos = txtapellidos.getText();
            telefono = Integer.parseInt(txttelefono.getText());
            direccion = txtdireccion.getText();
            fechadenacimiento = sdf.format(dcfechadenacimiento.getDate());
            fechadeingreso = sdf.format(dcfechadeingreso.getDate());
            LimpiarCampos();
            SQL = "UPDATE estudiantes SET `matricula` = '" +matricula+ "', `nombre` = '" + nombre + "', `apellidos` = '" +apellidos+ "', `telefono` = '" +telefono+ "', `direccion` = '" +direccion+ "', `fecha de nacimiento`  = '"+fechadenacimiento+ "', `fecha de ingreso` = '" +fechadeingreso+ "' WHERE `matricula` = '" +matricula+"' ";
            procesarDatos(SQL,2);
        }
    }
    private void Buscar(String BuscarMa, Connection connection){
        try{
            SQL = "SELECT * FROM `estudiantes` WHERE `matricula` = '"+BuscarMa+"' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            if (resultSet.next()){
                txtmatricula.setText(resultSet.getString("matricula"));
                txtnombre.setText(resultSet.getString("nombre"));
                txtapellidos.setText(resultSet.getString("apellidos"));
                txttelefono.setText(resultSet.getString("telefono"));
                txtdireccion.setText(resultSet.getString("direccion"));
                txtfechadeingreso.setText(resultSet.getString("fecha de ingreso"));
                txtfechadenacimiento.setText(resultSet.getString("fecha de nacimiento"));
                dcfechadenacimiento.setDate(resultSet.getDate("fecha de nacimiento"));
                dcfechadeingreso.setDate(resultSet.getDate("fecha de ingreso"));
            }else{
                JOptionPane.showMessageDialog(null,"No se encontro ningun estudiante");
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Se produjo un error");
            System.out.println(ex.getMessage());
        }
    }

    private void LimpiarCampos(){
        txtmatricula.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        txttelefono.setText("");
        txtdireccion.setText("");
        txtfechadenacimiento.setText("");
        txtfechadeingreso.setText("");
        dcfechadenacimiento.setDate(null);
        dcfechadeingreso.setDate(null);
    }
}
