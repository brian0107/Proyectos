package Clases;
import javax.swing.*;
import java.text.DecimalFormat;

public class Temperatura {
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");
    private Object[][] Temperaturas = new Object[12][31];
    private double AlmacenPromediosMensuales[] = new double[12];
    private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    private double SumaMensual = 0;
    private double SumaPromediosMensuales = 0;

    private String MostrarTemperaturas = "";
    private String MostrarPromediosMensuales = "";
    private String Respuesta = "";
    private String Respuesta2= "";
    private String Respuesta3= "";

    public Temperatura(){
        LlenarArreglo();
        Promedios();

        Respuesta = "Las temperaturas de cada mes son:\n"+LeerAreglo();
        Respuesta2 = "Los Promedios mensuales son: \n" + MostrarPromediosMensuales;
        Respuesta3 = "El promedio de Temperatura anual es de:\n " + decimalFormat.format(SumaPromediosMensuales /12);
        JOptionPane.showMessageDialog(null, Respuesta);
        JOptionPane.showMessageDialog(null,Respuesta2);
        JOptionPane.showMessageDialog(null,Respuesta3);
    }
    //Rellena el arreglo de temperaturas
    private void LlenarArreglo(){
        for(int i = 0; i < Temperaturas.length; i++){
            Temperaturas[i][0] = meses[i];
            for(int j = 1; j < Temperaturas[i].length; j++){
                Temperaturas[i][j]=Math.floor(Math.random()*(20-50)+50);
            }
        }
    }//Fin de el metodo LlenarArreglo

    //Metodo para leer el arreglo de temperaturas
    private String LeerAreglo(){
        for(int i = 0; i < Temperaturas.length; i++){
            MostrarTemperaturas +="\n";
            for(int j = 0; j < Temperaturas[i].length; j++){
                MostrarTemperaturas +=Temperaturas[i][j]+" | ";
            }
        }
        return MostrarTemperaturas;
    }// Fin del metodo LeerAreglo

    //metodo para encontrar el promedio mensual y anual
    private void Promedios(){
        for(int i = 0; i < Temperaturas.length; i++){
            SumaMensual = 0;
            for (int j = 1; j < Temperaturas[i].length; j++){
                SumaMensual += (Double) Temperaturas[i][j];
            }
            AlmacenPromediosMensuales[i] = Double.parseDouble(decimalFormat.format(SumaMensual / 30));
            SumaPromediosMensuales += AlmacenPromediosMensuales[i];
            MostrarPromediosMensuales += "  "+meses[i] + " : "+ AlmacenPromediosMensuales[i]+ "\n";

        }
    }//Fin del metodo Promedios
}//Fin de la clase Temperatura