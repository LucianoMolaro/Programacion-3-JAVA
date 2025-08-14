package EjercicioA;

class EstadoControl {
    private long id;
    private boolean aprobado;

    public EstadoControl(long id, boolean aprobado) {
        this.id = id;
        this.aprobado = aprobado;
    }

    public boolean estaAprobado() {
        return aprobado;
    }
}