public class Factura {
    private String fecha, razonSocial, tipoPago;
    private double montoTotaltems, recargo, montoFinal;
    private long nroFactura, cuitCliente;
    private String[][] itemsFacturas;

    public long getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(long cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public double getMontoTotaltems() {
        return montoTotaltems;
    }

    public void setMontoTotaltems(double montoTotaltems) {
        this.montoTotaltems = montoTotaltems;
    }

    public long getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(long nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String[][] getItemsFacturas() {
        return itemsFacturas;
    }

    public void setItemsFacturas(int ca) {
        this.itemsFacturas = new String[5][ca+1];
    }
}
