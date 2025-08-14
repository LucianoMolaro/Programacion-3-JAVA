import java.util.Date;

public class Tardanza {
    private long id;
    private String tipo;
    private Date fecha;
    private int hora;
    private int minuto;
    private Empleado empleado;

    public Tardanza(String tipo, Date fecha, int hora, int minuto) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.minuto = minuto;
    }

    public void setEmpleado(Empleado e) { this.empleado = e; }
}

