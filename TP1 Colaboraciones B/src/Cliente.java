import java.util.ArrayList;

public class Cliente {
    private static int num=1000;
    private int numero;
    private String razonSocial, nombre;
    private long CUIL;


    private ArrayList<Factura> facturas;


    public Cliente() {
        this.facturas=new ArrayList<>();
        this.num++;
        this.numero=num;
    }

    public Cliente(String nombre, long CUIL, int numero, String razonSocial) {
        this.nombre=nombre;
        this.CUIL = CUIL;

        this.razonSocial = razonSocial;

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getCUIL() {
        return CUIL;
    }

    public void setCUIL(long CUIL) {
        this.CUIL = CUIL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void agregarFactura(Factura factura){
        this.facturas.add(factura);
        factura.setCliente(this);
    }
}
