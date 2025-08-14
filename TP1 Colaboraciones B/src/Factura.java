import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Factura {
    private String letra, tipoPago;
    private double recargo, totalItems, totalFinal;
    private int numero;
    private Date fecha;

    private Cliente cliente;
    private ArrayList<DetalleFactura> detalle;

    Scanner sc = new Scanner(System.in);

    public Factura() {
        this.detalle=new ArrayList<>();
    }

    public Factura(Date fecha, String letra, int numero, String tipoPago) {
        this.fecha = fecha;
        this.letra = letra;
        this.numero = numero;
        this.tipoPago = tipoPago;
        this.totalItems=0;
        this.totalFinal=0;
        this.detalle = new ArrayList<>();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal() {
        this.totalFinal = this.totalItems * this.recargo;
    }

    public double getTotalItems() {
        return totalItems;
    }

    public void setTotalItems() {
        for(DetalleFactura d: this.detalle){
            this.totalItems+=d.getSubtotal();
        }
    }

    public void validarTipo(String tipo){
        while (true){
            if(tipo.equalsIgnoreCase("A")){
                this.letra=tipo;
                System.out.println("Tipo de factura: A");
                break;
            } else if (tipo.equalsIgnoreCase("B")) {
                this.letra=tipo;
                System.out.println("Tipo de factura: B");
                break;
            }else if(tipo.equalsIgnoreCase("C")){
                this.letra=tipo;
                System.out.println("Tipo de factura: C");
                break;
            }else {
                System.out.print("El tipo de factura ingresado no es válido. Por favor ingrese uno válido: ");
                tipo=sc.nextLine();
            }
        }
    }
    public void validarPago(String pago){
        while (true){
            if(pago.equalsIgnoreCase("C")){
                this.tipoPago=pago;
                this.recargo=0;
                System.out.println("Tipo de pago: Efectivo");
                break;
            } else if (pago.equalsIgnoreCase("TC")) {
                this.tipoPago=pago;
                this.recargo=0.1;
                System.out.println("Tipo de pago: Crédito");
                break;
            }else if(tipoPago.equalsIgnoreCase("TD")){
                this.tipoPago=pago;
                this.recargo=0.05;
                System.out.println("Tipo de pago: Débito");
                break;
            }else {
                System.out.print("El tipo de pago ingresado no es válido. Por favor ingrese uno válido: ");
                pago=sc.nextLine();
            }
        }
    }

    public void agregarDetalle(DetalleFactura df){
        this.detalle.add(df);
        df.setFactura(this);
    }
}
