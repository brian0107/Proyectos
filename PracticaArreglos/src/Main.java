import javax.swing.*;

import Clases.*;

public class Main {
    public static void main(String[] args) {
        String Select = "1 - Calcular la media de N alturas \n " + "2 - Calcular la media de 10 numeros (Signo Caulquiera) \n " + "3 - Encontrar 4 numeros primos con suma igual a N \n "+"4 - Promedio de temperatura Anual \n "+"5 - Encuesta Salario \n " +"ESCOJA EL PROGRAMA QUE DECEA UTILIZAR \n \n";
        boolean continuar = true;
        int option=1;

        do {
            switch (Integer.parseInt(JOptionPane.showInputDialog(Select))){
                case 1:
                    new Altura();
                    option=Integer.parseInt(JOptionPane.showInputDialog("¿Decea utilizar otro programa? \n 1 = Usar otro     0 = Salir del Programa"));
                    break;
                case 2:
                    new Numeros();
                     option=Integer.parseInt(JOptionPane.showInputDialog("¿Decea utilizar otro programa? \n 1 = Usar otro     0 = Salir del Programa"));
                    break;
                case 3:
                    new Primos();
                    option=Integer.parseInt(JOptionPane.showInputDialog("¿Decea utilizar otro programa? \n 1 = Usar otro     0 = Salir del Programa"));
                    break;
                case 4:
                    new Temperatura();
                    option=Integer.parseInt(JOptionPane.showInputDialog("¿Decea utilizar otro programa? \n 1 = Usar otro     0 = Salir del Programa"));
                    break;
                case 5:
                    new Encuesta();
                    option=Integer.parseInt(JOptionPane.showInputDialog("¿Decea utilizar otro programa? \n 1 = Usar otro     0 = Salir del Programa"));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Elegiste una opcion incorrecta, intenta de nuevo");
                    break;
            }
            if (option==0){
                JOptionPane.showMessageDialog(null, "Hasta la proxima");
                continuar=false;
            }

        }while(continuar);
    }
}
