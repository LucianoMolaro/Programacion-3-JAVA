import java.util.Scanner;

public class DetalleFactura {
    Scanner sc = new Scanner(System.in);
    private double cantidad;
    private double subtotal;

    private Articulo articulo;
    private Factura factura;

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
        articulo.agregarDetalle(this);
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String validacionUnidad(Articulo a){
        if (a.getUnidadMedida().equalsIgnoreCase("U")) {
            System.out.print("Ingrese la cantidad en " + a.getUnidadMedida() + "(solo numeros enteros): ");
            String cnt = sc.nextLine();
            if (cnt.contains(".")){
                System.out.println("Numero invalido...");
                return null;
            }else {
                return cnt;
            }
        }
        System.out.println("Ingrese la cantidad en " + a.getUnidadMedida() + "(puede ser decimal): ");
        String cnt = sc.nextLine();
        return cnt;
    }
}
