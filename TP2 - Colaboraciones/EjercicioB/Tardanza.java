package EjercicioB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tardanza {
    private long id;
    private String tipo;
    private Date fecha;
    private int hora;
    private int minuto;


    private Empleado empleado;

    public Tardanza() {
    }

    public Tardanza(int hora, int minuto, Date fecha, Empleado empleado, String tipo) {
        this.hora = hora;
        this.minuto = minuto;
        this.fecha = fecha;
        this.empleado=empleado;
        this.tipo=tipo;
    }

    public Tardanza(String tipo, Date fecha, int hora, int minuto) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
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

    @Override
    public String toString() {
        return "Tardanza{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", minuto=" + minuto +
                ", empleado=" + empleado +
                '}';
    }
}

