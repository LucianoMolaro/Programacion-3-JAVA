import { Cliente } from "./Cliente";
import { DetalleFactura } from "./DetalleFactura";




export class Factura {
    letra: string;
    tipoPago: string;
    numero: number;
    recargo: number;
    totalItems: number;
    totalFinal: number;
    fecha: Date;
    detalleFactura: DetalleFactura[];
    cliente: Cliente;

    constructor(letra: string, numero: number, tipoP: string, fecha: Date) {
        this.numero = numero;
        this.letra = letra;
        this.tipoPago = tipoP;
        this.fecha = fecha;
        this.recargo = 0;
        this.totalItems = 0;
        this.totalFinal = 0;
        this.detalleFactura = [];
        this.cliente = new Cliente(0,0,"");
    }

    calcularTotalItems(){
        for(const df of this.detalleFactura){
            df.calcularSubtotal();
            this.totalItems+=df.subtotal;
        }
    }

    calcularTotalFinal(){
        this.calcularRecargo;
        this.totalFinal += this.totalItems * this.recargo;
    }

    calcularRecargo(){
        switch(this.tipoPago){
            case "E": this.recargo = 0
            case "TD": this.recargo = 0.05
            case "TC": this.recargo = 0.10
            case "CC": this.recargo = 0.10
            case "TR": this.recargo = 0.07
            default: this.recargo = 0;
        }
    }

    setTotalItems(ti: number){
        this.totalItems = ti;
    }

    setRecargo(recargo: number){
        this.recargo = recargo;
    }

    setTotalFinal(tf: number){
        this.totalFinal = tf;
    }

    setCliente(c: Cliente){
        this.cliente = c;
    }

    setDetallesFacturas(df: DetalleFactura[]){
        this.detalleFactura = df;
    }

    agregarDetalleFactura(df: DetalleFactura){
        this.detalleFactura.push(df);
    }



}