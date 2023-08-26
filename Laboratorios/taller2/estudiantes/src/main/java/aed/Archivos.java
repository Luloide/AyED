package aed;

import java.util.Scanner;
import java.io.PrintStream;

class Archivos {
    float[] leerVector(Scanner entrada, int largo) {
        int i = 0;
        float[] salida = new float[largo];

        while (i != largo){
            salida[i] = entrada.nextFloat();
            i++;
        }
        return salida;
    }

    float[][] leerMatriz(Scanner entrada, int filas, int columnas) {
        int i = 0;
        int j = 0;
        float[][] salida = new float[filas][columnas];
        while (i != filas){
            while(j != columnas){
                salida[i][j] = entrada.nextFloat();
            j++;     
        }
        j = 0; 
        i++;
    }
        return salida;
    }

    void imprimirPiramide(PrintStream salida, int alto) {
        for(int i = 1; i<= alto ; i++){
            //print spaces
            for (int j = alto; j > i; j--){
                salida.print(" ");
            }
            // print stars
            for( int j = 1; j <= 2*i -1 ; j++){
                salida.print("*"); 
            }
            // mas espacios
            for (int j = alto; j > i; j--){
                salida.print(" ");
            }
            salida.println();
        }
    }
}

