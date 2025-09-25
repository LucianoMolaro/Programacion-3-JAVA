import { Detalle } from "./Detalle";
import { HojaRuta } from "./HojaRuta";
import { Vehiculo } from "./Vehiculo";



    //creacion de vehiculo
    const vehiculo1 = new Vehiculo("AA100EE","Fiat","Cronos");

    //creacion de hojas de rutas
    const hojaruta1 = new HojaRuta(new Date("2025-09-24"), 1001);
    const hojaruta2 = new HojaRuta(new Date("2025-09-25"), 1002);
    const hojaruta3 = new HojaRuta(new Date("2025-09-26"), 1003);

    //creacion de detalles de hojas de rutas
    const detalle1 = new Detalle(100,120,9,17,0,30);
    const detalle2 = new Detalle(120,140,10,19,30,0);
    const detalle3 = new Detalle(140,160,8,16,30,30);

    const detalle4 = new Detalle(100,130,8,17,30,0);
    const detalle5 = new Detalle(130,160,8,16,0,45);
    const detalle6 = new Detalle(160,190,7,15,0,50);

    const detalle7 = new Detalle(100,140,9,18,10,45);
    const detalle8 = new Detalle(140,180,9,18,20,50);
    const detalle9 = new Detalle(180,220,8,17,30,50);

    //colaboraciones de clases
    vehiculo1.agregarHojaRuta(hojaruta1);
    vehiculo1.agregarHojaRuta(hojaruta2);
    vehiculo1.agregarHojaRuta(hojaruta3);

    const detalles1 = [detalle1, detalle2, detalle3]
    hojaruta1.setDetalles(detalles1);

    const detalles2 = [detalle4, detalle5, detalle6]
    hojaruta2.setDetalles(detalles2);

    const detalles3 = [detalle7, detalle8, detalle9]
    hojaruta3.setDetalles(detalles3);
    


    //prueba de metodos
    console.log("El total de kilometros recorridos en la hoja es: ", hojaruta1.calcularTotalKilometros());
    console.log("El total de kilometros recorridos en la hoja 2 es: ", hojaruta2.calcularTotalKilometros());
    console.log("El total de kilometros recorridos en la hoja 3 es: ", hojaruta3.calcularTotalKilometros());

    console.log(
        "El total de kilometros recorridos por el vehiculo entre 23/09/25 al 25/09/25 es: ",
        vehiculo1.calcularTotalKilometrosRecorridos(new Date("2025-09-23"), new Date("2025-09-25"))
    )

    
    
    


