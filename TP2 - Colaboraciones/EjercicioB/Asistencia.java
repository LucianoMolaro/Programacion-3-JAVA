package EjercicioB;
import com.sun.source.tree.ReturnTree;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Asistencia {
    private int hora, minuto;
    private long id;
    private String tipo;
    private Date fecha;

    private Empleado empleado;


    public Asistencia() {
    }

    public Asistencia(int hora, int minuto, String tipo, Date fecha) {
        this.hora = hora;
        this.minuto = minuto;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Asistencia> getAsistenciasXMesXanio(int mes, int anio){
        List<Asistencia> asis = this.empleado.getAsistencias();
        List<Asistencia> totales = new ArrayList<>();
        for (Asistencia a : asis){
            if (a.getTipo().equals("I")){
                if (a.getFecha().getMonth()==mes && a.getFecha().getYear()==anio){
                    totales.add(a);
                }
            }
        }
        return totales;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "hora=" + hora +
                ", minuto=" + minuto +
                ", id=" + id +
                ", tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", empleado=" + empleado +
                '}';
    }
}
