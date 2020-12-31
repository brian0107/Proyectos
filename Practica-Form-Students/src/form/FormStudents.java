package form;

import com.toedter.calendar.JDateChooser;
import controllers.db_connection;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;

import static java.lang.Integer.parseInt;

public class FormStudents extends JFrame implements ActionListener {

    private String SQL;
    private String Enrollment;
    private String Name;
    private String LastName;
    private int Telephone;
    private String Address;
    private String BirthDate;
    private String DateAdmission;

    private db_connection dbConnection = new db_connection();

    private JLabel LName = new JLabel("Nombre:");
    private JLabel LLastName = new JLabel("Apellidos:");
    private JLabel LTelephone = new JLabel("Telefono:");
    private JLabel LAddress = new JLabel("Direccion:");
    private JLabel LDateAdmission = new JLabel("Fecha de ingreso:");
    private JLabel LBirthDate = new JLabel("Fecha de Nacimiento:");
    private JLabel LEnrollment = new JLabel("Matricula:");

    private JTextField boxEnrollment = new JTextField();
    private JTextField boxName = new JTextField();
    private JTextField boxLastName = new JTextField();
    private JTextField boxTelephone = new JTextField();
    private JTextField boxDateAdmission = new JTextField();
    private JTextField boxBirthDate = new JTextField();
    private JTextField boxSearch = new JTextField();

    private JTextArea textAreaAddress = new JTextArea();

    private JDateChooser dcDateAdmission = new JDateChooser();
    private JDateChooser dcBirthDate = new JDateChooser();

    private JButton btnAdd = new JButton("Agregar");
    private JButton btnUpdate = new JButton("Actualizar");
    private JButton btnDelete = new JButton("Eliminar");
    private JButton btnSearch = new JButton("Buscar");

    private Border borderBottom = new TitledBorder(new EtchedBorder(),"Comandos | Busqueda por Matricula");

    private GridLayout topPanelGrid = new GridLayout(4,2,-100,20);
    private GridLayout centerPanelGrid = new GridLayout(2,3,10,30);
    private GridLayout bottomPanelGrid = new GridLayout(1,5,10,10);

    private JPanel topPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    public FormStudents(){
        super("Formulario de estudiantes");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(700,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255,255,255));

        initComponents();

        this.add(topPanel);
        this.add(centerPanel);
        this.add(bottomPanel);
    }

    private void initComponents(){
        initTopPanel();

        LAddress.setBounds(50,240,100,20);
        textAreaAddress.setBounds(150,240,350,80);
        textAreaAddress.setBackground(new Color(230,230,230));
        textAreaAddress.setCaretColor(new Color(200, 0, 28));

        this.add(LAddress);
        this.add(textAreaAddress);

        initCenterPanel();
        initBottomPanel();
    }

    private void initTopPanel(){
        topPanel.setBounds(50, 25,300,190);
        topPanel.setBackground(new Color(255,255,255));
        topPanel.setLayout(topPanelGrid);

        topPanel.add(LEnrollment);
        topPanel.add(boxEnrollment);
        topPanel.add(LName);
        topPanel.add(boxName);
        topPanel.add(LLastName);
        topPanel.add(boxLastName);
        topPanel.add(LTelephone);
        topPanel.add(boxTelephone);
    }

    private void initCenterPanel(){
        centerPanel.setBounds(50, 360,600,90);
        centerPanel.setBackground(new Color(255,255,255));
        centerPanel.setLayout(centerPanelGrid);

        centerPanel.add(LBirthDate);
        centerPanel.add(boxBirthDate);
        centerPanel.add(dcBirthDate);

        centerPanel.add(LDateAdmission);
        centerPanel.add(boxDateAdmission);
        centerPanel.add(dcDateAdmission);
    }

    private void initBottomPanel(){
        bottomPanel.setBounds(50,475,600,55);
        bottomPanel.setBackground(new Color(255,255,255));
        bottomPanel.setLayout(bottomPanelGrid);
        bottomPanel.setBorder(borderBottom);

        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSearch.addActionListener(this);

        bottomPanel.add(btnAdd);
        bottomPanel.add(btnUpdate);
        bottomPanel.add(btnDelete);
        bottomPanel.add(btnSearch);
        bottomPanel.add(boxSearch);
    }

    private Boolean getData(){
        if (boxEnrollment.getText()=="" || boxName.getText() == "" || boxLastName.getText() == "" || boxTelephone.getText() == "" || textAreaAddress.getText() == ""){
            JOptionPane.showMessageDialog(null,"Porfavor Ingresa datos validos");
            return false;
        }else {
            this.Enrollment = boxEnrollment.getText();
            this.Name = boxName.getText();
            this.LastName = boxLastName.getText();
            this.Telephone = parseInt(boxTelephone.getText());
            this.Address = textAreaAddress.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(dcBirthDate.getDate()==null || dcDateAdmission.getDate() == null) {
                JOptionPane.showMessageDialog(null,"Ingresa una fecha valida");
                return false;
            }else{
                this.BirthDate = sdf.format(dcBirthDate.getDate());
                this.DateAdmission = sdf.format(dcDateAdmission.getDate());
            }
        }
        return true;
    }

    private void cleanData(){
        boxEnrollment.setText("");
        boxName.setText("");
        boxLastName.setText("");
        boxTelephone.setText("");
        textAreaAddress.setText("");
        boxBirthDate.setText("");
        boxDateAdmission.setText("");
        dcBirthDate.setDate(null);
        dcDateAdmission.setDate(null);
    }

    private void toSearchData(String searchEnrollment, Connection connection){
        try{
            SQL = "SELECT * FROM `students` WHERE `Enrollment` = '"+searchEnrollment+"' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            if (resultSet.next()){
                boxEnrollment.setText(resultSet.getString("Enrollment"));
                boxName.setText(resultSet.getString("Name"));
                boxLastName.setText(resultSet.getString("LastName"));
                boxTelephone.setText(resultSet.getString("Telephone"));
                textAreaAddress.setText(resultSet.getString("Address"));
                boxDateAdmission.setText(resultSet.getString("DateAdmission"));
                boxBirthDate.setText(resultSet.getString("birthdate"));
            }else{
                JOptionPane.showMessageDialog(null,"No se encontraron resultados");
            }

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Se produjo un error");
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnAdd)){
         try {
             if (getData()){
                 cleanData();
                 SQL = "INSERT INTO students (`Enrollment`, `Name`, `LastName`, `Telephone`, `Address`, `birthdate`, `DateAdmission`) VALUES ('"+Enrollment+"', '"+Name+"', '"+LastName+"', '"+Telephone+"', '"+Address+"', '"+BirthDate+"', '"+DateAdmission+"' )";
                 dbConnection.toProcessData(SQL, dbConnection.link(), 1);
             }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource().equals(btnUpdate)){
            try {

                if (getData()){
                    SQL = "UPDATE students SET `Enrollment` = '" + Enrollment + "', `Name` = '" + Name + "', `LastName` = '" + LastName + "', `Telephone` = '" + Telephone + "', `Address` = '" + Address + "', `birthdate`  = '" + BirthDate + "', `DateAdmission` = '" + DateAdmission + "' WHERE `Enrollment` = '" + Enrollment +"' ";
                    dbConnection.toProcessData(SQL, dbConnection.link(), 2);
                    cleanData();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        if(e.getSource().equals(btnDelete)){

            try {
                if (boxEnrollment.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Primero Busque un dato");
                }else {
                    SQL = "DELETE FROM students WHERE `Enrollment` = '" + boxEnrollment.getText() + "'";
                    dbConnection.toProcessData(SQL, dbConnection.link(), 3);
                    cleanData();
                    boxSearch.setText("");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource().equals(btnSearch)){
            try {
                if (boxSearch.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Porfavor Proporciona una matricula valida");
                }else{
                    toSearchData(boxSearch.getText(), dbConnection.link());
                    boxSearch.setText("");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}