package EjercicioA;

import java.util.ArrayList;
import java.util.List;

class Control {
    private int id;
    private String denominacion;
    private boolean esObligatorio;
    private List<EstadoControl> estados = new ArrayList<>();

    public Control(int id, String denominacion, boolean esObligatorio) {
        this.id = id;
        this.denominacion = denominacion;
        this.esObligatorio = esObligatorio;
    }

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
