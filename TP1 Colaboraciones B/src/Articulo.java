import java.util.ArrayList;
import java.util.Scanner;

public class Articulo {
    Scanner sc = new Scanner(System.in);
    private String denominacion, unidadMedida;
    private int codigo;
    private double precio;

    private ArrayList<DetalleFactura> detalleFacturas;



    public Articulo() {
    }

    public Articulo(int codigo, String denominacion, String unidadMedida, double precio) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.unidadMedida = unidadMedida;
        this.precio=precio;
        this.detalleFacturas  = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void mostrarArticulo(){
        System.out.println("--------------------------------------------------------------------------------------------" + "\n" +
                this.codigo + "\t" + this.denominacion + "\t" + this.precio + "\t" + this.unidadMedida);
    }

    public void agregarDetalle(DetalleFactura df){
        this.detalleFacturas.add(df);
    }


}
