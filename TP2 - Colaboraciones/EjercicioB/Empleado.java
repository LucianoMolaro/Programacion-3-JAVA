package EjercicioB;

import java.util.ArrayList;
import java.util.List;

class Empleado {
    private String nombre;
    private long cuit;
    private String domicilio;
    private String email;

    private RegimenHorario regimenHorario;

    private List<Asistencia> asistencias = new ArrayList<>();
    private List<Tardanza> tardanzas = new ArrayList<>();


    public Empleado() {

    }

    public Empleado(String nombre, long cuit, String domicilio, String email) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.domicilio = domicilio;
        this.email = email;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public void agregarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
        asistencia.setEmpleado(this);
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public List<Tardanza> getTardanzas() {
        return tardanzas;
    }

    public void setTardanzas(List<Tardanza> tardanzas) {
        this.tardanzas = tardanzas;
    }

    public RegimenHorario getRegimenHorario() {
        return regimenHorario;
    }

    public void setRegimenHorario(RegimenHorario regimenHorario) {
        this.regimenHorario = regimenHorario;
        regimenHorario.setEmpleado(this);
    }
    public List<Tardanza> getDiasConTardanza(int mes, int anio){
        List<Tardanza> tardanzas = new ArrayList<>();
        for (Asistencia a : this.asistencias){
            if (a.getHora()>=this.regimenHorario.getHoraIngreso() || this.regimenHorario.getMinutoIngreso()+a.getMinuto()>15){
                Tardanza tard = new Tardanza(a.getHora(), a.getMinuto(), a.getFecha(),this, "I");
                tardanzas.add(tard);
            }
        }

        return tardanzas;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "regimenHorario=" + regimenHorario +
                ", email='" + email + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", cuit=" + cuit +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
