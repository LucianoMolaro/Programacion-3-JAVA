import { Factura } from "./Factura";
import { Articulo } from "./Articulo";
import { Cliente } from "./Cliente";
import { DetalleFactura } from "./DetalleFactura";

const cliente1 = new Cliente(1001, 20432492430, "Consumidor final");

const articulo1 = new Articulo(2222, 1000, "Pantalon", "cm");
const articulo2 = new Articulo(3333, 2000, "Campera", "cm");
const articulo3 = new Articulo(4444, 3000, "Zapatillas", "cm");
const articulo4 = new Articulo(5555, 4000, "Remera", "cm");
const articulo5 = new Articulo(6666, 5000, "Lentes", "cm");

const factura1 = new Factura("A", 7777, "E", new Date("2025-09-25"));
const factura2 = new Factura("A", 8888, "TC", new Date("2025-09-26"));
const factura3 = new Factura("A", 9999, "TD", new Date("2025-09-27"));

cliente1.agregarFactura(factura1);
cliente1.agregarFactura(factura2);
cliente1.agregarFactura(factura3);

const detalleFactura1 = new DetalleFactura(2);
detalleFactura1.calcularSubtotal();
const detalleFactura2 = new DetalleFactura(2);
detalleFactura2.calcularSubtotal();
const detalleFactura3 = new DetalleFactura(3);
detalleFactura3.calcularSubtotal();
const detalleFactura4 = new DetalleFactura(4);
detalleFactura4.calcularSubtotal();
const detalleFactura5 = new DetalleFactura(5);
detalleFactura5.calcularSubtotal();
const detalleFactura6 = new DetalleFactura(6);
detalleFactura6.calcularSubtotal();

factura1.agregarDetalleFactura(detalleFactura1);
factura1.agregarDetalleFactura(detalleFactura2);

factura2.agregarDetalleFactura(detalleFactura3);
factura2.agregarDetalleFactura(detalleFactura4);

factura3.agregarDetalleFactura(detalleFactura5);
factura3.agregarDetalleFactura(detalleFactura6);

const metodo1 = [
  detalleFactura1.subtotal,
  detalleFactura2.subtotal,
  detalleFactura3.subtotal,
  detalleFactura4.subtotal,
  detalleFactura5.subtotal,
  detalleFactura6.subtotal,
];

const metodo2 = [
  factura1.calcularTotalItems,
  factura2.calcularTotalItems,
  factura3.calcularTotalItems,
];

const metodo3 = [
  factura1.calcularTotalFinal,
  factura2.calcularTotalFinal,
  factura3.calcularTotalFinal,
];

const metodo4 = [cliente1.totalFacturadoXTipoPago("E")];

const datos = ["Auto", "Moto", "Camion"];

// Busco el contenedor en el HTML
const output = document.getElementById("output");

if (output) {
  output.innerHTML =
    "<ul>" + datos.map((d) => `<li>${d}</li>`).join("") + "</ul>";
}
