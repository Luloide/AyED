package aed;

class Funciones {
    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt((x * x) + (y * y));
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
        boolean bisiesto = false;
        if(((n % 4 == 0) & !(n % 100 == 0)) || (n % 400 == 0)){
            bisiesto = true;
        }
        return bisiesto;
    }

    int factorialIterativo(int n) {
        int prod = 1;
        for(int i = 1; i <= n; i++){
            prod = i * prod;
        }
        return prod;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if(n == 0){
            return res;
        }
        else{
             return factorialRecursivo(n-1) * n;
        }
        
    }

    boolean esPrimo(int n) {
        boolean primo = false;
        int suma = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                suma++;
            }
        }
        if(suma == 2){
            primo = true;
        }
        return primo;
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
            i++;
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
        boolean sonAllPares = true;
        for(int i = 0; i < numeros.length; i++){
            if (!esPar(numeros[i])){
                sonAllPares = false;
            }
        }
        return sonAllPares;
    }

    boolean esPrefijo(String s1, String s2) {
        int i = 0;
        boolean prefijo = true;
        if(s1.length() > s2.length()){
            return false;
        }
        while(i < s1.length()){
            if(s1.charAt(i) != s2.charAt(i)){
                prefijo = false;
            }
            i++;
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
