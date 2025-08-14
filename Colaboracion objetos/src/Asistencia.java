import java.util.Date;

public class Asistencia {
    private long id;
    private String tipo; // E o S
    private Date fecha;
    private int hora;
    private int minuto;
    private Empleado empleado;

    public Asistencia(String tipo, Date fecha, int hora, int minuto) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.minuto = minuto;
    }

    public String getTipo() { return tipo; }
    public Date getFecha() { return fecha; }
    public int getHora() { return hora; }
    public int getMinuto() { return minuto; }
    public void setEmpleado(Empleado e) { this.empleado = e; }
}