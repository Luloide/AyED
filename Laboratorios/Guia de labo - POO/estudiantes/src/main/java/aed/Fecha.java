package aed;

public class Fecha {
    private int d;
    private int m;

    public Fecha(int dia, int mes) {
        d = dia;
        m = mes;
    }

    public Fecha(Fecha fecha) {
        d = fecha.d;
        m = fecha.m;
    }

    public Integer dia() {
        return d;
    }

    public Integer mes() {
        return m;
    }

    public String toString() {
        return Integer.toString(d) +  "/" + Integer.toString(m);
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
        Fecha otraFecha = (Fecha) otra;
        return this.d == otraFecha.d && this.m == otraFecha.m;
    }

    public void incrementarDia() {
        int[] meses31 = {1,3,5,7,8,10,12};
        int[] meses30 = {4,6,9,11};
        if (d == 31){
            if(m == 12){
                m = 1;
                d = 1;
            }
            else{
                d = 1;
                m++;
            }
        }
        else if(d == 28 && m == 2){
            m++;
            d = 1;
        }
        else if(d == 30){
            for(int i =0; i<meses31.length; i++){
                if(m == meses31[i]){
                    d++;
                }
            }
            for(int j = 0; j < meses30.length; j++){
                if(m == meses30[j]){
                    d = 1;
                    m++;
                }
            }
        }
        else{
            d++;
        }
    }
    // re boluda no vi
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
