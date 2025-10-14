let criterio = "descLegajo";
const botones = document.querySelectorAll("button[data-orden]");


document.addEventListener("DOMContentLoaded", async () => {
    
    // const response = await fetch(obtenerEmpleados());
    const listaEmp = await obtenerEmpleados();
    mostrarEmpleados(listaEmp);
    // const btnOrdenar = document.get("#")





    const botonGuardar = document.getElementById("Guardar");
    if (botonGuardar) botonGuardar.addEventListener("click", guardarEmpleado)


});

function mostrarEmpleados(listaEmpleados) {

  const info = document.querySelector("#resultados");
  info.innerHTML = ""; // vaciamos primero

  listaEmpleados.forEach(emp => {
    const div = document.createElement("div#tabla-resultados");

    div.innerHTML = `
      <p>${emp.legajo}</p>
      <p>${emp.nombre}</p>
      <p>${emp.apellido}</p>
      <p>${emp.dni}</p>
      <p>${emp.sector}</p>
      <p>${formatearFecha(emp.fechaIngreso)}</p>
      <p>${emp.activo ? "Sí" : "No"}</p>
    `;

    const div2 = document.createElement("div#eliminar-editar");

    div2.innerHTML = `
        <button type="button" class="btnConfirmar">x</button>
        <button type="button" class="btnConfirmar">x</button>
    `;

    info.appendChild(div);
    info.appendChild(div2);
  });
}

function formatearFecha(fechaISO) {
  const fecha = new Date(fechaISO);
  return fecha.toLocaleDateString("es-AR"); // o "es-ES" según preferencia
}

async function guardarEmpleado() {
        const nombre = document.getElementById("nombre").value.trim();
        const apellido = document.getElementById("apellido").value.trim();
        const dni = document.getElementById("dni").value.trim();
        const sector = document.getElementById("sector").value.trim();
        const legajo = document.getElementById("legajo").value.trim();
        const fechaIngreso = document.getElementById("fechaIngreso").value;
        const activo = document.getElementById("activo").value;

        if (!legajo || !nombre || !apellido || !dni || !sector || !fechaIngreso) {
            alert("Por favor, complete todos los campos.");
            return;
        }

        const datosEmpleado = {
            legajo,
            nombre,
            apellido,
            dni,
            sector,
            fechaIngreso,
            activo
        };

        try {
            const respuesta = await fetch("http://localhost:3000/empleados", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(datosEmpleado)
            });

            if (respuesta.ok) {
                const resultado = await respuesta.json();
                console.log("Empleado cargado correctamente:", resultado);
                alert("Empleado guardado correctamente ✅");
                window.location.href = "/empleados";
            } else {
                console.error("Error al guardar empleado:", respuesta.statusText);
                alert("Error al guardar el empleado ❌");
            }
        } catch (error) {
            console.error("Error de conexión:", error);
            alert("No se pudo conectar con el servidor.");
        }
};

async function editarEmpleado(){}

async function eliminarEmpleado(){}

async function darAlta(){}

async function obtenerEmpleados(){
    const response = await fetch("/api/empleados");
    // if (!response.ok) throw new Error("Error al traer los empleados");
    const empleados = await response.json();
    return empleados;
}


function ordenarAsc(criterio){
    switch(criterio){
        case 'descLegajo': const descl = document.g
    }
}

function aparecer(){
    
}



