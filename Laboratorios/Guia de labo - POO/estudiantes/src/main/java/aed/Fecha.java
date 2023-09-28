package aed;

public class Fecha {
    private int dia;
    private int mes;
    public Fecha(int dia, int mes) {
        new Fecha(dia, mes);
    }

    public Fecha(Fecha fecha) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    public String toString() {
        return Integer.toString(dia) +  "/" + Integer.toString(mes);
    }

    @Override
    public boolean equals (Object otra) {
        // otra es null
        boolean oen = (otra == null);
        // clase es distinta
        boolean cd = otra.getClass() != this.getClass();
        if (oen || cd) {
            return false;
        }
        else{
            return true;
        }
    }

    public void incrementarDia() {
        int[] meses31 = {1,3,5,7,8,10,12};
        int[] meses30 = {4,6,9,11};
        if (dia == 31){
            if(mes == 12){
                mes = 1;
                dia = 1;
            }
            else{
                dia = 1;
                mes++;
            }
        }
        else if(dia == 28 && mes == 2){
            mes++;
            dia = 1;
        }
        else if(dia == 30){
            for(int i =0; i<meses31.length; i++){
                if(mes == i){
                    dia++;
                }
            for(int j = 0; i < meses30.length; i++){
                if(mes == j){
                    dia = 1;
                    mes++;
                }
            }
            }
        }
        else{
            dia++;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
