package aed;

class VectorDeInts implements SecuenciaDeInts {
    private static final int CAPACIDAD_INICIAL = 1;
    private int[] vc;
    private int len;

    public VectorDeInts() {
        vc = new int[1000];
        len = 0;
    }

    public VectorDeInts(VectorDeInts vector) {
        vc = new int[vector.vc.length];
        len = vector.len;
        for (int i = 0 ; i < vc.length; i++){
            vc[i] = vector.vc[i];
        }
    }

    public int longitud() {
        return len;
    }

    public void agregarAtras(int i) {
        if (vc.length == len){
            // nuevo vector con un len + 1, copiamos y agregamos :)
            int[] vectorAux = new int[vc.length +1];
            for (int j = 0; j < len; j++){
                vectorAux[j] = vc[j];
            }
            vectorAux[len] = i;
        }
        else{
            vc[len] = i;
        }
        len++;
    }

    public int obtener(int i) {
        return vc[i];
    }

    public void modificarPosicion(int indice, int valor){
        vc[indice] = valor;
    }

    public void quitarAtras() {
        len--;
    }

    public VectorDeInts copiar() {
        VectorDeInts vectorAux = new VectorDeInts();
        for(int i =0; i< len; i++){
            vectorAux.agregarAtras(vc[i]);
        }
        vectorAux.len = len;
        return vectorAux;
    }

}
