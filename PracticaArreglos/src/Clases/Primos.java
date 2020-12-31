package Clases;
import javax.swing.*;

public class Primos {
    private int Num;

    private int contadorPrimos = 0;
    private int cont = 0;
    private int contA = 0;

    private int[] ArraySumaPrimos = new int[4];
    private int[] ArrayNum;
    private int[] ArrayNumerosPrimos;

    private int suma = 0;       // Variable usada para guardar la suma de los primos
    private int random = 0;      //Valores aleatorios creados para encontrar la suma

    private String Mostrar4Primos = ""; //Imprime los 4 numeros primos encontrados
    private String MRespuesta = "";  //Imprime el mensaje de respuesta


    public Primos(){
        Num = Integer.parseInt(JOptionPane.showInputDialog("Favor de ingresar un numero positivo mayor a 11")); //Mayor a 11 para que se puedan sumar 4 numeros primos con ese valor
        ArrayNum = new int[Num];
        if (DeterminarPrimo(Num)){
            MRespuesta ="Acabas de ingresar el numero:"+" " + Num +"\n \n";
            EncontrarPrimos(Num);
            ArrayNumerosPrimos = new int[contadorPrimos];
            for (int i = 0; i < ArrayNum.length; i++){
                if (ArrayNum[i] != 0) {
                    ArrayNumerosPrimos[cont] = ArrayNum[i];
                    cont++;
                }
            }
            //Pasamos el arreglo de numeros primos como Parametro
            SumarBuscarPrimos(ArrayNumerosPrimos);
            MRespuesta += "Los 4 numeros primos encontrados son: \n"+ Mostrar4Primos + "\n";
            MRespuesta += "Cuya suma es: " + suma + "\n";

            JOptionPane.showMessageDialog(null, MRespuesta);
        }else {
            JOptionPane.showMessageDialog(null, (Num)+" "+"no es un numero primo");
        }
    }

    //Determina si el numero ingresado es primo
    private Boolean DeterminarPrimo(int n){
        if (n > 0){
            int Bandera = 0;
            for (int i = 1; i < (n+1); i++){
                if(n%i == 0) Bandera++;
            }
            if (Bandera == 2) return true;
        }
        return false;
    }

    //Captura todos los numeros primos que puedan ser en contrados en el rango de 2 hasta Num
    private int EncontrarPrimos(int n){
        if (n == 0 ||n == 1 ) return 0;
        else {
            if (DeterminarPrimo(n)) {
                ArrayNum[contA] = n;
                contadorPrimos++;
            }
        }
        contA++;
        return EncontrarPrimos(n-1);
    }//Fin del metodo encontrarprimos

    //Realiza la suma y busqueda de los 4 numeros para que den como resultado el numero primo Num
    private void SumarBuscarPrimos(int[] Primos){

            while(suma != Num){
                suma = 0;
                random = 0;
                Mostrar4Primos = "";
                for (int i = 0; i < ArraySumaPrimos.length; i++){
                    random = (int) Math.floor(Math.random()*(0-contadorPrimos+1)+contadorPrimos); //Genera un numerp aleatorio del 0 al numero de primos encontrados.
                    ArraySumaPrimos[i] = Primos[random];
                    suma += Primos[random];
                    Mostrar4Primos += "["+ArraySumaPrimos[i]+"],";
                }

        }
    }//Fin del metodo SumarBuscarPrimos


}//Fin de la clase primos
