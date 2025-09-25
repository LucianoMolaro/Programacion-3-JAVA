import { Factura } from "./Factura";


export class Cliente{
    numero: number;
    cuit: number;
    razonSocial: string;
    facturas: Factura[];

    constructor(num: number, cuit: number, rz: string) {
        this.numero = num;
        this.cuit = cuit;
        this.razonSocial = rz;
        this.facturas = [];
    }

    totalFacturadoXTipoPago(tp: string): number{
        let vcf = 0;
        for(const f of this.facturas){
            if(f.tipoPago.toLowerCase() == tp.toLowerCase()){
                vcf += f.totalFinal;
            }
        }
        if(vcf>0){
            return vcf;
        }else{
            return this.facturas.reduce((acu, f) => acu + f.totalFinal, 0);
        }
    }

    setFacturas(f: Factura[]){
        this.facturas = f;
    }

    agregarFactura(f: Factura){
        this.facturas.push(f);
    }

}