package org.example;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private boolean esInsumo;

    @OneToMany
    @JoinColumn(name = "categoria_fk")
    private Set<Articulo> articulos = new HashSet<>();

    public Categoria() {
    }

    public Categoria(boolean esInsumo, String denominacion, Set<Articulo> articulos) {
        this.esInsumo = esInsumo;
        this.denominacion = denominacion;
        this.articulos = articulos;
    }

    public Set<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public boolean isEsInsumo() {
        return esInsumo;
    }

    public void setEsInsumo(boolean esInsumo) {
        this.esInsumo = esInsumo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}