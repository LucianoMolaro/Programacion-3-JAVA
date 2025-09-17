import java.util.ArrayList;
import java.util.List;

public class TipoActividad {
    int codigo;
    String denominacion;
    Double puntosAsignados;

    List<Actividad> actividades = new ArrayList<>();

    public TipoActividad() {
    }

    public TipoActividad(int codigo, String denominacion, Double puntosAsignados) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.puntosAsignados = puntosAsignados;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Double getPuntosAsignados() {
        return puntosAsignados;
    }

    public void setPuntosAsignados(Double puntosAsignados) {
        this.puntosAsignados = puntosAsignados;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}
