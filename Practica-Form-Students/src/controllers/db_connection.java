package controllers;

import javax.swing.JOptionPane;
import java.sql.*;

public class db_connection {
    private Connection connection;
    private Statement statement;

    private String user = "root";
    private String password = "";
    private String host = "jdbc:mysql://localhost:3308/dbstudents";

    public Connection link() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(host,user,password);
            System.out.println("conexion exitosa");
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error de comunicacion con el servidor");
        }

        return connection;
    }

    public void toProcessData(String strSql, Connection connection, int Operation){
        try {
            switch (Operation){
                case 1:
                    excuteSentence(strSql, connection);
                    JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamente");
                    break;
                case 2:
                    excuteSentence(strSql, connection);
                    JOptionPane.showMessageDialog(null, "Datos Actualizados Exitosamente");
                    break;
                case 3:
                    excuteSentence(strSql, connection);
                    JOptionPane.showMessageDialog(null, "Datos Eliminados Exitosamente");
                    break;
                default:
                    break;
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al procesar los datos");
        }
    }

    public void excuteSentence(String strSql, Connection connection) throws SQLException {
        statement = connection.createStatement();
        statement.execute(strSql);
        connection.close();
    }
}
