package Punto1;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table (name="especialidades")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 100)
    private String denominacion;

    @ManyToMany (mappedBy = "especialidades")
    private List<Medico> medicos;

    public Especialidad() {
    }

    public Especialidad(int id, String denominacion) {
        this.id = id;
        this.denominacion = denominacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public void addMedico(Medico medico) {
        if (medicos == null) {
            medicos = new java.util.ArrayList<>();
        }
        if (!medicos.contains(medico)) {
            medicos.add(medico);
            medico.addEspecialidad(this);
        }
    }

    public void removeMedico(Medico medico) {
        if (medicos != null && medicos.contains(medico)) {
            medicos.remove(medico);
            medico.removeEspecialidad(this);
        }
    }

}
