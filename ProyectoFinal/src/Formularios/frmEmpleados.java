package Formularios;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

public class frmEmpleados extends JFrame implements ActionListener, MouseListener {
    private JPanel panelempleados = new JPanel();
    private JPanel panelempleados2 = new JPanel();
    private JLabel lblnombre = new JLabel("Nombre :");
    private JLabel lblapellidos = new JLabel("Apellidos :");
    private JTextField txtnombre = new JTextField();
    private JTextField txtapellidos = new JTextField();
    private JLabel lblnacimiento = new JLabel("Nacimiento :");
    private JComboBox cmbAnios = new JComboBox();
    private JLabel lbledad = new JLabel("Edad :");
    private JTextField txtedad = new JTextField();
    private JLabel lblgenero = new JLabel("Genero :");
    private JLabel lblfemenino = new JLabel("Femenino");
    private JLabel lblmasculino = new JLabel("Masculino");
    private JRadioButton rdbfemenino = new JRadioButton();
    private JRadioButton rdbmasculino = new JRadioButton();
    private JLabel lblareasinteres = new JLabel("Areas de interes :");
    private JLabel lbldeporte = new JLabel("Deporte");
    private JLabel lblmanualidades = new JLabel("Manualidades");
    private JLabel lblotro = new JLabel("Otro");
    private JCheckBox chbdeporte = new JCheckBox();
    private JCheckBox chbmanual = new JCheckBox();
    private JCheckBox chbotro = new JCheckBox();
    private JTextField txtotro = new JTextField();
    private ButtonGroup rdbgrupo = new ButtonGroup();
    private ButtonGroup chbgrupo = new ButtonGroup();
    private JButton btnagregar = new JButton("Agregar");
    private JButton btnmodificar = new JButton("Modificar");
    private JButton btneliminar = new JButton("Eliminar");
    private JButton btncerrar = new JButton("Cerrar");
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTable tblempleados = new JTable(modeloTabla);
    JScrollPane scrollshowtable = new JScrollPane(); // Para movernos en la tabla
    private int anioActual, fila;
    DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    Object[] filas = new Object[6];

    public frmEmpleados() {
        this.setTitle("Formulario Empleados");
        this.setSize(635, 570);
        this.setLocationRelativeTo(this);
        //cargamos los metodos
        initComponents();
        cargarAnios();
        detEdad();
        detDatos();

    }

    private void initComponents() {
        // Atributos de la tabla
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos");
        modeloTabla.addColumn("Año");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Sexo");
        modeloTabla.addColumn("Areas");
        // Agregar la tabla al scrollpane, darle vista y agregarla al panel2
        //tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//Automatiza el tamaño
        scrollshowtable.add(tblempleados);
        scrollshowtable.setViewportView(tblempleados);
        scrollshowtable.setBounds(30, 35, 525, 85);
        panelempleados2.add(scrollshowtable);
        // Creamos el contenedor
        Container contenedor = getContentPane();
        contenedor.setLayout(null);

        // Atributos del panelempleados
        panelempleados.setBounds(20, 20, 580, 260);
        panelempleados.setBorder(BorderFactory.createTitledBorder("Datos generales del empleado"));
        panelempleados.setLayout(null);

        // Atributos del panelempleados2
        panelempleados2.setBounds(20, 300, 580, 140);
        panelempleados2.setBorder(BorderFactory.createTitledBorder("Lista de empleados"));
        panelempleados2.setLayout(null);

        // Elementos panel 1
        txtotro.setBounds(400, 215, 70, 25);
        chbotro.setBounds(350, 215, 20, 20);
        chbmanual.setBounds(240, 215, 20, 20);
        chbdeporte.setBounds(160, 215, 20, 20);
        lblotro.setBounds(370, 200, 100, 50);
        lblmanualidades.setBounds(260, 200, 100, 50);
        lbldeporte.setBounds(180, 200, 100, 50);
        lblareasinteres.setBounds(50, 200, 100, 50);
        rdbmasculino.setBounds(380, 160, 20, 20);
        rdbfemenino.setBounds(380, 140, 20, 20);
        lblmasculino.setBounds(400, 145, 100, 50);
        lblfemenino.setBounds(400, 125, 100, 50);
        lblgenero.setBounds(320, 120, 100, 50);
        lbledad.setBounds(240, 120, 100, 50);
        txtedad.setBounds(280, 135, 30, 22);
        lblnacimiento.setBounds(50, 120, 100, 50);
        cmbAnios.setBounds(130, 135, 90, 22);
        lblnombre.setBounds(50, 40, 100, 50);
        lblapellidos.setBounds(50, 80, 100, 50);
        txtnombre.setBounds(130, 55, 180, 22);
        txtapellidos.setBounds(130, 95, 250, 22);
        // Ubicacion de los Botones
        btnagregar.setBounds(90, 470, 80, 25);
        btnmodificar.setBounds(210, 470, 87, 25);
        btneliminar.setBounds(330, 470, 80, 25);
        btncerrar.setBounds(450, 470, 85, 25);
        // Agregamos los elementos al panel 1
        panelempleados.add(lblnombre);
        panelempleados.add(lblapellidos);
        panelempleados.add(txtnombre);
        panelempleados.add(txtapellidos);
        panelempleados.add(lblnacimiento);
        panelempleados.add(cmbAnios);
        panelempleados.add(lbledad);
        panelempleados.add(txtedad);
        panelempleados.add(lblgenero);
        panelempleados.add(lblfemenino);
        panelempleados.add(lblmasculino);
        panelempleados.add(rdbfemenino);
        panelempleados.add(rdbmasculino);
        panelempleados.add(lblareasinteres);
        panelempleados.add(lbldeporte);
        panelempleados.add(lblmanualidades);
        panelempleados.add(lblotro);
        panelempleados.add(chbdeporte);
        panelempleados.add(chbmanual);
        panelempleados.add(chbotro);
        panelempleados.add(txtotro);
        // Agregamos los RadioButton al ButtonGroup
        rdbgrupo.add(rdbfemenino);
        rdbgrupo.add(rdbmasculino);
        chbgrupo.add(chbdeporte);
        chbgrupo.add(chbmanual);
        chbgrupo.add(chbotro);
        // Agregamos los paneles al contenedor
        contenedor.add(panelempleados);
        contenedor.add(panelempleados2);
        // Agregamos los paneles al Jframe
        this.add(panelempleados);
        this.add(panelempleados2);
        this.add(btnagregar);
        this.add(btnmodificar);
        this.add(btneliminar);
        this.add(btncerrar);

        // Decimos que los eventos se ejecuten
        cmbAnios.addActionListener(this);
        btnagregar.addActionListener(this);
        btnmodificar.addActionListener(this);
        btneliminar.addActionListener(this);
        btncerrar.addActionListener(this);
        tblempleados.addMouseListener(this);



        txtotro.setEnabled(false);
        chbdeporte.addActionListener(this);
        chbmanual.addActionListener(this);
        chbotro.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent a) {
        //Hacemos que el txtotro solo este disponible al seleccionar la opcion correspondiente.
        if (a.getSource().equals(chbotro)) {
            txtotro.setEnabled(true);
        } else {
            txtotro.setEnabled(false);
        }


        if (a.getSource().equals(btnagregar)) {
            validacionA();

        }
        if (a.getSource().equals(cmbAnios)) {
            detEdad();
        }
        if (a.getSource().equals(btnmodificar)) {
            validacionM();
        }
        if (a.getSource().equals(btneliminar)) {
            modeloTabla.removeRow(fila);
            tblempleados.setModel(modeloTabla); //actualiza la tabla con el modelo
            Limpiar();
        }
        if (a.getSource().equals(btncerrar)) {
            this.dispose();
        }


    }

    // Creacion de Métodos
    private void cargarAnios() { //Creación del método que carga los elementos años al Combo
        int i;
        Calendar fecha = Calendar.getInstance();
        anioActual = fecha.get(Calendar.YEAR);//Obtiene el año actual
        for (i = 1950; i <= anioActual; i++) {
            modeloCombo.addElement(i);
        }
        cmbAnios.setModel(modeloCombo);//se carga el combobox desde el modelo

    }

    private void detEdad() { // Creación del método que calcula la edad del empleado segun el año
        int edad = anioActual - Integer.parseInt(cmbAnios.getSelectedItem().toString());
        txtedad.setText(String.valueOf(edad));

    }

    private void detDatos() { // metodo que asigna valores al arreglo para mandarlos a la tabla
        String Ainteres = "";
        //carga los datos
        filas[0] = txtnombre.getText();
        filas[1] = txtapellidos.getText();
        filas[2] = cmbAnios.getSelectedItem().toString();
        filas[3] = txtedad.getText();
        if (rdbfemenino.isSelected()) {
            filas[4] = "Femenino";
        } else if(rdbmasculino.isSelected()) {
            filas[4] = "Masculino";
        }
        //else {
           // filas[4] = "";
        //}
        if (chbdeporte.isSelected()) {
            Ainteres = lbldeporte.getText() + ",";
        }
        if (chbmanual.isSelected()) {
            Ainteres = lblmanualidades.getText() + ",";
        }
        if (chbotro.isSelected()) {
            Ainteres = txtotro.getText() + ",";
        }
        filas[5] = Ainteres;

    }

    private void Limpiar() {
        txtnombre.setText(null);
        txtapellidos.setText(null);
        txtedad.setText(null);
        txtotro.setText(null);
        rdbgrupo.clearSelection();
        chbgrupo.clearSelection();

    }
    private void validacionA(){
        if(txtnombre.getText().isEmpty() || txtapellidos.getText().isEmpty() || txtedad.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Es necesario llenar todos los campos");
        }else if(rdbmasculino.isSelected()==false&&rdbfemenino.isSelected()==false){
            JOptionPane.showMessageDialog(null, "Es necesario llenar todos los campos");
        }else if(chbdeporte.isSelected()==false && chbmanual.isSelected()==false && (chbotro.isSelected()==false || txtotro.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Es necesario llenar todos los campos");
        } else {
            detDatos();
            modeloTabla.addRow(filas);
            tblempleados.setModel(modeloTabla);
            Limpiar();
        }
    }
    private void validacionM(){
        if(txtnombre.getText().isEmpty() || txtapellidos.getText().isEmpty() || txtedad.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Es necesario llenar todos los campos");
        }else if(rdbmasculino.isSelected()==false&&rdbfemenino.isSelected()==false){
            JOptionPane.showMessageDialog(null, "Es necesario llenar todos los campos");
        }else if(chbdeporte.isSelected()==false && chbmanual.isSelected()==false && (chbotro.isSelected()==false || txtotro.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Es necesario llenar todos los campos");
        } else {
            detDatos();
            Limpiar();
            for (int i = 0; i < 6; i++) { // sobre escribiendo los datos
                modeloTabla.setValueAt(filas[i], fila, i);//cambia el modelo por lo que tiene el vector filas
            }
            tblempleados.setModel(modeloTabla); //actualiza la tabla con el modelo
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getSource().equals(tblempleados)) {
            fila = tblempleados.rowAtPoint(mouseEvent.getPoint());
            txtotro.setText(null);
            txtnombre.setText(tblempleados.getValueAt(fila, 0).toString());
            txtapellidos.setText(tblempleados.getValueAt(fila, 1).toString());
            modeloCombo.setSelectedItem(tblempleados.getValueAt(fila, 2).toString());
            txtedad.setText(tblempleados.getValueAt(fila, 3).toString());
            if(tblempleados.getValueAt(fila, 4).toString().equals("Femenino")) {
                rdbfemenino.setSelected(true);
            }else {
                rdbmasculino.setSelected(true);
            }

            if(tblempleados.getValueAt(fila, 5).toString().equals("Deporte,")) {
                chbdeporte.setSelected(true);
            }else if (tblempleados.getValueAt(fila, 5).toString().equals("Manualidades,")) {
                chbmanual.setSelected(true);
            }else {
                chbotro.setSelected(true);
            txtotro.setText(tblempleados.getValueAt(fila, 5).toString());txtotro.setEnabled(true);

            }
        }
    }



    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
