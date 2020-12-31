package Clases;
import javax.swing.*;
import java.text.DecimalFormat;


public class Altura {
    private int N;
    private float[] Alturas;
    private float promedio;
    private String superiorM = "";
    private String inferiorM = "";
    private String DentroM = "";
    private DecimalFormat df = new DecimalFormat("#.00");

    public Altura(){
        N = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de alturas que desea ingresar"));
        if (N>0){
            Alturas = new float[N];
            ingresaA();
            calcularM();
        }else {
            JOptionPane.showMessageDialog(null,"El valor debe ser un entero positivo");

        }
    }
    private void ingresaA(){
        for (int i = 0; i<N;i++){
            Alturas[i]= Float.parseFloat(JOptionPane.showInputDialog("Ingrese la altura numero: "+ i));
            promedio += Alturas[i];
        }
    }
    private void calcularM(){
        for (int i = 0; i<Alturas.length; i++){
            if (Alturas[i] > (promedio/ Alturas.length)){
                superiorM += "("+Alturas[i]+"), ";
            }else if (Alturas[i] == (promedio/ Alturas.length)){
                DentroM += "("+Alturas[i]+"), ";
            }else {
                inferiorM += "("+Alturas[i]+"), ";
            }
        }
        JOptionPane.showMessageDialog(null, "Los datos introducidos son :"+ superiorM +inferiorM + DentroM +"\n \n" +
                "La media de las alturas es: "+df.format(promedio/Alturas.length) + " \n \n "+
                "Las alturas mayores a la media son :" + superiorM + "\n" +
                "Las alturas menores a la media son :" + inferiorM + "\n" +
                "Las alturas dentro de la media son :" + DentroM +"\n \n");
    }
}
