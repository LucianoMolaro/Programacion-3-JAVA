import { Vehiculo } from "./Vehiculo";
import { Detalle } from "./Detalle"

export class HojaRuta{
    fecha: Date;
    numero: number;
    vehiculo: Vehiculo = new Vehiculo("","","");
    detalles: Detalle[] = [];

    constructor(fecha: Date, numero: number){
        this.numero= numero;
        this.fecha = fecha;
    }

    calcularTotalKilometros(): number{
        let total = 0;
        for(const a of this.detalles){
            total+=a.totalKilometros();
        }
        return total;
    }

    setVehiculo(v:Vehiculo){
        this.vehiculo = v;
    }

//Agregacion lista completa de detalles
    setDetalles(d: Detalle[]){
        this.detalles = d;
        for(const di of d){
            di.setHojaRuta(this);
        }
    }

//Agregacion individual de detalles
    agregarDetalle(d: Detalle):void{
        this.detalles.push(d);
    }
}