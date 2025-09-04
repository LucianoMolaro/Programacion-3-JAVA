package Punto1;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "medicos")
public class Medico extends Persona{


    @Column(nullable = false,unique = true)
    private int matricula;

    @Column(nullable = false,length = 50)
    private long celular;

    @OneToMany(mappedBy = "medico", cascade=CascadeType.ALL)
    private List<Turno> turnos;

    @ManyToMany
    @JoinTable(
            name = "medico_especialidad",
            joinColumns = @JoinColumn(name = "medico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id")
    )
    private List<Especialidad> especialidades;

    public Medico() {
    }

    public Medico(int id, int matricula, long celular) {
        this.id = id;
        this.matricula = matricula;
        this.celular = celular;
    }


    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public void addTurno(Turno turno) {
        if (turnos == null) {
            turnos = new ArrayList<>();
        }
        if (!turnos.contains(turno)) {
            turnos.add(turno);
            turno.setMedico(this);
        }
    }

    public void removeTurno(Turno turno) {
        if (turnos != null && turnos.contains(turno)) {
            turnos.remove(turno);
            if (turno.getMedico() == this) {
                turno.setMedico(null);
            }
        }
    }

    public void addEspecialidad(Especialidad especialidad) {
        if (especialidades == null) {
            especialidades = new ArrayList<>();
        }
        if (!especialidades.contains(especialidad)) {
            especialidades.add(especialidad);
            especialidad.getMedicos().add(this);
        }
    }

    public void removeEspecialidad(Especialidad especialidad) {
        if (especialidades != null && especialidades.contains(especialidad)) {
            especialidades.remove(especialidad);
            especialidad.getMedicos().remove(this);
        }
    }

}
