package ORMJPQL.Models;

import jakarta.persistence.*;

@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "E-mail")
    private String email;
    @Column(name = "Domicilio")
    private String domicilio;
    @Column(name = "N° Celular", unique = true)
    private Long telefono;

    public Agenda() {
    }

    public Agenda(String apellido, String domicilio, String email, String nombre, Long telefono) {
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
}
