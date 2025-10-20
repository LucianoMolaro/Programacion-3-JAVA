// var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
//     function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
//     return new (P || (P = Promise))(function (resolve, reject) {
//         function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
//         function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
//         function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
//         step((generator = generator.apply(thisArg, _arguments || [])).next());
//     });
// };
document.addEventListener("DOMContentLoaded", ()=>{
    const boton = document.getElementById("comenzar");
    if (boton) {
        boton.addEventListener("click", cargarPedidos)
    };
})


async function cargarPedidos() {
    alert("Llego a la funcion")
    const resultado = await fetch("http://localhost:8080/Lombok-DTO/SvPedido/CrearPedidos", {
        method: "POST",
        headers: {
            "content-Type": "application/json"
        }, 
        body: JSON.stringify({})
    })

    if(resultado.ok){
        alert("se cargo")
    }
}
// function cargarTabla() {
//     return __awaiter(this, void 0, void 0, function* () {
//         const respuesta = yield fetch("http://localhost:3000/SvPedido/", {
//             method: "GET",
//             headers: {
//                 "Content-Type": "application/json"
//             }
//         });
//         const pedidos = yield respuesta.json();
//         const tbody = document.getElementById("pedidos");
//         if (tbody) {
//             tbody.innerHTML = "";
//             pedidos.forEach((pedido) => {
//                 const tr = document.createElement("tr");
//                 tr.innerHTML = `
//                 <td>${pedido.id}</td>
//                 <td>${pedido.nombre}</td>
//                 <td>${pedido.precioTotal}</td>
//                 <td>
//                     <button onclick="verDetalle(${pedido.id})" id="modalbtn"><img src="./WEB-INF/images/iconoInfo"></img></button>
//                 </td>
//             `;
//                 tbody.appendChild(tr);
//             });
//         }
//     });
// }
// function verDetalle(id) {
//     return __awaiter(this, void 0, void 0, function* () {
//         const respuesta = yield fetch(`http://localhost:3000/SvPedido/ObtenerDetallePedido?id=${id}`, {
//             method: "GET",
//             headers: { "Content-Type": "application/json" }
//         });
//         const abrirModal = document.getElementById("modalbtn");
//         if (abrirModal)
//             abrirModal.addEventListener("click", () => {
//                 const div = document.querySelector(".modal");
//                 div === null || div === void 0 ? void 0 : div.classList.add("modalbtn--aparecer");
//             });
//         const productos = yield respuesta.json();
//         const ul = document.getElementById("detalleProductos");
//         if (ul)
//             ul.innerHTML = "";
//         productos.forEach((p) => {
//             const li = document.createElement("li");
//             li.textContent = `${p.nombre} - ${p.precio}`;
//             if (ul)
//                 ul.appendChild(li);
//         });
//     });
// }
// export {};
