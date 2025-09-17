import java.util.ArrayList;
import java.util.List;

public class Sector {
    int numero;
    String denominacion;
    String tipo;

    List<Persona> personas = new ArrayList<>();
    List<Sector> subsectores = new ArrayList<>();

    public Sector() {
    }

    public Sector(int numero, String denominacion, String tipo) {
        this.numero = numero;
        this.denominacion = denominacion;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Sector> getSubsectores() {
        return subsectores;
    }

    public void setSubsectores(List<Sector> subsectores) {
        this.subsectores = subsectores;
    }

    public void addPersona(Persona persona) {
        personas.add(persona);
    }

    public void addSubsector(Sector subsector) {
        subsectores.add(subsector);
    }

    // Ejercicio C4
    public List<Sector> obtenerTotalSubsectores() {
        List<Sector> resultado = new ArrayList<>();
        for (Sector s : subsectores) {
            resultado.add(s);
            resultado.addAll(s.obtenerTotalSubsectores()); // recursión
        }
        return resultado;
    }
}
