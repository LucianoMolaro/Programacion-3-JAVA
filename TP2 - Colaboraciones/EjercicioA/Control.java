package EjercicioA;

class Control {
    private int id;
    private String denominacion;
    private boolean esObligatorio;
    private List<EstadoControl> estados = new ArrayList<>();

    public String getDenominacion() {
        return denominacion;
    }

    public boolean isObligatorio() {
        return esObligatorio;
    }

    public List<EstadoControl> getEstados() {
        return estados;
    }

    public void agregarEstado(EstadoControl estado) {
        estados.add(estado);
    }
}
