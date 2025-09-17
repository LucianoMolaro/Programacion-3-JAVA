package Punto1;
import jakarta.persistence.*;

@Entity
@Table (name = "domicilios")

public class Domicilio {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false,length = 50)
    private String localidad;

    @Column(nullable = false, length = 100)
    private String calle;

    @OneToOne (mappedBy = "domicilio")
    private Persona persona;

    public Domicilio() {
    }

    public Domicilio(int id, int numero, String localidad, String calle, Persona persona) {
        this.id = id;
        this.numero = numero;
        this.localidad = localidad;
        this.calle = calle;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
