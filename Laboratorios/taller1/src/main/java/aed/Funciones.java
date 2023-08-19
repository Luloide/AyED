package aed;

class Funciones {
    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt((x * x) + (y + y));
        return res;
    }

    boolean esPar(int n) {
        if(n % 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    boolean esBisiesto(int n) {
        if((n % 4 == 0) & !(n % 100 == 0)){
            return true;
        }
        else{
            return false;
        }
    }

    int factorialIterativo(int n) {
        int i = 0;
        int suma = 0;
        while(i != n){
            suma = suma + 1;
        }
        return suma;
    }

    int factorialRecursivo(int n) {
        int res = 0;
        if(n == 0){
            return res;
        }
        else{
             return factorialRecursivo(n-1) + 1;
        }
        
    }

    boolean esPrimo(int n) {
        if (n % 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    int sumatoria(int[] numeros) {
        int suma = 0;
        int length = numeros.length;
        for(int i = 0; i < length ;i++){
            suma = suma + numeros[i];
        }
        return suma;
    }

    int busqueda(int[] numeros, int buscado) {
        int i = 0;
        int res = 0;
        while (i < numeros.length){
            if(numeros[i] == buscado){
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean tiene = false;
        for(int i = 0; i < numeros.length; i++){
            if(esPrimo(numeros[i])){
                tiene = true;
            }
        }
        return tiene;
    }

    boolean todosPares(int[] numeros) {
        boolean sonAllPares = false;
        for(int i = 0; i < numeros.length; i++){
            if (!esPar(i)){
                sonAllPares = false;
            }
        }
        return sonAllPares;
    }

    boolean esPrefijo(String s1, String s2) {
        int i = 0;
        boolean prefijo = true;
        while(i < s1.length()){
            if(s1.charAt(i) != s2.charAt(i)){
                prefijo = false;
            }
        }
        return prefijo;
    }

    String reverse(String str){
        String nuevoString = "";
        for(int i = 0; i < str.length(); i ++){
            nuevoString = str.charAt(i) + nuevoString;
        }
        return nuevoString;
    }

    boolean esSufijo(String s1, String s2) {
        String s1reverso = reverse(s1);
        String s2reverso = reverse(s2);
        return esPrefijo(s1reverso, s2reverso);
    }
}
