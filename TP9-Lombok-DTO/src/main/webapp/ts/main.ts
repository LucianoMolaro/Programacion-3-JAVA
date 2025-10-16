const boton = document.getElementById("comenzar");
if(boton){
    boton.addEventListener("click", async ()=>{
        const div = document.querySelector(".botonIniciar");
        div?.classList.add('botonIniciar--ocultar'); 
    
    
        const table = document.querySelector("section");
        table?.classList.remove("info--ocultar");   

        await cargarPedidos();
        await cargarTabla();
    })

    

}

async function cargarPedidos() {
    const respuesta = await fetch("http://localhost:3000/SvPedido/CrearPedidos", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({})
        });
}

async function cargarTabla() {
    const respuesta = await fetch("http://localhost:3000/SvPedido/", {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        });

    const pedidos = await respuesta.json();
    const tbody = document.getElementById("pedidos");
    if (tbody) {tbody.innerHTML = "";

        pedidos.forEach((pedido: { id: any; nombre: any; precioTotal: any; }) => {
            const tr = document.createElement("tr");

            tr.innerHTML = `
                <td>${pedido.id}</td>
                <td>${pedido.nombre}</td>
                <td>${pedido.precioTotal}</td>
                <td>
                    <button onclick="verDetalle(${pedido.id})" id="modalbtn"><img src="./WEB-INF/images/iconoInfo"></img></button>
                </td>
            `;
            tbody.appendChild(tr);
        })
    }    
}

async function verDetalle(id: any) {
    const respuesta = await fetch(`http://localhost:3000/SvPedido/ObtenerDetallePedido?id=${id}`, {
            method: "GET",
            headers: { "Content-Type": "application/json" }
    });

    const abrirModal = document.getElementById("modalbtn")
    if(abrirModal) abrirModal.addEventListener("click", ()=>{
        const div = document.querySelector(".modal")
        div?.classList.add("modalbtn--aparecer")
    })

    const productos = await respuesta.json();
    const ul = document.getElementById("detalleProductos");
    if(ul) ul.innerHTML = ""; 

    productos.forEach((p: { nombre: any; precio: any; }) => {
        const li = document.createElement("li");
        li.textContent = `${p.nombre} - ${p.precio}`;
        if(ul) ul.appendChild(li);
    });

}

