import { HojaRuta } from "./HojaRuta";

export class Vehiculo{
    patente:string;
    marca:string;
    modelo:string;
    hojasDeRuta: HojaRuta[] = [];

    constructor(patente: string, marca: string, modelo: string){
        this.patente= patente;
        this.marca = marca;
        this.modelo = modelo;
    }

    calcularTotalKilometrosRecorridos (fechaDesde: Date, fechaHasta: Date): number{
        let kmRecorridos = 0;
        for(const hr of this.hojasDeRuta){
            if(hr.fecha.getTime() >= fechaDesde.getTime() || hr.fecha.getTime() <= fechaHasta.getTime()){
                kmRecorridos+= hr.calcularTotalKilometros();
            }
        }
        return kmRecorridos;
    }

    setPatente(patente: string){
        this.patente = patente;
    }
    setMarca(marca: string){
        this.marca = marca;
    }
    setModelo(modelo: string){
        this.modelo = modelo;
    }
    
    setHojasDeRuta(hdr: HojaRuta[]){
        this.hojasDeRuta = hdr;
    }

    agregarHojaRuta(hr: HojaRuta): void{
        this.hojasDeRuta.push(hr);
        hr.setVehiculo(this);
    }

}