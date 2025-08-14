import java.util.ArrayList;
import java.util.List;

public class Persona {
    String nombre;
    String tipoDocumento;
    long   nroDocumento;
    int telefono;
    String email;
    String celular;

    List<Actividad> actividades = new ArrayList<>();
    Sector sector;

    public Persona() {

    }

    public Persona(String nombre, String tipoDocumento, long nroDocumento, int telefono, String email, String celular, Sector sector) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.telefono = telefono;
        this.email = email;
        this.celular = celular;
        this.sector = sector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(long nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public double totalPuntosAsignados(){
        double totalPuntos = 0;

        for (int i = 0; i < actividades.size(); i++) {
            Actividad actividad = actividades.get(i);
            totalPuntos+=actividad.getTipoActividad().getPuntosAsignados();
        }
        return totalPuntos;
    }

    public double totalPuntosAsignados(int codigo) {
        double total = 0;
        for (Actividad act : actividades) {
            if (act.getTipoActividad().getCodigo() == codigo) {
                total += act.getTipoActividad().getPuntosAsignados();
            }
        }
        return total;
    }

    public double totalPuntosAsignados(int codigo, int anio) {
        double total = 0;
        for (Actividad act : actividades) {
            if (act.getTipoActividad().getCodigo() == codigo) {
                int anioActividad = act.getFechaInicio().getYear()+1900;
                if (anioActividad == anio) {
                    total += act.getTipoActividad().getPuntosAsignados();
                }
            }
        }
        return total;
    }
}
