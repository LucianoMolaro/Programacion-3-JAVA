import { Articulo } from "./Articulo";
import { Factura } from "./Factura";


export class DetalleFactura{
    cantidad: number;
    subtotal: number;
    articulo: Articulo;
    factura: Factura;

    constructor(cantidad: number, st: number) {
        this.cantidad = cantidad;
        this.subtotal = st;
        this.articulo = new Articulo(0,0,"","");
        this.factura = new Factura("", 0,"",new Date());
    }

    calcularSubtotal(){
        this.subtotal = this.cantidad * this.articulo.precio;
    }

    setFactura(f: Factura){
        this.factura = f;
    }

    setArticulo(a:Articulo){
        this.articulo = a;
    }



}