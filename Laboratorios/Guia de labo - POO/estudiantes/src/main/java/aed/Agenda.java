package aed;
import java.util.Vector;

public class Agenda {
    private Fecha fechaAct;
    private Vector<Recordatorio> recs;

    public Agenda(Fecha fechaActual) {
        fechaAct = new Fecha(fechaActual);
        recs = new Vector<>();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        recs.add(recordatorio);
    }

    @Override
    public String toString() {
        String imp = fechaAct.toString().concat("\n").concat("=====\n");
        for(int j = 0; j < recs.size() ; j++){
            if((recs.get(j)).fecha().dia() == fechaAct.dia() && (recs.get(j)).fecha().mes() == fechaAct.mes()){
                imp = imp.concat((recs.get(j)).toString() + "\n");
            }
        }
        return imp;
        }

    public void incrementarDia() {
        fechaAct.incrementarDia();
    }

    public Fecha fechaActual() {
        return fechaAct;
    }

}
