package Punto1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table (name="historiasClinicas")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private int numero;

    @Column(nullable = false)
    private Date fechaAlta;

    @OneToOne (mappedBy = "historiaClinica")
    private Paciente paciente;

    @OneToMany(mappedBy = "historiaClinica",cascade = CascadeType.ALL)
    private List<DetalleHistoriaClinica> detalleHistoriaClinicas;

    public HistoriaClinica() {
    }

    public HistoriaClinica(int id, int numero, Date fechaAlta, Paciente paciente) {
        this.id = id;
        this.numero = numero;
        this.fechaAlta = fechaAlta;
        this.paciente = paciente;
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

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<DetalleHistoriaClinica> getDetalleHistoriaClinicas() {
        return detalleHistoriaClinicas;
    }

    public void setDetalleHistoriaClinicas(List<DetalleHistoriaClinica> detalleHistoriaClinicas) {
        this.detalleHistoriaClinicas = detalleHistoriaClinicas;
    }

    public void addDetalleHistoriaClinica(DetalleHistoriaClinica detalle) {
        if (detalleHistoriaClinicas == null) {
            detalleHistoriaClinicas = new ArrayList<>();
        }
        if (!detalleHistoriaClinicas.contains(detalle)) {
            detalleHistoriaClinicas.add(detalle);
            detalle.setHistoriaClinica(this);
        }
    }

    public void removeEspecialidad(DetalleHistoriaClinica detalle) {
        if (detalleHistoriaClinicas != null && detalleHistoriaClinicas.contains(detalle)) {
            detalleHistoriaClinicas.remove(detalle);
            detalle.setHistoriaClinica(null);
        }
    }
}
