package Punto1;

import jakarta.persistence.*;

@Entity
@Table (name = "personas")
@Inheritance ( strategy = InheritanceType.JOINED) // estrategia JOINED

public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(unique = true , length = 100)
    private long dni;

    @OneToOne(cascade = CascadeType.ALL) // Relación 1 a 1 con domicilio
    @JoinColumn (name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, long dni, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
