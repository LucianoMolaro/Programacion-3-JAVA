package EjercicioA;

import java.util.ArrayList;
import java.util.List;

public class Expediente {
    private int id;
    private String letra;
    private int numero;
    private String descripcion;
    private String tipo;
    private String ambito;
    private List<Control> controles = new ArrayList<>();
    private List<Expediente> expedientesAsociados = new ArrayList<>();

    public String getCaratulaExpediente() {
        return numero + "-" + letra + "-" + descripcion;
    }

    public String getControlesObligatorios() {
        String resultado = "";
        for (Control c : controles) {
            if (c.isObligatorio()) {
                if (!resultado.isEmpty()) {
                    resultado += ", ";
                }
                resultado += c.getDenominacion();
            }
        }
        return resultado;
    }


    public boolean getEstadoControles() {
        for (Control c : controles) {
            if (c.isObligatorio()) {
                for (EstadoControl e : c.getEstados()) {
                    if (!e.estaAprobado()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public List<Expediente> listaExpedientes() {
        List<Expediente> resultado = new ArrayList<>();
        listaExpedientesRecursivo(this, resultado);
        return resultado;
    }

    private void listaExpedientesRecursivo(Expediente exp, List<Expediente> acumulador) {
        for (Expediente hijo : exp.expedientesAsociados) {
            acumulador.add(hijo);
            listaExpedientesRecursivo(hijo,acumulador);
        }
    }
    public void agregarControl(Control control) {
        controles.add(control);
    }

    public void agregarExpedienteAsociado(Expediente expediente) {
        expedientesAsociados.add(expediente);
    }
}
