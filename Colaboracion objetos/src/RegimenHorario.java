public class RegimenHorario {
    private long id;
    private int horaIngreso;
    private int minutoIngreso;
    private int horaEgreso;
    private int minutoEgreso;
    private Empleado empleado;

    public RegimenHorario(int horaIngreso, int minutoIngreso, int horaEgreso, int minutoEgreso) {
        this.horaIngreso = horaIngreso;
        this.minutoIngreso = minutoIngreso;
        this.horaEgreso = horaEgreso;
        this.minutoEgreso = minutoEgreso;
    }

    public int getHoraIngreso() { return horaIngreso; }
    public int getMinutoIngreso() { return minutoIngreso; }
    public void setEmpleado(Empleado e) { this.empleado = e; }
}
