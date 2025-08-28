package org.example;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(unique = true)
    protected String codigo;
    protected String denominacion;
    protected Double precioVenta;

    @OneToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,  CascadeType.REMOVE})
    @JoinColumn(name = "articulo_fk")
    protected Set<Imagen> imagenes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "unidadMedida_fk")
    protected UnidadMedida unidadMedida;

    public Articulo() {
    }

    public Articulo(String denominacion, String codigo, Double precioVenta, UnidadMedida unidadMedida) {
        this.denominacion = denominacion;
        this.codigo = codigo;
        this.precioVenta = precioVenta;
        this.unidadMedida = unidadMedida;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Set<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(Set<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Double getPrecioVenta() {
        if(precioVenta != null)
            return precioVenta;
        return 0d;
    }
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Long getId() {
        return id;
    }

}