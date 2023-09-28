package aed;

public class Recordatorio {
    private String msg;
    private Fecha f;
    private Horario h;
    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        msg = mensaje;
        f = new Fecha(fecha);
        h = new Horario(horario.hora(), horario.minutos());
    }

    public Horario horario() {
        return h;
    }

    public Fecha fecha() {
        return new Fecha(f);
    }

    public String mensaje() {
        return msg;
    }

    @Override
    public String toString() {
        return msg + " @ " + f.toString() + " " + h.toString() ;
    }

}
