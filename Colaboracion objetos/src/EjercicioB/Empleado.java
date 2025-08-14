package EjercicioB;

import java.util.ArrayList;
import java.util.List;

class Empleado {
    private String nombre;
    private long cuit;
    private String domicilio;
    private String email;
    private List<Asistencia> asistencias = new ArrayList<>();
    private List<Tardanza> tardanzas = new ArrayList<>();
    private RegimenHorario regimenHorario;

    public void agregarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
        asistencia.setEmpleado(this);
    }

    public void agregarTardanza(Tardanza tardanza) {
        tardanzas.add(tardanza);
        tardanza.setEmpleado(this);
    }

    public void setRegimenHorario(RegimenHorario regimen) {
        this.regimenHorario = regimen;
        regimen.setEmpleado(this);
    }

    // b2
    public List<Asistencia> getAsistenciaMesAnio(int mes, int anio) {
        List<Asistencia> resultado = new ArrayList<>();
        for (Asistencia a : asistencias) {
            int mesAsistencia = a.getFecha().getMonth() + 1;
            int anioAsistencia = a.getFecha().getYear() + 1900;
            if (mesAsistencia == mes && anioAsistencia == anio) {
                resultado.add(a);
            }
        }
        return resultado;
    }
    //b3
    public List<Tardanza> getDiasConTardanza(int mes, int anio) {
        List<Tardanza> resultado = new ArrayList<>();
        for (Asistencia a : getAsistenciaMesAnio(mes, anio)) {
            if (a.getTipo().equals("E")) {
                int horaDif = (a.getHora() * 60 + a.getMinuto()) -
                        (regimenHorario.getHoraIngreso() * 60 + regimenHorario.getMinutoIngreso());
                if (horaDif > 15) {
                    Tardanza t = new Tardanza(a.getTipo(), a.getFecha(), a.getHora(), a.getMinuto());
                    t.setEmpleado(this);
                    resultado.add(t);
                }
            }
        }
        return resultado;
    }
}
