package Punto1;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table (name="pacientes")
public class Paciente extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private int nroSocio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "historiaClinica", referencedColumnName = "id")
    private HistoriaClinica historiaClinica;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Turno> turnos;

    public Paciente() {
    }

    public Paciente(int id, int nroSocio, HistoriaClinica historiaClinica) {
        this.id = id;
        this.nroSocio = nroSocio;
        this.historiaClinica = historiaClinica;
    }


    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void addTurno(Turno turno) {
        if (turnos == null) {
            turnos = new ArrayList<>();
        }
        if (!turnos.contains(turno)) {
            turnos.add(turno);
            turno.setPaciente(this); // sincroniza el lado inverso
        }
    }
    public void removeTurno(Turno turno) {
        if (turnos != null && turnos.contains(turno)) {
            turnos.remove(turno);
            if (turno.getPaciente() == this) {
                turno.setPaciente(null); // rompe la relación inversa
            }
        }
    }
}
