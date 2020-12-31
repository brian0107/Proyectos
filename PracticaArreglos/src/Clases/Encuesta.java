package Clases;

import javax.swing.*;

public class Encuesta {
    private int N;
    private Object[][] ArrayPersonas;
    private Object[] ArrayA;


    private int Promedio = 0;
    private String MayorAlPromedio = "";
    private String DentroDelPromedio = "";
    private String Respuesta="";
    private String Respuesta2="";
    private String Respuesta3="";

    public Encuesta(){
        N = Integer.parseInt(JOptionPane.showInputDialog("¿A Cuantas Personas desea Encuestar?"));
        ArrayPersonas = new Object[N][3];
        LlenarArreglo();
        Respuesta = "Personas ingresados: \n"+ LeerArreglo()+"\n \n";
        ordenarArreglo();
        Respuesta2 = "Personas con mayor salario: \n" + LeerArreglo() + "\n";
        Promedio();
        Respuesta3= "El salario promedio es:\n " + Promedio + "\n \n Personas que tienen un salario mayor al promedio: \n " + MayorAlPromedio +"\n \n Personas que tienen un salario dentro del promedio: \n" + DentroDelPromedio +"\n \n";
        JOptionPane.showMessageDialog(null, Respuesta);
        JOptionPane.showMessageDialog(null,Respuesta2);
        JOptionPane.showMessageDialog(null,Respuesta3);


    } //Fin del constructor
    private void LlenarArreglo(){
        for (int i = 0; i < ArrayPersonas.length; i++){
            for (int j = 0; j < ArrayPersonas[i].length; j++){

                if (j == 0){
                    ArrayPersonas[i][j] = JOptionPane.showInputDialog("Ingresar el nombre de la persona:"+"  "+i);
                }
                else if( j == 1){
                    ArrayPersonas[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad de la persona:"+"   "+i));
                }
                else{
                    ArrayPersonas[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el salario de la persona:"+"  "+i));
                }
            }
        }
    }//Fin del metodo LlenarArreglo

    //Retorna los valores dentro del arreglo
    private String LeerArreglo(){
        String cadena = "";
        for(int i = 0; i < ArrayPersonas.length; i++){
            for(int j = 0; j < ArrayPersonas[i].length; j++){
                cadena += ArrayPersonas[i][j] + "   ";
            }
            cadena += "\n";
        }
        return cadena;

    }//Fin del metodo LeerArreglo

    //Ordena los datos de mayor a menor segun el salario
    private void ordenarArreglo(){
        for (int i = 0; i < ArrayPersonas.length-1; i++){
            for (int j = 0; j < ArrayPersonas.length-i-1; j++){
                if ((int) ArrayPersonas[j][2] < (int) ArrayPersonas[j+1][2]){
                    ArrayA = ArrayPersonas[j];
                    ArrayPersonas[j] = ArrayPersonas[j+1];
                    ArrayPersonas[j+1] = ArrayA;
                }
            }
        }
    }//Fin del metodo ordenarArreglo

        //Método para sacar el promedio de los salarios
    private void Promedio(){
        for (int i = 0; i < ArrayPersonas.length; i++){
            Promedio += (int) ArrayPersonas[i][2];
        }
        Promedio /= N;
        //Detecta las Personas con salario mayor al promedio
        for (int i = 0; i < ArrayPersonas.length; i++){
            if ((int) ArrayPersonas[i][2] > Promedio){
                for (int j = 0; j < ArrayPersonas[i].length; j++){
                    MayorAlPromedio += ArrayPersonas[i][j] + "  ";
                }
                MayorAlPromedio += " \n ";
            }
        }
        //Detecta las Personas con salario dentro del promedio
        for (int i = 0; i < ArrayPersonas.length; i++){
            if ((int) ArrayPersonas[i][2] == Promedio){
                for (int j = 0; j < ArrayPersonas[i].length; j++){
                    DentroDelPromedio += ArrayPersonas[i][j] + "  ";
                }
                DentroDelPromedio += " \n ";
            }
        }
    }//Fin del metodo Promedio

}//Fin de la clase Encuesta
