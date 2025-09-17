package Punto1;
import jakarta.persistence.*;

@Entity
@Table (name="empleados")
public class Empleado extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private int nroLegajo;

    @Column(nullable = false)
    private double sueldo;

    public Empleado() {
    }

    public Empleado(int id, int nroLegajo, double sueldo) {
        this.id = id;
        this.nroLegajo = nroLegajo;
        this.sueldo = sueldo;
    }

    public int getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
