package org.example;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer puntoVenta;
    private Long nroComprobante;
    private Double total;

    private LocalDate fechaComprobante;


    private LocalDate fechaAlta;

    private LocalDateTime fechaBaja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteId_fk")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "factura")
    private List<FacturaDetalle> detallesFactura;

    public Factura() {
    }

    public Factura(Cliente cliente, LocalDate fechaAlta, LocalDateTime fechaBaja, LocalDate fechaComprobante, Long nroComprobante, Integer puntoVenta) {
        this.cliente = cliente;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.fechaComprobante = fechaComprobante;
        this.nroComprobante = nroComprobante;
        this.puntoVenta = puntoVenta;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public LocalDate getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(LocalDate fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(Long nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public Integer getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(Integer puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<FacturaDetalle> getDetallesFactura() {
        return detallesFactura;
    }

    public void setDetallesFactura(List<FacturaDetalle> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

        public void addDetalleFactura(FacturaDetalle detalle){
        if(this.detallesFactura == null)
            this.detallesFactura = new ArrayList<FacturaDetalle>();

        detalle.setFactura(this);
        this.detallesFactura.add(detalle);
    }
//
//    @Transient
//    public String getStrProVentaNroComprobante(){
//        return this.getPuntoVenta() + "-" + this.getNroComprobante();
//    }
//
    @Transient
    public double calcularTotal(){
        double totalFac = 0;
        for(FacturaDetalle det : detallesFactura){
            totalFac += det.calcularSubTotal();
        }
        this.total = totalFac;
        return totalFac;
    }


}