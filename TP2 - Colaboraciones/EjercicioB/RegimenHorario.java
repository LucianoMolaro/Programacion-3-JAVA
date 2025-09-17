package EjercicioB;

public class RegimenHorario {
    private long id;
    private int horaIngreso;
    private int minutoIngreso;
    private int horaEgreso;
    private int minutoEgreso;


    private Empleado empleado;


    public RegimenHorario() {
    }

    public RegimenHorario(int horaIngreso, int minutoIngreso, int horaEgreso, int minutoEgreso) {
        this.horaIngreso = horaIngreso;
        this.minutoIngreso = minutoIngreso;
        this.horaEgreso = horaEgreso;
        this.minutoEgreso = minutoEgreso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHoraIngreso(int horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public void setMinutoIngreso(int minutoIngreso) {
        this.minutoIngreso = minutoIngreso;
    }

    public int getHoraEgreso() {
        return horaEgreso;
    }

    public void setHoraEgreso(int horaEgreso) {
        this.horaEgreso = horaEgreso;
    }

    public int getMinutoEgreso() {
        return minutoEgreso;
    }

    public void setMinutoEgreso(int minutoEgreso) {
        this.minutoEgreso = minutoEgreso;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public int getHoraIngreso() { return horaIngreso; }
    public int getMinutoIngreso() { return minutoIngreso; }
    public void setEmpleado(Empleado e) { this.empleado = e; }


}
