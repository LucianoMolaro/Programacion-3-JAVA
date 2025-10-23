public class Alumno {
    private int legajo;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    public Alumno(
            int legajo,
            String nombre,
            String apellido,
            String
                    email,
            String telefono) {
        this.legajo =
                legajo;
        this.nombre =
                nombre;
        this.apellido =
                apellido;
        this.email =
                email;
        this.telefono =
                telefono;
    }
    public int getLegajo() {
        return legajo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefono() {
        return telefono;
    }
    @Override
    public String toString() {
        return legajo + " - " + nombre + " " + apellido + " (" +
                email + ")";
    }
}