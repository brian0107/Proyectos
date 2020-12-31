package Clases;
import javax.swing.*;
import java.text.DecimalFormat;

public class Numeros {

    private float [] numeros = new float[10];
    private float media = 0;
    private int NumerosNegativos= 0;
    private int NumerosPositivos = 0;
    private int NumerosCero = 0;
    private String MostrarNumPositivos = "";
    private String MostrarNumNegativos = "";
    private String MostrarCeros = "";
    private DecimalFormat df = new DecimalFormat("#.00");

    public Numeros() {
        IngresaNum();
        AlmacenarNumeros();
    }

    private void IngresaNum() {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Float.parseFloat(JOptionPane.showInputDialog("Ingresa el numero Positivo, negativo o igual a cero numero: "+i));
            media += numeros[i];
            NumerosPositivos += (numeros[i] > 0) ? 1 : 0;
            NumerosNegativos += (numeros[i] < 0) ? 1 : 0;
            NumerosCero += (numeros[i] == 0) ? 1 : 0;
        }
    }

    private void AlmacenarNumeros() {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > 0) {
                MostrarNumPositivos += "[" + numeros[i] + "], ";
            } else if (numeros[i] < 0) {
                MostrarNumNegativos += "[" + numeros[i] + "], ";
            } else if (numeros[i] == 0) {
                MostrarCeros += "[" + numeros[i] + "], ";
            }
        }
        String data = "El media es: " + df.format(media / numeros.length) + " \n \n " +
                "Se introducieron" +" " +NumerosPositivos+ " "+"Numeros Positivos,"+" "+"son los siguientes"+" : " + MostrarNumPositivos + "\n" +
                "Se introducieron" +" " +NumerosNegativos+ " "+"Numeros Negativos,"+" "+"son los siguientes"+" : " + MostrarNumNegativos + "\n" +
                "Se introducieron" +" " +NumerosCero+ " "+"ceros" +" : "+ MostrarCeros;
        JOptionPane.showMessageDialog(null, data);
    }
}
