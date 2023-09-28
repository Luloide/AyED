package aed;

public class Horario {
    private int hr;
    private int min;
    public Horario(int hora, int minutos) {
        hr = hora;
        min = minutos;
    }

    public int hora() {
        return hr;
    }

    public int minutos() {
        return min;
    }

    @Override
    public String toString() {
        return Integer.toString(hr) +  ":" + Integer.toString(min);
    }

    @Override
    public boolean equals(Object otro) {
        // otro es null
        boolean oen = (otro == null);
        // clase es distinta
        boolean cd = otro.getClass() != this.getClass();
        if (oen || cd) {
            return false;
        }
        Horario otroHorario = (Horario) otro;
        return this.hr == otroHorario.hr && this.min == otroHorario.min;
    }
}
