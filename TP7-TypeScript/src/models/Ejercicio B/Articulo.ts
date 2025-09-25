import { DetalleFactura } from "./DetalleFactura";




export class Articulo{
    codigo: number;
    precio: number;
    denomminacion: string;
    unidadMedida: string;
    detalles: DetalleFactura[];

    constructor(cdg: number, prc: number, dnmc: string, unidadM: string){
        this.codigo = cdg;
        this.denomminacion = dnmc;
        this.precio = prc;
        this.unidadMedida = unidadM;
        this.detalles = [];
    }

    setDetalles(df: DetalleFactura[]){
        this.detalles = df;
    }

    agregarADetalleFactura(df: DetalleFactura){
        this.detalles.push(df);
    }

}