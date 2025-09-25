import { HojaRuta } from "./HojaRuta";
export class Detalle {

    kmSalida: number;
    kmRegreso: number;
    horaSalida: number;
    horaRegreso: number;
    minutoSalida: number;
    minutoRegreso: number;
    hojaRuta: HojaRuta = new HojaRuta (new Date(),0);


    constructor(kmSalida: number, kmRegreso: number, horaSalida: number, horaRegreso: number, minutoSalida: number, minutoRegreso: number) {
        this.kmSalida = kmSalida;
        this.kmRegreso = kmRegreso;
        this.horaSalida = horaSalida;
        this.horaRegreso = horaRegreso;
        this.minutoSalida = minutoSalida;
        this.minutoRegreso = minutoRegreso;
    }

    totalKilometros(): number {
        let total = this.kmRegreso - this.kmSalida;
        return total;
    }

    setKmSalida(ks: number){
        this.kmSalida = ks;
    }
    setKmRegreso(kr: number){
        this.kmRegreso = kr;
    }
    setHoraSalida(hs: number){
        this.horaSalida = hs;
    }
    setHoraRegreso(hre: number){
        this.horaRegreso = hre;
    }
    setMinutoSalida(ms: number){
        this.minutoSalida = ms;
    }
    setMinutoRegreso(mr: number){
        this.minutoRegreso = mr;
    }
    setHojaRuta(hru: HojaRuta){
        this.hojaRuta = hru;
    }

    





}